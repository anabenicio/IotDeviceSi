package br.ufc.pds.iot.service;

import java.util.ArrayList;
import java.util.List;

import br.ufc.pds.models.Sensor;
import br.ufc.pds.models.SensorEletricidade;

public class SensorRepository implements IIoTRepository<Sensor> {

	List<Sensor> sensors = new ArrayList<Sensor>();
	
	public SensorRepository(){
		this.add(new SensorEletricidade("127.0.0.1"));
	}
	
	public Sensor find(String identifier) throws Exception{
		
		if(identifier == null){
			throw new Exception("IdentifierNotFound.");
		}
		
		for(Sensor s : sensors){
			System.out.println(s.getIdentifier());
			if(s.getIdentifier().equals(identifier)){
				return s;
			}
		}
		
		throw new Exception("SensorNotFound.");
	}
	
	public void add(Sensor sensor){
		sensors.add(sensor);
	}
	
	public List<Sensor> getAll(){
		return this.sensors;
	}
	
}
