package br.ufc.pds.remote.tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import br.ufc.pds.remote.RCPServer;

public class TCPServer implements RCPServer {

	private int porta = 3395;
	
	public void start() throws IOException  {
		try(ServerSocket servidor = new ServerSocket(this.porta)){
			System.out.println("TCP 3395 Opened!");
	
			while (true) {
				Socket cliente = servidor.accept();
				System.out.println("Connection: " + cliente.getInetAddress().getHostAddress());
				Connection tc = new Connection(cliente, this);
				new Thread(tc).start();
			}
		}
	}

}