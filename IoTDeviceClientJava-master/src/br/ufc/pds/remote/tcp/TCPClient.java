package br.ufc.pds.remote.tcp;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import br.ufc.pds.remote.interfaces.RPCClient;

public class TCPClient implements RPCClient {

	Socket socket;
	Scanner s;

	public TCPClient(String host) throws Exception{
		this.connect(host);
	}
	
	@Override
	public void connect(String host) throws Exception {
		socket = new Socket(host, 3395);
		System.out.println("Conectado a " + host);
	}

	@Override
	public void send(String data) throws Exception {
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println(data);
	}

	@Override
	public String receive() throws Exception {
		s = new Scanner(socket.getInputStream());
		String msg = null;
		if(s.hasNextLine()) {
			msg = s.nextLine();
			System.out.println("Recebendo: " + msg);
		}
		return msg;
	}

	@Override
	public void stop() throws Exception {
		s.close();
		socket.close();
	}
	
}