package br.ufc.pds.remote;

import br.ufc.pds.ServiceInjector;
import br.ufc.pds.iot.service.interfaces.IIotService;
import br.ufc.pds.models.Sensor;
import br.ufc.pds.remote.interfaces.IRemoteInterfaceProxy;
import br.ufc.pds.remote.interfaces.ISerializationStrategy;
import br.ufc.pds.remote.model.RemoteException;
import br.ufc.pds.remote.model.Request;
import br.ufc.pds.remote.model.Response;

public class RemoteInterfaceProxy implements IRemoteInterfaceProxy {

	IIotService service = ServiceInjector.provideIoTService();
	ISerializationStrategy serialStrategy;
	
	public String processData(String data, String host){
		
		Request request = serialStrategy.deserialize(data);
		Response response = new Response();
		
		if(request.getMethod() == null){
			response.setException(new RemoteException("MethodNotFound"));
			return serialStrategy.serialize(response);
		}
		
		if(request.getMethod() == "createSensor" || request.getMethod().equals("createSensor")){
			String type = request.getType();
			
			if(type == null){
				response.setException(new RemoteException("TypeNotFound"));
				return serialStrategy.serialize(response);
			}
			
			try {
				Sensor s = service.createSensor(type, host);
				response.setSensor(s);
				return serialStrategy.serialize(response);
			} catch (Exception e) {
				RemoteException re = new RemoteException("ServerException");
				re.setStack(e.getStackTrace().toString());
				response.setException(re);
				return serialStrategy.serialize(response);
			}
			
		}
		else if(request.getMethod() == "getSensor" || request.getMethod().equals("getSensor")){
			
			String identifier = request.getIdentifier();
			
			if(identifier == null){
				response.setException(new RemoteException("IdentifierNotFound"));
				return serialStrategy.serialize(response);
			}
			
			try {
				Sensor s = service.getSensor(identifier);
				response.setSensor(s);
				return serialStrategy.serialize(response);
			} catch (Exception e) {	
				RemoteException re = new RemoteException("ServerException");
				re.setStack(e.getStackTrace().toString());
				response.setException(re);
				return serialStrategy.serialize(response);
			}
			
		}else{
			response.setException(new RemoteException("MethodNotFound"));
			return serialStrategy.serialize(response);
		}
		
	}
	
}
