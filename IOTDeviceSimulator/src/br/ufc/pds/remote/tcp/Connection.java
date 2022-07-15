package br.ufc.pds.remote.tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import br.ufc.pds.ServiceInjector;
import br.ufc.pds.remote.interfaces.IRemoteInterfaceProxy;

class Connection implements Runnable {

	Socket client;
	TCPServer server;
	IRemoteInterfaceProxy proxy = ServiceInjector.provideRemoteInterfaceProxy();
	Scanner s;

	public Connection(Socket client, TCPServer server) {
		this.client = client;
		this.server = server;
	}

	public void run() {
		try{
			s = new Scanner(this.client.getInputStream());
			String msg = null;
			while (s.hasNextLine()) {
				msg = s.nextLine();
				String resp = proxy.processData(msg, client.getInetAddress().getHostAddress());
				reply(resp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void reply(String msg) {
		try {
			PrintStream ps = new PrintStream(client.getOutputStream());
			ps.println(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stop(){
		s.close();
	}
}