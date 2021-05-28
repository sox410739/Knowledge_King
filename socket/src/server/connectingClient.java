package server;

import java.net.Socket;

public class connectingClient {
	private Socket socket;
	private boolean[] ready;
	private int connecting;
	
	public connectingClient(Socket s) {
		socket = s;
		ready = new boolean[5];
		for(int i=0;i<5;i++) {
			ready[i] = false;
		}
		connecting = -1;
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	public boolean[] getReady() {
		return ready;
	}
	
	public int getConnecting() {
		return connecting;
	}
	
	public void setConnecting(int i) {
		connecting = i;
	}
}
