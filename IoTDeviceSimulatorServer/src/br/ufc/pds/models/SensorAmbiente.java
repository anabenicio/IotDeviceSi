package br.ufc.pds.models;

import java.util.Random;

import com.google.gson.annotations.Expose;

public class SensorAmbiente extends Thread implements Sensor{

	transient Random gerador = new Random();
	transient Thread thread;
	
	transient String host = null;
	
	@Expose public String type = this.getClass().getSimpleName();
	@Expose public String identifier = "Ambiente-" + this.hashCode();
	
	@Expose public float latitude = 0;
	@Expose public float longitude = 0;
	
	@Expose public float temperatura = 23;
	@Expose public float velocidade_vento = 1;
	@Expose public float pressao_atm = 0;
	@Expose public float nivel_luminosidade = 0;
	@Expose public float nivel_ruido = 85; //dB
	@Expose public float nivel_co2 = 0;
	@Expose public float nivel_gas = 0;
	@Expose public float nivel_umidade = 0;
	
	transient private float TemperaturaMax;
	transient private float TemperaturaMin;
	transient private float Velocidade_VentoMax;
	transient private float Velocidade_VentoMin;
	transient private float Pressao_AtmMax;
	transient private float Pressao_AtmMin;
	transient private float Nivel_LuminosidadeMax;
	transient private float Ninel_LuminosidadeMin;
	transient private float Nivel_RuidoMax;
	transient private float Nivel_RuidoMin;
	transient private float Nivel_Co2Max;
	transient private float Nivel_Co2Min;
	transient private float Nivel_GasMax;
	transient private float Nivel_GasMin;
	transient private float Nivel_UmidadeMax;
	transient private float Nivel_UmidadeMin;
	
	public SensorAmbiente(String host){
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
		return "Ambiente-"+this.hashCode();
	}

	@Override
	public String getHost() {
		return this.host;
	}

	@Override
	public float getLatitude() {
		return latitude;
	}

	@Override
	public float getLongitude() {
		return longitude;
	}
//-------------------------------------
	
	public void eventoTemperaturaAlta(){
		this.TemperaturaMax = 60;
		this.TemperaturaMin = 40;
	}
	
	public void eventoTemperaturaNormal(){
		this.TemperaturaMax = 39;
		this.TemperaturaMax = 20;
	}
	
	
	public void eventoTemperaturaBaixa(){
		this.TemperaturaMax = 19;
		this.TemperaturaMin = 0;
	}
	
	public void eventoVelocidade_VentoAlta(){
		this.Velocidade_VentoMax = 60;
		this.Velocidade_VentoMin = 30;
	}
	
	public void eventoVelocidade_VentoNormal(){
		this.Velocidade_VentoMax = 29;
		this.Velocidade_VentoMin = 15;
	}
	
	public void eventoVelocidade_VentoBaixa(){
		this.Velocidade_VentoMax = 14;
		this.Velocidade_VentoMin = 1;
	}
	
	public void eventoPressao_atmAlta(){
		this.Pressao_AtmMax = 270; 
		this.Pressao_AtmMin = 915;
	}
	
	public void eventoPressao_atmNormal(){
		this.Pressao_AtmMax = 1033;
		this.Pressao_AtmMin = 914;
	}
	
	public void eventoPressao_atmBaixa(){
		this.Pressao_AtmMax = 0;
		this.Pressao_AtmMin = 0;
	}
	
	public void eventoNivel_luminosidadeAlta(){
		this.Nivel_LuminosidadeMax = 20000;
		this.Ninel_LuminosidadeMin = 10000;
	}
	
	public void eventoNivel_luminosidadeNormal(){
		this.Nivel_LuminosidadeMax = 9999;
		this.Ninel_LuminosidadeMin = 1000;
	}
	
	public void eventoNivel_luminosidadeBaixa(){
		this.Nivel_LuminosidadeMax = 999;
		this.Ninel_LuminosidadeMin = 20;
	}
	
	public void eventoNivel_ruidoAlto(){
		this.Nivel_RuidoMax = 115;
		this.Nivel_RuidoMin = 94;
	}
	
	public void eventoNivel_ruidoNormal(){
		this.Nivel_RuidoMax = 93;
		this.Nivel_RuidoMin = 88;
	}
	
	public void eventoNivel_ruidoBaixo(){
		this.Nivel_RuidoMax = 87;
		this.Nivel_RuidoMin = 85;
	}
	
	public void eventoNivel_co2Alto(){
		this.Nivel_Co2Max = 600;
		this.Nivel_Co2Min = 400;
	}
	
