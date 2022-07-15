package br.ufc.pds.models;

import java.util.Random;

import com.google.gson.annotations.Expose;

public class SensorEletricidade implements Sensor{

	transient private Random gerador = new Random();
	transient private Thread thread;
	
	transient public String host = null;
	
	@Expose public String type = this.getClass().getSimpleName();
	@Expose public String identifier = "Eletricidade-" + this.hashCode();
	
	@Expose public float latitude = 0;
	@Expose public float longitude = 0;
	
	@Expose public float tensao = 220;
	@Expose public float corrente = 10;
	@Expose public float consumo = 0; 
	
	transient private float tensaoMax;
	transient private float tensaoMin;
	transient private float correnteMax;
	transient private float correnteMin;
	
	public SensorEletricidade(String host) {
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
	
	//-------------------------------------------------------------
	// Eventos
	
	public void eventoCorrenteAlta(){
		this.correnteMax = 50;
		this.correnteMin = 15;
	}
	
	public void eventoCorrenteBaixa(){
		this.correnteMax = 9;
		this.correnteMin = 0;
	}
	
	public void eventoCorrenteNormal(){
		this.correnteMax = 15;
		this.correnteMin = 10;
	}
	
	public void eventoTensaoAlta(){
		this.tensaoMax = 350;
		this.tensaoMin = 250;
	}
	
	public void eventoTensaoBaixa(){
		this.tensaoMax = 80;
		this.tensaoMin = 200;
	}
	
	public void eventoTensaoNormal(){
		this.tensaoMax = 230;
		this.tensaoMin = 200;
	}
	
	public void createEvents(){
		int lot = gerador.nextInt((100 - 1) + 1) + 1;
		if(lot <= 80){
			this.eventoCorrenteNormal();
			this.eventoTensaoNormal();
		}
		else if(lot > 80 && lot < 90){
			this.eventoCorrenteAlta();
			this.eventoTensaoAlta();
		}
		else if(lot >= 90){
			this.eventoCorrenteBaixa();
			this.eventoTensaoBaixa();
		}
			
		tensao = gerador.nextFloat() * (tensaoMax - tensaoMin) + tensaoMin;  
		corrente = gerador.nextFloat() * (correnteMax - correnteMin) + correnteMin;  	
		consumo += tensao * corrente;
	}

	public float getTensao() {
		return tensao;
	}

	public float getCorrente() {
		return corrente;
	}

	public float getConsumo() {
		return consumo;
	}

	@Override
	public String toString() {
		return "SensorEletricidade [host=" + host + ", latitude="
				+ latitude + ", longitude=" + longitude + ", tensao=" + tensao + ", corrente=" + corrente + ", consumo="
				+ consumo + "]";
	}
	
	@Override 
	public String getType() {
		return this.type;
	}
	
}