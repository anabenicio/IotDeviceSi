package br.ufc.pds.iot.service;

import br.ufc.pds.ServiceInjector;
import br.ufc.pds.iot.service.interfaces.IIoTRepository;
import br.ufc.pds.iot.service.interfaces.IIotService;
import br.ufc.pds.iot.service.interfaces.ISensorsFactory;
import br.ufc.pds.models.Sensor;

public class IoTService implements IIotService {
	
	IIoTRepository<Sensor> collection = ServiceInjector.provideSensorCollection();
	ISensorsFactory factory = ServiceInjector.provideSensorsFactory();
	
	public Sensor createSensor(String type, String host) throws Exception {
		System.out.println("Criando sensor: "+type);
		Sensor s = factory.createSensor(type, host);
		collection.add(s);
		return s;
	}

	public Sensor getSensor(String identifier) throws Exception{
		System.out.println("Sensor: "+identifier);
		return (Sensor) collection.find(identifier);
	}
	
}
