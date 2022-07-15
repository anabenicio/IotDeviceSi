package br.ufc.pds.remote;

import org.json.JSONObject;

import com.google.gson.Gson;

import br.ufc.pds.iot.service.IIotService;
import br.ufc.pds.iot.service.IoTService;
import br.ufc.pds.iot.service.ServicesProvider;
import br.ufc.pds.models.Sensor;

public class RemoteInterfaceProxy implements IRemoteInterfaceProxy {

	IIotService service = ServicesProvider.provideIoTService();
	
	public String processData(String data, String host){
		
		Request request = JSONParser.fromJSON(data);
		Response response = new Response();
		
		if(request.getMethod() == null){
			response.setException(new RemoteException("MethodNotFound"));
			return JSONParser.toJSON(response);
		}
		
		if(request.getMethod() == "createSensor" || request.getMethod().equals("createSensor")){
			String type = request.getType();
			
			if(type == null){
				response.setException(new RemoteException("TypeNotFound"));
				return JSONParser.toJSON(response);
			}
			
			try {
				Sensor s = service.createSensor(type, host);
				response.setSensor(s);
				return JSONParser.toJSON(response);
			} catch (Exception e) {
				RemoteException re = new RemoteException(e.getMessage());
				re.setStack(e.getStackTrace().toString());
				response.setException(re);
				return JSONParser.toJSON(response);
			}
			
		}
		else if(request.getMethod() == "getSensor" || request.getMethod().equals("getSensor")){
			
			String identifier = request.getIdentifier();
			
			if(identifier == null){
				response.setException(new RemoteException("IdentifierNotFound"));
				return JSONParser.toJSON(response);
			}
			
			try {
				Sensor s = service.getSensor(identifier);
				response.setSensor(s);
				return JSONParser.toJSON(response);
			} catch (Exception e) {	
				RemoteException re = new RemoteException(e.getMessage());
				re.setStack(e.getStackTrace().toString());
				response.setException(re);
				return JSONParser.toJSON(response);
			}
			
		}else{
			response.setException(new RemoteException("MethodNotFound"));
			return JSONParser.toJSON(response);
		}
		
	}
	
}
