package br.ufc.pds.iot.service;

import br.ufc.pds.models.Sensor;

public interface IIotService {
	Sensor createSensor(String type, String host) throws Exception;
	Sensor getSensor(String identifier) throws Exception;
}
