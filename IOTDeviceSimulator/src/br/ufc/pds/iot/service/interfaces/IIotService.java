package br.ufc.pds.iot.service.interfaces;

import br.ufc.pds.models.Sensor;

public interface IIotService {
	Sensor createSensor(String type, String host) throws Exception;
	Sensor getSensor(String identifier) throws Exception;
}
