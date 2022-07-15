package br.ufc.pds;

import br.ufc.pds.iot.service.IoTService;
import br.ufc.pds.iot.service.SensorRepository;
import br.ufc.pds.iot.service.SensorsFactory;
import br.ufc.pds.iot.service.interfaces.IIoTRepository;
import br.ufc.pds.iot.service.interfaces.IIotService;
import br.ufc.pds.iot.service.interfaces.ISensorsFactory;
import br.ufc.pds.models.Sensor;
import br.ufc.pds.remote.JSONStrategy;
import br.ufc.pds.remote.RemoteInterfaceProxy;
import br.ufc.pds.remote.interfaces.IRemoteInterfaceProxy;
import br.ufc.pds.remote.interfaces.ISerializationStrategy;
import br.ufc.pds.remote.model.RPCServer;
import br.ufc.pds.remote.tcp.TCPServer;
import br.ufc.pds.view.ISensorViewFactory;
import br.ufc.pds.view.SensorViewFactory;

public class ServiceInjector {
	
	private static IIoTRepository<Sensor> instance;
	
	public static RPCServer provideServer(){
		return new TCPServer();
	}
	
	public static IIotService provideIoTService() {
		 return new IoTService();
	}
	
	public static ISensorsFactory provideSensorsFactory(){
		return new SensorsFactory();
	}
	
	public static ISensorViewFactory provideSensorViewFactory(){
		return new SensorViewFactory();
	}
	
	public static ISerializationStrategy provideSerializationStrategy(){
		return new JSONStrategy();
	}
	
	public static IRemoteInterfaceProxy provideRemoteInterfaceProxy(){
		return new RemoteInterfaceProxy();
	}
	
	public static IIoTRepository<Sensor> provideSensorCollection(){
		 if(instance == null) {
	         instance = new SensorRepository();
	      }
	      return instance;
	}
	
}