	public void eventoNivel_co2Normal(){
		this.Nivel_Co2Max = 399;
		this.Nivel_Co2Min = 340;
	}
	
	public void eventoNivel_co2Baixo(){
		this.Nivel_Co2Max = 339;
		this.Nivel_Co2Min = 290;
	}
	
	public void eventoNivel_gasAlto(){
		this.Nivel_GasMax = 1500;
		this.Nivel_GasMin = 100;
	}
	
	public void eventoNivel_gasNormal(){
		this.Nivel_GasMax = 49;
		this.Nivel_GasMin = 3;
	}
	
	public void eventoNivel_gasBaixo(){
		this.Nivel_GasMax = 2;
		this.Nivel_GasMin = 0;
	}
	
	public void eventoNivel_umidadeAlta(){
		this.Nivel_UmidadeMax = 90;
		this.Nivel_UmidadeMin = 70;
	}
	
	public void eventoNivel_umidadeNormal(){
		this.Nivel_UmidadeMax = 65;
		this.Nivel_UmidadeMin = 50;
	}
	
	public void eventoNivel_umidadeBaixa(){
		this.Nivel_UmidadeMax = 45;
		this.Nivel_UmidadeMin = 30;
	}
	
	@Override
	public void createEvents() {
		int lot = gerador.nextInt((100 - 1) + 1) + 1;
		if(lot <= 80){
			this.eventoVelocidade_VentoAlta();
			this.eventoPressao_atmAlta();
			this.eventoNivel_ruidoAlto();
			this.eventoNivel_co2Alto();
			this.eventoNivel_gasAlto();
			this.eventoNivel_umidadeAlta();
			this.eventoNivel_luminosidadeAlta();
		}
		else if(lot > 80 && lot < 90){
			this.eventoVelocidade_VentoNormal();
			this.eventoPressao_atmNormal();
			this.eventoNivel_ruidoNormal();
			this.eventoNivel_co2Normal();
			this.eventoNivel_gasNormal();
			this.eventoNivel_umidadeNormal();
			this.eventoNivel_luminosidadeNormal();
		}
		else if(lot >= 90){
			this.eventoVelocidade_VentoBaixa();
			this.eventoPressao_atmBaixa();
			this.eventoNivel_ruidoBaixo();
			this.eventoNivel_co2Baixo();
			this.eventoNivel_gasBaixo();
			this.eventoNivel_umidadeBaixa();
			this.eventoNivel_luminosidadeBaixa();
		}
		
		velocidade_vento = gerador.nextFloat() * (Velocidade_VentoMax - Velocidade_VentoMin) + Velocidade_VentoMin;
		pressao_atm = gerador.nextFloat() * (Pressao_AtmMin - Pressao_AtmMax);
		nivel_umidade = gerador.nextFloat() * (Nivel_UmidadeMax - Nivel_UmidadeMin) + Nivel_UmidadeMin;
		nivel_luminosidade = gerador.nextFloat() * ( Nivel_LuminosidadeMax - Ninel_LuminosidadeMin) + Ninel_LuminosidadeMin;
		nivel_ruido = gerador.nextFloat() * (Nivel_RuidoMax - Nivel_RuidoMin) + Nivel_RuidoMin;
		nivel_co2 = gerador.nextFloat() * (Nivel_Co2Max - Nivel_Co2Min) + Nivel_Co2Min;
		nivel_gas = gerador.nextFloat() * (Nivel_GasMax - Nivel_GasMin) + Nivel_GasMin;
		
	}

	public float getTemperatura() {
		return temperatura;
	}

	public float getVelocidade_vento() {
		return velocidade_vento;
	}

	public float getPressao_atm() {
		return pressao_atm;
	}

	public float getNivel_luminosidade() {
		return nivel_luminosidade;
	}

	public float getNivel_ruido() {
		return nivel_ruido;
	}

	public float getNivel_co2() {
		return nivel_co2;
	}

	public float getNivel_gas() {
		return nivel_gas;
	}

	public float getNivel_umidade() {
		return nivel_umidade;
	}

	

	@Override
	public String toString() {
		return "SensorAmbiente [gerador=" + gerador + ", thread=" + thread + ", host=" + host + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", temperatura=" + temperatura + ", velocidade_vento=" + velocidade_vento
				+ ", pressao_atm=" + pressao_atm + ", nivel_luminosidade=" + nivel_luminosidade + ", nivel_ruido="
				+ nivel_ruido + ", nivel_co2=" + nivel_co2 + ", nivel_gas=" + nivel_gas + ", nivel_umidade="
				+ nivel_umidade + "]";
	}

	@Override
	public String getType() {
		return this.type;
	}
	
}