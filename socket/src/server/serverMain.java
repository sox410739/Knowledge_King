package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class serverMain {
	
	private String serverName = null;
	private int serverPort = 0;
	private static ArrayList<connectingClient> allClient = new ArrayList<connectingClient>();
	private static Map<String, accountData> allAccount = new HashMap<>();
	private static ArrayList<String[]> allQuestion = new ArrayList<String[]>();
	private static FileInputStream Finput = null;
	private static FileOutputStream Foutput = null;
	
	public serverMain(String name, int port) {
		serverName = name;
		serverPort = port;
	}
	
	public void start(){
		
		InetSocketAddress serverSocketAddress = new InetSocketAddress(serverName, serverPort);		
		String localAddress = serverSocketAddress.getAddress().getHostAddress();
		
		try(ServerSocket serverSocket = new ServerSocket()) {
			
			System.out.println("Bind server socekt to " + localAddress + ":" + serverPort);
			serverSocket.bind(serverSocketAddress);
			System.out.println("Multithreading server binding success");
			
			while(true) {
				Socket socket = serverSocket.accept();
				connectingClient newClient = new connectingClient(socket);
				allClient.add(newClient);
				Thread thread = new Thread(new ClientHandlingTask(newClient));
				thread.start();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Server shutdown.");
		}
		
	}
	
	private class ClientHandlingTask implements Runnable {
		private connectingClient client = null;
		
		public ClientHandlingTask(connectingClient cc) {
			client = cc;
		}
		
		@Override
		public void run() {			
			InetSocketAddress clientSocketAddress = (InetSocketAddress)client.getSocket().getRemoteSocketAddress();
			String clientAddress = clientSocketAddress.getAddress().getHostAddress();
			int clientPort = clientSocketAddress.getPort();
			System.out.println("Connecting to " + clientAddress + ":" + clientPort);
			String str = null;
			try{
				InputStream inputStream = client.getSocket().getInputStream();
				OutputStream outputStream = client.getSocket().getOutputStream();
				BufferedReader input = new BufferedReader(new InputStreamReader(inputStream, "Cp950"));
				BufferedWriter output = new BufferedWriter(new OutputStreamWriter(outputStream, "Cp950"));
				char[] buf = new char[1024];
				
				int length = input.read(buf);
				str = new String(buf, 0, length);
				System.out.println(str);
				while(length > 0) {
					if(str.charAt(0) == 'R') { //message for regist
						//System.out.println("hi");
						regist(str, output);
					}
					else if(str.charAt(0) == 'L') { //for login
						login(str, output);
					}
					else if(str.charAt(0) == 's') {//for search
						//System.out.println("hi");
						new Thread(new searchingTask(client, str.charAt(9))).start();
					}
					else if(str.equals("interruptSearching")) {//interruptSearching
						for(int i=0;i<client.getReady().length;i++) {
							client.getReady()[i] = false;
						}
						str = new String("interruptSearching");
						output.write(str);
						output.flush();
					}
					else if(str.charAt(0) == 'N') {//pass name
						BufferedWriter enemyOutput = new BufferedWriter(new OutputStreamWriter(allClient.get(client.getConnecting()).getSocket().getOutputStream(), "Cp950"));
						enemyOutput.write(str);
						enemyOutput.flush();
					}
					else if(str.charAt(0) == 'Q') {
						//question
						if(client.getConnecting() < allClient.indexOf(client)) {
							length = input.read(buf);
							str = new String(buf, 0, length);
							System.out.println(str);
							continue;
						}
						int question = Integer.parseInt("" + str.charAt(1)) - 1;
						System.out.println(question);
						BufferedWriter enemyOutput = new BufferedWriter(new OutputStreamWriter(allClient.get(client.getConnecting()).getSocket().getOutputStream(), "Cp950"));
						Random rd = new Random();
						str = "Q " + allQuestion.get(question)[rd.nextInt(allQuestion.get(question).length)];
						output.write(str);
						output.flush();
						enemyOutput.write(str);
						enemyOutput.flush();
					}
					else if(str.charAt(0) == 'O') {
						//pass option to enemy
						BufferedWriter enemyOutput = new BufferedWriter(new OutputStreamWriter(allClient.get(client.getConnecting()).getSocket().getOutputStream(), "Cp950"));
						enemyOutput.write(str);
						enemyOutput.flush();
					}
					else if(str.equals("disconnect")) {
						//end connect
						output.write(str);
						output.flush();
						client.setConnecting(-1);
					}
					else if(str.equals("CloseSocket")) {
						//close
						if(client.getConnecting() != -1) {
							output.write("disconnect");
							output.flush();
						}
						client.getSocket().close();
						allClient.remove(client);
						break;
					}
					else if(str.charAt(0) == 'C') {
						//change data
						str = str.substring(2);
						accountData temp = new accountData(str);
						allAccount.remove(temp.getAccount());
						allAccount.put(temp.getAccount(), temp);
						writeToFile();
					}
					else if(str.charAt(0) == 'M') {
						//message
						BufferedWriter enemyOutput = new BufferedWriter(new OutputStreamWriter(allClient.get(client.getConnecting()).getSocket().getOutputStream(), "Cp950"));
						enemyOutput.write(str);
						enemyOutput.flush();
					}
					input = new BufferedReader(new InputStreamReader(inputStream, "Cp950"));
					output = new BufferedWriter(new OutputStreamWriter(outputStream, "Cp950"));
					length = input.read(buf);
					str = new String(buf, 0, length);
					System.out.println(str);
				}
				
			} catch(IOException | InterruptedException e1) {
				e1.printStackTrace();
			} finally {
				try{
					client.getSocket().close();
				} catch(IOException e2){}
				System.out.println("Disconnecting to " + clientAddress + ":" + clientPort);
			}
		}	
	}
	
	public static void accountInitial(){
		char[] buf = new char[64*1024];
		
		try {
			//read account data
			Finput = new FileInputStream("D:\\ProgramFiles\\computer network\\socket\\src\\server\\data\\account.txt");
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(Finput, "Cp950"));
			String temp = null;
			int length = bufReader.read(buf);
			if(length > 0) {
				temp = new String(buf, 0, length);
			}
			if(temp != null) {
				String[] data = temp.split("\r\n");
				for(int i=0;i<data.length;i++) {
					accountData accountFromFile = new accountData(data[i]);
					allAccount.put(accountFromFile.getAccount(), accountFromFile);
				}
			}
			//read question data
			String[] question1 = null;
			String[] question2 = null;
			String[] question3 = null;
			String[] question4 = null;
			Finput = new FileInputStream("D:\\ProgramFiles\\computer network\\socket\\src\\server\\data\\question1.txt");
			bufReader = new BufferedReader(new InputStreamReader(Finput, "Cp950"));
			temp = null;
			length = bufReader.read(buf);
			if(length > 0) {
				temp = new String(buf, 0, length);
			}
			if(temp != null) {
				question1 = temp.split("\r\n");
			}
			
			Finput = new FileInputStream("D:\\ProgramFiles\\computer network\\socket\\src\\server\\data\\question2.txt");
			bufReader = new BufferedReader(new InputStreamReader(Finput, "Cp950"));
			temp = null;
			length = bufReader.read(buf);
			if(length > 0) {
				temp = new String(buf, 0, length);
			}
			if(temp != null) {
				question2 = temp.split("\r\n");
			}
			
			Finput = new FileInputStream("D:\\ProgramFiles\\computer network\\socket\\src\\server\\data\\question3.txt");
			bufReader = new BufferedReader(new InputStreamReader(Finput, "Cp950"));
			temp = null;
			length = bufReader.read(buf);
			if(length > 0) {
				temp = new String(buf, 0, length);
			}
			if(temp != null) {
				question3 = temp.split("\r\n");
			}
			
			Finput = new FileInputStream("D:\\ProgramFiles\\computer network\\socket\\src\\server\\data\\question4.txt");
			bufReader = new BufferedReader(new InputStreamReader(Finput, "Cp950"));
			temp = null;
			length = bufReader.read(buf);
			if(length > 0) {
				temp = new String(buf, 0, length);
			}
			if(temp != null) {
				question4 = temp.split("\r\n");
			}
			Finput.close();
			bufReader.close();
			
			allQuestion.add(question1);
			allQuestion.add(question2);
			allQuestion.add(question3);
			allQuestion.add(question4);
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void regist(String catchMessage, BufferedWriter output) throws IOException {
		String[] temp = catchMessage.split(" ");
		String acc = temp[1];
		String pas = temp[2];
		if(allAccount.containsKey(acc)) {
			String str = "have been register";
			output.write(str);
			output.flush();
			return;
		}
		allAccount.put(acc, new accountData(acc, pas));
		writeToFile();
		String str = "successRegister";
		output.write(str);
		output.flush();
	}
	
	public static void login(String catchMessage, BufferedWriter output) throws IOException, InterruptedException {
		String[] temp = catchMessage.split(" ");
		String acc = temp[1];
		String pas = temp[2];
		if(!allAccount.containsKey(acc) || !allAccount.get(acc).getPassword().equals(pas)) {
			String str = "errorLogin";
			output.write(str);
			output.flush();
			return;
		}
		String str = "successLogin";
		accountData acData = allAccount.get(acc);
		str = str + " " + acData.forPassenge();
		output.write(str);
		output.flush();
	}
	
	public static class searchingTask implements Runnable{
		private connectingClient nowClient = null;
		private int questionNumber;
		
		public searchingTask(connectingClient cc, char num) {
			nowClient = cc;
			questionNumber = Integer.parseInt("" + num);
		}

		@Override
		public void run() {
			//searching
			nowClient.getReady()[questionNumber] = true;
			while(nowClient.getReady()[questionNumber]) {
				for(int i=0;i<allClient.size();i++) {
					if(allClient.get(i).getReady()[questionNumber] && i != allClient.indexOf(nowClient)) {
						try {
							BufferedWriter output = new BufferedWriter(new OutputStreamWriter(allClient.get(i).getSocket().getOutputStream(), "Cp950"));
							String str = new String("connect to " + allClient.indexOf(nowClient));
							Thread.sleep(1000);
							output.write(str);
							output.flush();
							nowClient.getReady()[questionNumber] = false;
							allClient.get(i).setConnecting(allClient.indexOf(nowClient));
							nowClient.setConnecting(i);
							break;
						} catch (IOException | InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
	}
	
	public static void writeToFile() throws IOException {
		Foutput = new FileOutputStream("D:\\ProgramFiles\\computer network\\socket\\src\\server\\data\\account.txt");
		BufferedWriter buffWriter = new BufferedWriter(new OutputStreamWriter(Foutput, "Cp950"));
		for(String str : allAccount.keySet()) {
			buffWriter.write(allAccount.get(str).forTxt());
			buffWriter.flush();
		}
	}
	
	public static void main(String[] args) throws IOException {			
		String serverName = "127.0.0.1";
		int serverPort = 12000;
		
		if(args.length >= 2) {
			serverName = args[0];
			try {
				serverPort = Integer.parseInt(args[1]);
			} catch(NumberFormatException e) {} 
		}
		accountInitial();
		
		serverMain server = new serverMain(serverName, serverPort);
		server.start();
		
	}
	
}