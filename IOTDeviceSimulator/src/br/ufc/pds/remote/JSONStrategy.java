package br.ufc.pds.remote;

import com.google.gson.Gson;

import br.ufc.pds.remote.interfaces.ISerializationStrategy;
import br.ufc.pds.remote.model.Request;
import br.ufc.pds.remote.model.Response;

public class JSONStrategy implements ISerializationStrategy {

	public Request deserialize(String json){
		Gson gson = new Gson();
		return gson.fromJson(json, Request.class);
	}
	
	public String serialize(Response response){
		Gson gson = new Gson(); 
		return gson.toJson(response);
	}
	
}
