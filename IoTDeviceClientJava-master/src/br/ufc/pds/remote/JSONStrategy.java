package br.ufc.pds.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import br.ufc.pds.iot.model.Sensor;
import br.ufc.pds.remote.interfaces.ISerializationStrategy;
import br.ufc.pds.remote.model.Request;
import br.ufc.pds.remote.model.Response;

public class JSONStrategy implements ISerializationStrategy {
	
	public Response deserialize(String json) throws Exception{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Sensor.class, new InterfaceAdapter<Object>());
		
		Gson customGson = gsonBuilder.create();  
		return customGson.fromJson(json, Response.class);
	}
	
	
	public String serialize(Request request) throws Exception{
		Gson gson = new Gson();
		return gson.toJson(request);
	}
	
}
