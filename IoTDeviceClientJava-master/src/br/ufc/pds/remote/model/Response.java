package br.ufc.pds.remote.model;

import br.ufc.pds.iot.model.Sensor;

public class Response {

	String type;
	RemoteException exception;
	Sensor sensor;
	
	public String getType() {
		return this.type;
	}
	
	public RemoteException getException() {
		return exception;
	}
	
	public void setException(RemoteException exception) {
		this.exception = exception;
	}
	
	public void setSensor(Sensor sensor){
		this.sensor = sensor;
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
	@Override
	public String toString() {
		return "Response [type=" + type + ", exception=" + exception + ", sensor=" + sensor + "]";
	}
	
}
