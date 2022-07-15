package br.ufc.pds.remote.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import br.ufc.pds.remote.model.RPCServer;

public class TCPServer implements RPCServer {

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