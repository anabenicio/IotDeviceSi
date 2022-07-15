package br.ufc.pds.models;

import java.util.Random;

import com.google.gson.annotations.Expose;

public class SensorPessoa extends Thread implements Sensor{
	
	transient private Random gerador = new Random();
	transient private Thread thread;
	
	transient public String host = null;
	
	@Expose public String type = this.getClass().getSimpleName();
	@Expose public String identifier = "Pessoa-" + this.hashCode();
	
	@Expose public float latitude = 0;
	@Expose public float longitude = 0;
	
	@Expose public float temperatura = 37;
	@Expose public float batimento = 70;
	@Expose public float sistole = 12;
	@Expose public float diastole = 8;
	@Expose public float oxigenio = 0;
	
	transient private float temperaturaMax;
	transient private float temperaturaMin;
	transient private float batimentoMax;
	transient private float batimentoMin;
	transient private float diastoleMin;
	transient private float diastoleMax;
	transient private float sistoleMin;
	transient private float sistoleMax;
	transient private float oxigenioMin;
	transient private float oxigenioMax;
	
	
	public SensorPessoa(String host){
		this.host = host;
		
		latitude = gerador.nextFloat() * ((3) - (-30)) + (-30);  
		longitude = gerador.nextFloat() *  ((-36) - (-70)) + (-70);  
		
		this.thread = new Thread(){
		    public void run(){
		    	while(true){
		    		try {
		    			createEvents();
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		    	}
		    }
		};
		
		this.thread.start();
	}

	@Override
	public String getIdentifier() {
		return this.identifier;
	}

	@Override
	public String getHost() {
		return this.host;
	}

	@Override
	public float getLatitude() {
		return this.latitude;
	}

	@Override
	public float getLongitude() {
		return this.longitude;
	}

	

	
	
	//----------------------------------------------------------------
	// Eventos
	
	public void eventoTemperaturaAlta(){
		this.temperaturaMax = 42;
		this.temperaturaMin = 38;
	}
	
	public void eventoTemperaturaBaixa(){
		this.temperaturaMax = 35;
		this.temperaturaMin = 0;
	}
	
	public void eventoTemperaturaNormal(){
		this.temperaturaMax = 37;
		this.temperaturaMin = 36;
	}
	
	public void eventoBatimentoAlto(){
		this.batimentoMax = 206;
		this.batimentoMin = 112;
	}
	
	public void eventoBatimentoNormal(){
		this.batimentoMax = 111;
		this.batimentoMin = 60;
	}
	
	public void eventoBatimentoBaixo(){
		this.batimentoMax=59;
		this.batimentoMin = 2;
	}
	
	public void eventoDiastoleAlta(){
		this.diastoleMax = 180;
		this.diastoleMin = 110;
	}
	
	public void eventoDiastoleNormal(){
		this.diastoleMax = 80;
		this.diastoleMin = 40;
	}
	
	public void eventoDiastoleBaixa(){
		this.diastoleMax = 39;
		this.diastoleMin = 10;
	}
	
	public void eventoSistoleAlta(){
		this.sistoleMax = 200;
		this.sistoleMin = 121;
	}
	
	public void eventoSistoleNormal(){
		this.sistoleMax = 120;
		this.sistoleMin = 90;
	}
	
	public void eventoSistoleBaixa(){
		this.sistoleMax = 89;
		this.sistoleMin = 10;
	}
	
	
	public void eventoOxigenioNormal(){
		this.oxigenioMax = 100;
		this.oxigenioMin = 90;
	}
	
	public void eventoOxigenioBaixo(){
		this.oxigenioMax = 89;
		this.oxigenioMin = 10;
	}
	
	public void eventoHipoxiaOxigenio(){
		this.oxigenioMax = 50;
		this.oxigenioMin = 10;
	}
	
	
	@Override
	public void createEvents() {
		
		int lot = gerador.nextInt((100-1)+1)+1;
		
		if(lot <= 80){
			this.eventoBatimentoAlto();
			this.eventoDiastoleAlta();
			this.eventoTemperaturaAlta();
			this.eventoSistoleAlta();
		}
		else if(lot> 80 && lot < 90){
			this.eventoBatimentoBaixo();
			this.eventoDiastoleBaixa();
			this.eventoOxigenioBaixo();
			this.eventoSistoleBaixa();
			this.eventoTemperaturaBaixa();	
			this.eventoHipoxiaOxigenio();
		}
		else if(lot >= 90){
			this.eventoBatimentoNormal();
			this.eventoDiastoleNormal();
			this.eventoOxigenioNormal();
			this.eventoSistoleNormal();
			this.eventoTemperaturaNormal();
		}
		
		batimento = gerador.nextFloat() * (batimentoMax + batimentoMin);
		diastole = gerador.nextFloat() * (diastoleMax + diastoleMin);
		oxigenio = gerador.nextFloat() * (oxigenioMax + oxigenioMin);
		sistole = gerador.nextFloat() * (sistoleMax + sistoleMin);
		temperatura = gerador.nextFloat() * (temperaturaMax + temperaturaMin);
	}
	
	
	public float getTemperatura() {
		return temperatura;
	}

	public float getSistole() {
		return sistole;
	}

	public float getDiastole() {
		return diastole;
	}

	public float getOxigenio() {
		return oxigenio;
	}

	public float getBatimento(){
		return batimento;
	}
	
	@Override
	public String toString() {
		return "SensorPessoa [host=" + host + ", latitude=" + latitude + ", longitude=" + longitude + ", temperatura="
				+ temperatura + ", batimento=" + batimento + ", sistole=" + sistole + ", diastole=" + diastole
				+ ", oxigenio=" + oxigenio + "]";
	}
	@Override
	public String getType() {
		return this.type;
	}
	
}

