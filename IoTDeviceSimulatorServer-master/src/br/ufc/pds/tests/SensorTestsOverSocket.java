package br.ufc.pds.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import br.ufc.pds.iot.service.ServicesProvider;
import br.ufc.pds.remote.RCPServer;

public class SensorTestsOverSocket {

	RCPServer server = ServicesProvider.provideServer();
	Socket clientSocket;
	private static boolean stab = false;
	String identifier = null;
	
	class ServerRunnable implements Runnable {
		@Override
		public void run() {
			try {
				server.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Before
	public void EstablishRPC() throws Exception{
		if(stab == false){
			System.out.println("Vou Passando e Vou Sarrando");
			ServerRunnable sr = new ServerRunnable();
		    Thread serverThread = new Thread(sr);
		    serverThread.start();
			
			stab = true;
		}
		clientSocket = new Socket("localhost", 3395);
	}
	
	public JSONObject MakeRequest(JSONObject request) throws IOException{
		
		JSONObject response = null;
		Scanner s = new Scanner(clientSocket.getInputStream());
		
		PrintStream ps = new PrintStream(clientSocket.getOutputStream());
		ps.println(request.toString());
		
		String msg = null;
		if(s.hasNextLine()) {
			msg = s.nextLine();
			System.out.println("Recebendo: " + msg);
			response = new JSONObject(msg);
		}
		
		return response;
	}
	
	@Test
	public void RequestWithNoMethod() throws IOException{
		JSONObject request = new JSONObject();
		JSONObject response = MakeRequest(request);
		assertFalse(response.has("exception"));
	}
	
	@Test
	public void CreateSensor() throws IOException {
		JSONObject request = new JSONObject();
		request.put("method", "createSensor");
		request.put("type", "SensorPessoa");
		JSONObject response = MakeRequest(request);
		assertFalse(response.has("exception"));
		assertTrue(response.has("sensor"));
	}
	
	@Test
	public void CreateSensorTypeNotInformed() throws IOException{
		JSONObject request = new JSONObject();
		request.put("method", "createSensor");
		JSONObject response = MakeRequest(request);
		assertFalse(response.has("exception"));
	}
	
	@Test
	public void GetSensorNotInformed() throws IOException{
		JSONObject request = new JSONObject();
		request.put("method", "getSensor");
		JSONObject response = MakeRequest(request);
		
		assertFalse(response.has("exception"));
	}
	
	@Test
	public void GetSensor() throws IOException{
		JSONObject request = new JSONObject();
		request.put("method", "getSensor");
		request.put("identifier", "Mock-10715431");
		JSONObject response = MakeRequest(request);
		assertTrue(response.has("sensor"));
	}
	
}
