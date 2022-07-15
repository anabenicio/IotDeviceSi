package br.ufc.pds.remote.model;

import br.ufc.pds.models.Sensor;

public class Response {

	RemoteException exception;
	Sensor sensor;
	
	public RemoteException getException() {
		return exception;
	}
	
	public void setException(RemoteException exception) {
		this.exception = exception;
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	@Override
	public String toString() {
		return "Response [exception=" + exception + ", sensor=" + sensor + "]";
	}
	
}
