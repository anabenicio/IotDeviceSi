package br.ufc.pds;

import br.ufc.pds.remote.model.RPCServer;
import br.ufc.pds.view.MainWindow;

import java.io.IOException;

public class Main {

	static RPCServer server = ServiceInjector.provideServer();
	
	public static void main(String[] args) {
		
		MainWindow.prepareGUI();   			//Iniciar a interface gr�fica
			
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					server.start();		   //Iniciar o Servidor
				} catch (IOException e) {
					System.out.println("N�o foi possivel criar servidor.");
					System.exit(0);
				}        
			}
		}).run();
		
	}
}
