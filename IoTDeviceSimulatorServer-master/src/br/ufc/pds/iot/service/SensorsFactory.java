package br.ufc.pds.iot.service;

import br.ufc.pds.models.Sensor;
import br.ufc.pds.models.SensorAmbiente;
import br.ufc.pds.models.SensorEletricidade;
import br.ufc.pds.models.SensorPessoa;
import br.ufc.pds.models.SensorVeiculo;

public class SensorsFactory {
	
	public static Sensor createSensor(String type, String host) throws Exception{

		Sensor s = null;
		
		if(type.equals("SensorPessoa")){
			s = new SensorPessoa(host);
		}
		else if(type.equals("SensorVeiculo")){
			s = new SensorVeiculo(host);
		}
		else if(type.equals("SensorAmbiente")){
			s = new SensorAmbiente(host);
		}
		else if(type.equals("SensorEletricidade")){
			s = new SensorEletricidade(host);
		}else{
			throw new Exception("SensorNotImplemented");
		}
		
		return s;
	}
	
	
}
