package br.ufc.pds.iot.service;

import br.ufc.pds.models.Sensor;
import br.ufc.pds.view.MainWindow;

public class IoTService implements IIotService {
	
	IIoTRepository collection = ServicesProvider.provideSensorCollection();
	
	public Sensor createSensor(String type, String host) throws Exception {
		System.out.println("Criando sensor: "+type);
		Sensor s = SensorsFactory.createSensor(type, host);
		collection.add(s);
		return s;
	}

	public Sensor getSensor(String identifier) throws Exception{
		System.out.println("Sensor: "+identifier);
		return (Sensor) collection.find(identifier);
	}
	
}
