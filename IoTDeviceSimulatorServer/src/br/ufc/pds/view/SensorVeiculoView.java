package br.ufc.pds.view;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jdesktop.swingx.JXMapKit;
import org.jdesktop.swingx.OSMTileFactoryInfo;
import org.jdesktop.swingx.mapviewer.DefaultTileFactory;
import org.jdesktop.swingx.mapviewer.GeoPosition;
import org.jdesktop.swingx.mapviewer.TileFactoryInfo;

import br.ufc.pds.models.Sensor;
import br.ufc.pds.models.SensorVeiculo;

public class SensorVeiculoView extends SensorView {

	
	boolean Evento = false;
	SensorVeiculo sensor;
	JLabel labelVelocidade;
	JLabel labelNivelGasolina;
	JLabel labelNivelOleo;
	JLabel labelTemperaturaOleo;
	JLabel labelTemperaturaMotor;
	JLabel labelRpm;
	
	JFrame f;
	
	JXMapKit jXMapKit = new JXMapKit();
	
	public SensorVeiculoView(SensorVeiculo sensor) {
		super(sensor);
		this.sensor = sensor;
		f = super.mainFrame;
		
		TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        
        jXMapKit.setTileFactory(tileFactory);
        jXMapKit.setZoom(20);
        jXMapKit.setAddressLocation(new GeoPosition(sensor.getLatitude(), sensor.getLongitude()));
        jXMapKit.setMiniMapVisible(false);     
        jXMapKit.setPreferredSize(new Dimension(400, 200));
        
		f.setTitle("Sensor Veículo: "+sensor.getIdentifier());
		labelVelocidade = new JLabel("A", JLabel.LEFT);
		labelNivelGasolina = new JLabel("B", JLabel.CENTER);
		labelNivelOleo = new JLabel("C", JLabel.RIGHT);
		labelTemperaturaOleo = new JLabel("D", JLabel.LEFT);
		labelTemperaturaMotor = new JLabel("E", JLabel.RIGHT);
		labelRpm = new JLabel("F", JLabel.CENTER);
		
		//------------------------------------------
		// Velocidade
		JButton evAltaVelocidade = new JButton("Evento: Velocidade Alta");
		JButton evBaixaVelocidade = new JButton("Evento: Velocidade Baixa");
		JButton evNormalVelocidade = new JButton("Evento: Velocidade Normal");
			
		evAltaVelocidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				sensor.eventoVelocidadeAlta();
			}
		});
			
		evBaixaVelocidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				sensor.eventoVelocidadeBaixa();
			}
		});
			
		evNormalVelocidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				sensor.eventoVelocidadeNormal();
			}
		});
			
		//-----------------------------------
		//Nível Gasolina
		
		JButton evAltaNivelGasolina = new JButton("Evento: Tanque cheio");
		JButton evBaixaNivelGasolina = new JButton("Evento: Sem Gasolina");
		JButton evNormalNivelGasolina = new JButton("Evento: Nível Gasolina Normal");
		
		evAltaNivelGasolina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				sensor.eventoGasolinaAlta();
			}
		});
			
		evBaixaNivelGasolina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				sensor.eventoGasolinaBaixa();;
			}
		});
			
		evNormalNivelGasolina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				sensor.eventoGasolinaNormal();
			}
		});
		
		//----------------------------------------------------
		//Nível Óleo
		JButton evAltaNivelOleo = new JButton("Evento: Nível Óleo Alto");
		JButton evBaixaNivelOleo = new JButton("Evento: Nível Óleo Baixo");
		JButton evNormalNivelOleo = new JButton("Evento: Nível Óleo Normal");
		
		evAltaNivelOleo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				sensor.eventoNivelOleoAlto();
			}
		});
			
		evBaixaNivelOleo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				sensor.eventoNivelOleoBaixo();
			}
		});
			
		evNormalNivelOleo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				sensor.eventoNivelOleoNormal();
			}
		});
		
		//-------------------------------------------
		//Temperatura Motor
		
		JButton evAltaTemperaturaMotor = new JButton("Evento: Incêndio Motor");
		JButton evBaixaTemperaturaMotor = new JButton("Evento: Motor desligado");
		JButton evNormalTemperaturaMotor = new JButton("Evento: Temperatura Motor Normal");
		
		evAltaTemperaturaMotor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				sensor.eventoTemperaturaMotorAlta();
			}
		});
			
		evBaixaTemperaturaMotor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				sensor.eventoTemperaturaMotorBaixa();
			}
		});
			
		evNormalTemperaturaMotor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				sensor.eventoTemperaturaMotorNormal();
			}
		});
		
		//--------------------------------------------
		//Temperatura òleo
		
		JButton evAltaTemperaturaOleo = new JButton("Evento: Temperatura Óleo Alta");
		JButton evBaixaTemperaturaOleo = new JButton("Evento: Temperatura óleo Baixa");
		JButton evNormalTemperaturaOleo = new JButton("Evento: Temperatura óleo Normal");
		
		evAltaTemperaturaOleo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				sensor.eventoTemperaturaOleoAlta();
			}
		});
			
		evBaixaTemperaturaOleo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				sensor.eventoTemperaturaOleoBaixa();
			}
		});
			
		evNormalTemperaturaOleo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				sensor.eventoTemperaturaOleoNormal();
			}
		});
		
		//------------------------------------------
		//RPM
		
		JButton evAltaRPM = new JButton("Evento: RPM Alta");
		JButton evBaixaRPM = new JButton("Evento: RPM Baixa");
		JButton evNormalRPM = new JButton("Evento: RPM Normal");
		
		evAltaRPM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				sensor.eventoRPM_Alto();
			}
		});
			
		evBaixaRPM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				sensor.eventoRPM_Baixo();
			}
		});
			
		evNormalRPM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				sensor.eventoRPM_Normal();
			}
		});
	
	
		f.add(evAltaNivelGasolina);
		f.add(evBaixaNivelGasolina);
		f.add(evNormalNivelGasolina);
		
		f.add(evAltaVelocidade);
		f.add(evBaixaVelocidade);
		f.add(evNormalVelocidade);
		
		f.add(evAltaNivelOleo);
		f.add(evBaixaNivelOleo);
		f.add(evNormalNivelOleo);
		
		f.add(evAltaTemperaturaOleo);
		f.add(evBaixaTemperaturaOleo);
		f.add(evNormalTemperaturaOleo);
		
		f.add(evAltaTemperaturaMotor);
		f.add(evBaixaTemperaturaMotor);
		f.add(evNormalTemperaturaMotor);
		
		f.add(evAltaRPM);
		f.add(evBaixaRPM);
		f.add(evNormalRPM);
		
		f.add(jXMapKit);
		
		f.add(labelNivelGasolina);
		f.add(labelNivelOleo);
		f.add(labelRpm);
		f.add(labelTemperaturaMotor);
		f.add(labelTemperaturaOleo);
		f.add(labelVelocidade);
		
	}
	 

	public void render(){
		Thread thread = new Thread(){
		    public void run(){
		    	while(true){
		    		
		    		labelNivelGasolina.setText("Gasolina: "+ String.valueOf(sensor.getNivel_gasolina()));
		    		labelNivelOleo.setText("Nível Óleo: "+ String.valueOf(sensor.getNivel_oleo()));
		    		labelRpm.setText("RPM: "+ String.valueOf(sensor.getRpm()));
		    		labelTemperaturaMotor.setText("Temp Motor: "+ String.valueOf(sensor.getTemp_motor()));
		    		labelTemperaturaOleo.setText("Temp òleo: "+ String.valueOf(sensor.getTemp_oleo()));
		    		labelVelocidade.setText("Velocidade: "+ String.valueOf(sensor.getVelocidade()));
		    		
		    		try {
		    				Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		    	}
		    	
		    }
		};
		
		f.setVisible(true);
		thread.start();
	}

}
