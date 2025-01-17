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

import br.ufc.pds.models.SensorPessoa;

public class SensorPessoaView extends SensorView {

	SensorPessoa sensor;
	JLabel labelBatimento;
	JLabel labelTemperatura;
	JLabel labelSistole;
	JLabel labelDiastole;
	JLabel labelOxigenio;
	
	JFrame f;
	
	JXMapKit jXMapKit = new JXMapKit();
	
	public SensorPessoaView(SensorPessoa sensor) {
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
        
        f.setTitle("Sensor Pessoa: "+sensor.getIdentifier());
		labelBatimento = new JLabel("A", JLabel.LEFT);
		labelTemperatura = new JLabel("B", JLabel.CENTER);
		labelSistole = new JLabel("C", JLabel.RIGHT);
		labelDiastole = new JLabel("D", JLabel.EAST);
		labelOxigenio = new JLabel("E", JLabel.NORTH);
		
		//------------------------------------------
		// Batimento
		JButton evAltaBatimento = new JButton("Evento: Batimento Alta");
		JButton evBaixaBatimento = new JButton("Evento: Batimento Baixa");
		JButton evNormalBatimento = new JButton("Evento: Batimento Normal");
			
		evAltaBatimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoBatimentoAlto();
			}
		});
			
		evBaixaBatimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoBatimentoBaixo();
			}
		});
			
		evNormalBatimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoBatimentoNormal();				}
		});
			
		//------------------------------------------
		// Temperatura
		JButton evAltaTemperatura = new JButton("Evento: Temperatura Alta");				JButton evBaixaTemperatura = new JButton("Evento: Temperatura Baixa");
		JButton evNormalTemperatura = new JButton("Evento: Temperatura Normal");
				
			evAltaTemperatura.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					sensor.eventoTemperaturaAlta();
				}
			});
				
			evBaixaTemperatura.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					sensor.eventoTemperaturaBaixa();
				}
			});
				
			evNormalTemperatura.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					sensor.eventoTemperaturaNormal();
				}
			});
				
		//------------------------------------------
		// Sistole
		JButton evAltaSistole = new JButton("Evento: Sistole Alta");
		JButton evBaixaSistole = new JButton("Evento: Sistole Baixa");
		JButton evNormalSistole = new JButton("Evento: Sistole Normal");
					
			evAltaSistole.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					sensor.eventoSistoleAlta();
				}
			});
					
			evBaixaSistole.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					sensor.eventoSistoleBaixa();
				}
			});
					
			evNormalSistole.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					sensor.eventoSistoleNormal();
				}
			});
					

		//------------------------------------------
		// Diastole
		JButton evAltaDiastole = new JButton("Evento: Diastole Alta");
		JButton evBaixaDiastole = new JButton("Evento: Diastole Baixa");
		JButton evNormalDiastole = new JButton("Evento: Diastole Normal");
						
			evAltaDiastole.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				sensor.eventoDiastoleAlta();
			}
		});
						
		evBaixaDiastole.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoDiastoleBaixa();
			}
		});
						
		evNormalDiastole.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoDiastoleNormal();
			}
		});
						
		//------------------------------------------
		// Oxig�nio
				
		JButton evBaixaOxigenio = new JButton("Evento: Oxig�nio Baixa");
		JButton evNormalOxigenio = new JButton("Evento: Oxigenio Normal");
						
							
			evBaixaOxigenio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				sensor.eventoOxigenioBaixo();
			}
		});
							
			evNormalOxigenio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					sensor.eventoOxigenioNormal();
				}
			});
			
		//----------------------------------
			
		f.add(evAltaBatimento);
		f.add(evBaixaBatimento);
		f.add(evNormalBatimento);
		
		f.add(evAltaTemperatura);
		f.add(evBaixaTemperatura);
		f.add(evNormalTemperatura);
		
		f.add(evAltaSistole);
		f.add(evBaixaSistole);
		f.add(evNormalSistole);
		
		f.add(evAltaDiastole);
		f.add(evBaixaDiastole);
		f.add(evNormalDiastole);
		
		f.add(evBaixaOxigenio);
		f.add(evNormalOxigenio);
		
		f.add(jXMapKit);
		
		f.add(labelBatimento);
		f.add(labelDiastole);
		f.add(labelOxigenio);
		f.add(labelSistole);
		f.add(labelTemperatura);
		
        
	}

	
	public void render(){
		Thread thread = new Thread(){
		    public void run(){
		    	while(true){
		    		
		    		labelBatimento.setText("Batimento: "+ String.valueOf(sensor.getBatimento()));
		    		labelDiastole.setText("Diastole: "+ String.valueOf(sensor.getDiastole()));
		    		labelOxigenio.setText("Oxig�nio: "+ String.valueOf(sensor.getOxigenio()));
		    		labelSistole.setText("Sistole: "+ String.valueOf(sensor.getSistole()));
		    		labelTemperatura.setText("Temperatura: "+ String.valueOf(sensor.getTemperatura()));
		    		
		    		try {
						Thread.sleep(2000);
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
