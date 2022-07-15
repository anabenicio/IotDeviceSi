package br.ufc.pds.iot.client;

import br.ufc.pds.iot.model.Sensor;
import br.ufc.pds.remote.RemoteInterfaceProxy;
import br.ufc.pds.remote.interfaces.RPCClient;

public class IoTService {
	
	public static void setRCPClientTCP(RPCClient client) throws Exception{
		RemoteInterfaceProxy.setRCPClient(client);
	}
	
	public static Sensor createSensorEletricidade() throws Exception{
		return RemoteInterfaceProxy.createSensor("SensorEletricidade");
	}
	
	public static void update(Sensor s) throws Exception {
		s = RemoteInterfaceProxy.getSensor(s);
	}
	
}
