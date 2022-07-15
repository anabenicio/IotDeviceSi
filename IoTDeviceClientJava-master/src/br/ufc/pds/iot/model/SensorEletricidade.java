package br.ufc.pds.iot.model;

public class SensorEletricidade implements Sensor {

	public String identifier;
	public float latitude;
	public float longitude;
	
	public float tensao; 
	public float corrente;
	public float consumo; 

	@Override
	public String getIdentifier() {
		return this.identifier;
	}

	@Override
	public float getLatitude() {
		return this.latitude;
	}

	@Override
	public float getLongitude() {
		return this.longitude;
	}

	@Override
	public String toString() {
		return "SensorEletricidade [ identifier=" + identifier + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", tensao=" + tensao + ", corrente=" + corrente + ", consumo=" + consumo
				+ "]";
	}



	
	
}