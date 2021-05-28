package client;

import java.io.*;
import java.net.*;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ClientMain extends Application{
	
	private static String serverName = null;
	private static int serverPort = 0;
	public static Socket clientSocket = new Socket();
	public static Stage mainStage = new Stage();
	public static Scene mainScene = null;
	
	public static void connection(String name, int port) {
		serverName = name;
		serverPort = port;
	}
	
	public static void start() {
		SocketAddress severSocketAddress = new InetSocketAddress(serverName, serverPort);
		
		try{
			System.out.println("Connect to server " + serverName + ":" + serverPort);
			clientSocket.connect(severSocketAddress, 3000);
			
			InetSocketAddress socketAddress = (InetSocketAddress)clientSocket.getLocalSocketAddress();
			String clientAddress = socketAddress.getAddress().getHostAddress();
			int clientPort = socketAddress.getPort();
			System.out.println("Client " + clientAddress + ":" + clientPort);
			System.out.println("Connecting to server " + serverName + ":" + serverPort);
			
		} catch(IOException e1) {
			e1.printStackTrace();
		} finally {
			System.out.println("Connection shutdown");
		}
	}
	
	public EventHandler<WindowEvent> windowClosed = (e)->{
		try {
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "Cp950"));
			output.write("CloseSocket");
			output.flush();
			Thread.sleep(100);
			clientSocket.close();
		} catch (IOException | InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("Connection closed");
	};
	
	public static void main(String[] args) {	
		String serverName = "127.0.0.1";
		int serverPort = 12000;
		
		if(args.length >= 2) {
			serverName = args[0];
			try {
				serverPort = Integer.parseInt(args[1]);
			} catch(NumberFormatException e) {} 
		}
		
		connection(serverName, serverPort);
		new Thread(()-> {
			launch(args);
		}).start();
		start();
	}

	@Override
	public void start(Stage main) throws Exception {
		Login log = new Login();
		log.gameScreen();
		mainStage.setTitle("ª¾ÃÑ¤ý");
		mainStage.setScene(mainScene);
		mainStage.setResizable(false);;
		mainStage.show();
		mainStage.setOnCloseRequest(windowClosed);
	}
	
}