package br.ufc.pds.iot.service.interfaces;

import br.ufc.pds.models.Sensor;

public interface ISensorsFactory {
	public Sensor createSensor(String type, String host) throws Exception;
}
