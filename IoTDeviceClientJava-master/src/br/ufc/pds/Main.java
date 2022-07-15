package br.ufc.pds;

import br.ufc.pds.iot.client.IoTService;
import br.ufc.pds.iot.model.SensorEletricidade;
import br.ufc.pds.remote.tcp.TCPClient;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			IoTService.setRCPClientTCP(new TCPClient("localhost"));
		} catch (Exception e) {
			System.out.println("Não foi possivel conectar ao servidor.");
			System.exit(0);
		}
		
		SensorEletricidade s = null;
		
		try {
			//Cria um sensor remoto
			s = (SensorEletricidade) IoTService.createSensorEletricidade();
			System.out.println(s.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não foi possivel criar sensor.");
			System.exit(0);
		}
		
		final SensorEletricidade s1 = s;
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				
				while(true){
					
					try {
						// Obter inforações mais atualizadas do sensor
						IoTService.update(s1);
						System.out.println(s1.toString());
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Não foi possivel atualizar sensor.");
						System.exit(0);
					}
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
						System.exit(0);
					}
				}
			}
			
		}).start();
			
	}

}
