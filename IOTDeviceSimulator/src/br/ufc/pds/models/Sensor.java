package br.ufc.pds.models;

public interface Sensor {
	public String getType();
	public String getIdentifier();
	public String getHost();
	public float getLatitude();
	public float getLongitude();
	public void createEvents();
	public String toString();
}
