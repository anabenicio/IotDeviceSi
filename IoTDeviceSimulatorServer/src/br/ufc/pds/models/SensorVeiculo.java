package br.ufc.pds.models;

import java.util.Random;

import com.google.gson.annotations.Expose;

public class SensorVeiculo extends Thread implements Sensor {

	transient private Random gerador = new Random();
	transient private Thread thread;
	
	transient public String host = null;
	
	@Expose public String type = this.getClass().getSimpleName();
	@Expose public String identifier = "Veículo-" + this.hashCode();
	
	@Expose public float latitude = 0;
	@Expose public float longitude = 0;
	
	@Expose public float velocidade = 0;
	@Expose public float nivel_gasolina = 0;
	@Expose public float nivel_oleo = 0;
	@Expose public float temp_oleo = 0;
	@Expose public float temp_motor = 25;
	@Expose public float rpm = 0;
	
	transient private float VelocidadeMax;
	transient private float VelocidadeMin;
	transient private float Nivel_GasolinaMax;
	transient private float Nivel_GasolinaMin;
	transient private float Nivel_OleoMax;
	transient private float Nivel_OleoMin;
	transient private float Temperatura_OleoMax;
	transient private float Temperatura_OleoMin;
	transient private float Temperatura_MotorMax;
	transient private float Temperatura_MotorMin;
	transient private float RPM_Max;
	transient private float RPM_Min;
	
	public SensorVeiculo(String host){
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
		return "Veiculo-"+this.hashCode();
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

	//------------------------------------
	//Eventos
	
	public void eventoVelocidadeAlta(){
		this.VelocidadeMax = 200;
		this.VelocidadeMin = 81;
	}
	
	public void eventoVelocidadeNormal(){
		this.VelocidadeMax = 80;
		this.VelocidadeMin = 41;
	}
	
	public void eventoVelocidadeBaixa(){
		this.VelocidadeMax = 40;
		this.VelocidadeMin = 10;
	}
	
	public void eventoGasolinaAlta(){
		this.Nivel_GasolinaMax = 100;
		this.Nivel_GasolinaMin = 80;
	}
	
	public void eventoGasolinaNormal(){
		this.Nivel_GasolinaMax = 79;
		this.Nivel_GasolinaMin = 21;
	}
	
	public void eventoGasolinaBaixa(){
		this.Nivel_GasolinaMax = 20;
		this.Nivel_GasolinaMax = 1;
	}
	
	public void eventoNivelOleoAlto(){
		this.Nivel_OleoMax = 100;
		this.Nivel_OleoMin = 80;
	}
	
	public void eventoNivelOleoNormal(){
		this.Nivel_OleoMax = 79;
		this.Nivel_OleoMin = 50;
	}
	
	public void eventoNivelOleoBaixo(){
		this.Nivel_OleoMax = 49;
		this.Nivel_OleoMin = 10;
	}
	
	public void eventoTemperaturaOleoAlta(){
		this.Temperatura_OleoMax = 50;
		this.Temperatura_OleoMin = 40;
	}
	
	public void eventoTemperaturaOleoNormal(){
		this.Temperatura_OleoMax = 39;
		this.Temperatura_OleoMin = 20;
	}
	
	public void eventoTemperaturaOleoBaixa(){
		this.Temperatura_OleoMax = 19;
		this.Temperatura_OleoMin = 0;
	}
	
	public void eventoTemperaturaMotorAlta(){
		this.Temperatura_MotorMax = 100;
		this.Temperatura_MotorMin = 85;
	}
	
	public void eventoTemperaturaMotorNormal(){
		this.Temperatura_MotorMax = 84;
		this.Temperatura_MotorMin = 60;
	}
	
	public void eventoTemperaturaMotorBaixa(){
		this.Temperatura_MotorMax = 59;
		this.Temperatura_MotorMin = 10;
	}
	
	public void eventoRPM_Alto(){
		this.RPM_Max = 8;
		this.RPM_Min = 6;
	}
	
	public void eventoRPM_Normal(){
		this.RPM_Max = 5;
		this.RPM_Min = 3;
	}
	
	public void eventoRPM_Baixo(){
		this.RPM_Max = 2;
		this.RPM_Min = 0;
	}
	@Override
	public void createEvents() {
		int lot = gerador.nextInt((100 - 1) + 1) + 1;
		
		if(lot <= 80){
			this.eventoGasolinaBaixa();
			this.eventoNivelOleoBaixo();
			this.eventoTemperaturaMotorBaixa();
			this.eventoRPM_Baixo();
			this.eventoVelocidadeBaixa();
			this.eventoTemperaturaOleoBaixa();
		}
		else if(lot > 80 && lot < 90){
			this.eventoGasolinaAlta();
			this.eventoNivelOleoAlto();
			this.eventoTemperaturaMotorAlta();
			this.eventoRPM_Alto();
			this.eventoVelocidadeAlta();
			this.eventoTemperaturaOleoAlta();
		}
		else if(lot >= 90){
			this.eventoGasolinaNormal();
			this.eventoNivelOleoNormal();
			this.eventoTemperaturaMotorNormal();
			this.eventoRPM_Normal();
			this.eventoVelocidadeNormal();
			this.eventoTemperaturaOleoNormal();
		}
		
		velocidade = gerador.nextFloat() * (VelocidadeMax - VelocidadeMin) + VelocidadeMin;
		nivel_gasolina = gerador.nextFloat() * (Nivel_GasolinaMax - Nivel_GasolinaMin) + Nivel_GasolinaMin;
		nivel_oleo = gerador.nextFloat() * (Nivel_OleoMax - Nivel_OleoMin) + Nivel_OleoMin;
		temp_oleo = gerador.nextFloat() * (Temperatura_OleoMax - Temperatura_OleoMin) + Temperatura_OleoMin;
		temp_motor = gerador.nextFloat() * (Temperatura_MotorMax - Temperatura_MotorMin) + Temperatura_MotorMin;
		rpm = gerador.nextFloat() * (RPM_Max - RPM_Min) + RPM_Min;
	}
	
	
	public float getVelocidade() {
		return velocidade;
	}

	public float getNivel_gasolina() {
		return nivel_gasolina;
	}

	public float getNivel_oleo() {
		return nivel_oleo;
	}

	public float getTemp_oleo() {
		return temp_oleo;
	}

	public float getTemp_motor() {
		return temp_motor;
	}

	public float getRpm() {
		return rpm;
	}

	

	@Override
	public String toString() {
		return "SensorVeiculo [gerador=" + gerador + ", thread=" + thread + ", host=" + host + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", velocidade=" + velocidade + ", nivel_gasolina=" + nivel_gasolina
				+ ", nivel_oleo=" + nivel_oleo + ", temp_oleo=" + temp_oleo + ", temp_motor=" + temp_motor + ", rpm="
				+ rpm + "]";
	}

	@Override
	public String getType() {
		return this.type;
	}
	
}

