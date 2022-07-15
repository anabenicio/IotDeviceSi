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

public class RequestAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T>{

    private static final String CLASSNAME = "type";
    private static final String DATA = "sensor";

    public T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) 
    		throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        
        System.out.println("Request:" + jsonObject);
        
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
        String className = "br.ufc.pds.iot.model."+prim.getAsString();
        
        System.out.println("Classe:" + className);
        Class<?> klass = getObjectClass(className);
        
        return jsonDeserializationContext.deserialize(jsonObject.get(DATA), klass);
    }
    
    public JsonElement serialize(final T jsonElement, Type type, JsonSerializationContext jsonSerializationContext) {
    	JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(CLASSNAME, jsonElement.getClass().getName());
        jsonObject.add(DATA, jsonSerializationContext.serialize(jsonElement));
        return jsonObject;
    }

    public Class<?> getObjectClass(String className) {
    	try {
    		return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e.getMessage());
        }
    }
  
}