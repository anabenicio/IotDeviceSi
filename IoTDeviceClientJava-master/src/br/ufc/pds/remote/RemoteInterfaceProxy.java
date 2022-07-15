package br.ufc.pds.remote;

import br.ufc.pds.iot.model.Sensor;
import br.ufc.pds.remote.interfaces.ISerializationStrategy;
import br.ufc.pds.remote.interfaces.RPCClient;
import br.ufc.pds.remote.model.Request;
import br.ufc.pds.remote.model.Response;

public class RemoteInterfaceProxy {

	static RPCClient client_ = null;
	static ISerializationStrategy parser = new JSONStrategy();
	
	public static void setRCPClient(RPCClient client){
	     if(client_ == null){
	    	 client_ = client;
	     }
	}
	
	public static Sensor createSensor(String type) throws Exception{
		Request request = new Request();
		request.setMethod("createSensor");
		request.setType(type);
		
		client_.send(parser.serialize(request));
		String data = client_.receive();
		
		Response response = parser.deserialize(data);
		if(response.getException() != null){
			throw new Exception(response.getException().getMessage());
		}
		
		return response.getSensor();
	}
	
	public static Sensor getSensor(Sensor s) throws Exception{
		Request request = new Request();
		request.setMethod("getSensor");
		request.setIdentifier(s.getIdentifier());
		
		client_.send(parser.serialize(request));
		String data = client_.receive();
		
		Response response = parser.deserialize(data);
		if(response.getException() != null){
			throw new Exception(response.getException().getMessage());
		}
		
		return response.getSensor();
	}
	
}
