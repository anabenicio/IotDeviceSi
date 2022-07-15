package br.ufc.pds.iot.model;

public interface Sensor {
	public String getIdentifier();
	public float getLatitude();
	public float getLongitude();
	public String toString();
}
