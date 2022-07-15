package br.ufc.pds.iot.service;

import br.ufc.pds.remote.IRemoteInterfaceProxy;
import br.ufc.pds.remote.RCPServer;
import br.ufc.pds.remote.RemoteInterfaceProxy;
import br.ufc.pds.remote.tcp.TCPServer;
import br.ufc.pds.view.MainWindow;

public class ServicesProvider {
	
	private static IIoTRepository instance;
	
	public static RCPServer provideServer(){
		return new TCPServer();
	}
	
	public static IIotService provideIoTService() {
		 return new IoTService();
	}
	
	public static IRemoteInterfaceProxy provideRemoteInterfaceProxy(){
		return new RemoteInterfaceProxy();
	}
	
	public static IIoTRepository provideSensorCollection(){
		 if(instance == null) {
	         instance = new SensorRepository();
	      }
	      return instance;
	}
	
}
