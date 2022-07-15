package br.ufc.pds.remote;

import com.google.gson.Gson;

public class JSONParser {

	public static Request fromJSON(String json){
		Gson gson = new Gson();
		return gson.fromJson(json, Request.class);
	}
	
	public static String toJSON(Response response){
		Gson gson = new Gson(); 
		return gson.toJson(response);
	}
	
}
