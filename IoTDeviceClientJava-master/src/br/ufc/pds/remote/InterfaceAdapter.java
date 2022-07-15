package br.ufc.pds.remote;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class InterfaceAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T>{

	 private static final String CLASSNAME = "type";
	
	@Override
	public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		
		JsonObject jsonObject = json.getAsJsonObject();
		JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
		
		String className = "br.ufc.pds.iot.model."+prim.getAsString();
        
        System.out.println("Classe:" + className);
        Class<?> klass = getObjectClass(className);
		
		return context.deserialize(jsonObject, klass);
	}

	@Override
	public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Class<?> getObjectClass(String className) {
    	try {
    		return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e.getMessage());
        }
    }

}
