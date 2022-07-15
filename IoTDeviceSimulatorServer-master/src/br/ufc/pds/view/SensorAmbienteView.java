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

import br.ufc.pds.models.SensorAmbiente;

public class SensorAmbienteView extends SensorView {

	SensorAmbiente sensor;
	JLabel labelTemperatura;
	JLabel labelVelocidadeVento;
	JLabel labelPressaoAtm;
	JLabel labelNivelLuminosidade;
	JLabel labelNivelRuido;
	JLabel labelNivelCo2;
	JLabel labelNivelGas;
	JLabel labelNivelUmidade;
	JFrame f;
	
	JXMapKit jXMapKit = new JXMapKit();
	
	public SensorAmbienteView(SensorAmbiente sensor) {
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
        
        f.setTitle("Sensor Ambiente:" + sensor.getIdentifier());
        labelTemperatura = new JLabel("A", JLabel.LEFT);
        labelVelocidadeVento = new JLabel("B", JLabel.CENTER);
        labelPressaoAtm = new JLabel("C", JLabel.RIGHT);
        labelNivelLuminosidade = new JLabel("D", JLabel.EAST);
        labelNivelRuido = new JLabel("D", JLabel.SOUTH);
        labelNivelCo2 = new JLabel("E", JLabel.NORTH_EAST);
        labelNivelGas = new JLabel("F", JLabel.SOUTH_EAST);
        labelNivelUmidade = new JLabel("G", JLabel.SOUTH_WEST);
        
        //-------------------------------------
        // Temperatura
        JButton evAltaTemperatura = new JButton("Evento: Temperatura Alta");
		JButton evBaixaTemperatura  = new JButton("Evento: Temperatura Baixa");
		JButton evNormalTemperatura  = new JButton("Evento: Temperatura Normal");
        
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
		
		evAltaTemperatura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoTemperaturaAlta();
			}
		});
		//--------------------------------------
		//Velocidade Vento
		JButton evAltaVelocidadeVento = new JButton("Evento: Velosidade Vento Alta");
		JButton evBaixaVelocidadeVento = new JButton("Evento: Velosidade Vento Baixa");
		JButton evNormalVelocidadeVento = new JButton("Evento: Velosidade Vento Normal");
		
		evBaixaVelocidadeVento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoVelocidade_VentoBaixa();
			}
		});
		
		evNormalVelocidadeVento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoVelocidade_VentoNormal();
			}
		});
		
		evAltaVelocidadeVento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoVelocidade_VentoAlta();
			}
		});
		//--------------------------------------
		// Pressão Atm
		JButton evAltaPressaoAtm = new JButton("Evento: Pressão ATM Alta");
		JButton evBaixaPressaoAtm = new JButton("Evento: Pressão ATM Baixa");
		JButton evNormalPressaoAtm = new JButton("Evento: Pressão ATM Normal");
		
		evBaixaPressaoAtm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoPressao_atmBaixa();
			}
		});
		
		evNormalPressaoAtm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoPressao_atmNormal();
			}
		});
		
		evAltaPressaoAtm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoPressao_atmAlta();
			}
		});
		//---------------------------------------
		//Luminosidade
		JButton evAltaLuminosidade = new JButton("Evento: Nível Luminosidade Alta");
		JButton evBaixaLuminosidade = new JButton("Evento: Nível Luminosidade Baixa");
		JButton evNormalLuminosidade = new JButton("Evento: Nível Luminosidade Normal");
		
		evBaixaLuminosidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoNivel_luminosidadeBaixa();
			}
		});
		
		evNormalLuminosidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoNivel_luminosidadeNormal();
			}
		});
		
		evAltaLuminosidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoNivel_luminosidadeNormal();
			}
		});
		
		//---------------------------------------
		// Ruido
		JButton evAltaRuido = new JButton("Evento: Nível Ruido Alta");
		JButton evBaixaRuido = new JButton("Evento: Nível Ruido Baixa");
		JButton evNormalRuido = new JButton("Evento: Nível Ruido Normal");
		
		evBaixaRuido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoNivel_ruidoBaixo();
			}
		});
		
		evNormalRuido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoNivel_ruidoNormal();
			}
		});
		
		evAltaRuido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoNivel_ruidoAlto();
			}
		});
		
		//---------------------------------------
		// CO2
		JButton evAltaCo2 = new JButton("Evento: Nível Co2 Alta");
		JButton evBaixaCo2 = new JButton("Evento: Nível Co2 Baixa");
		JButton evNormalCo2 = new JButton("Evento: Nível Co2 Normal");
		
		evBaixaCo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoNivel_co2Baixo();
			}
		});
		
		evNormalCo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoNivel_co2Normal();
			}
		});
		
		evAltaCo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoNivel_co2Alto();
			}
		});
		
		//---------------------------------------
		// Gás
		JButton evAltaGas = new JButton("Evento: Nível Gás Alta");
		JButton evBaixaGas = new JButton("Evento: Nível Gás Baixa");
		JButton evNormalGas = new JButton("Evento: Nível Gás Normal");
	
		evBaixaGas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoNivel_gasBaixo();
			}
		});
		
		evNormalGas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoNivel_gasNormal();
			}
		});
		
		evAltaGas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoNivel_gasAlto();
			}
		});
		
		//-----------------------------------------
		// Umidade
		JButton evAltaUmidade = new JButton("Evento: Nível Umidade Alta");
		JButton evBaixaUmidade = new JButton("Evento: Nível Umidade Baixa");
		JButton evNormalUmidade = new JButton("Evento: Nível Umidade Normal");
	
		evBaixaUmidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoNivel_umidadeBaixa();
			}
		});
		
		evNormalUmidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoNivel_umidadeNormal();
			}
		});
		
		evAltaUmidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoNivel_umidadeAlta();
			}
		});
		
		//------------------------------------------
		
		f.add(evAltaTemperatura);
		f.add(evBaixaTemperatura);
		f.add(evNormalTemperatura);
		
		f.add(evAltaVelocidadeVento);
		f.add(evBaixaVelocidadeVento);
		f.add(evNormalVelocidadeVento);
		
		f.add(evAltaPressaoAtm);
		f.add(evBaixaPressaoAtm);
		f.add(evNormalPressaoAtm);
		
		f.add(evAltaLuminosidade);
		f.add(evBaixaLuminosidade);
		f.add(evNormalLuminosidade);
		
		f.add(evAltaRuido);
		f.add(evBaixaRuido);
		f.add(evNormalRuido);
		
		f.add(evAltaCo2);
		f.add(evBaixaCo2);
		f.add(evNormalCo2);
		
		f.add(evAltaGas);
		f.add(evBaixaGas);
		f.add(evNormalGas);
		
		f.add(evAltaUmidade);
		f.add(evBaixaUmidade);
		f.add(evNormalUmidade);
		
		f.add(jXMapKit);
		
		f.add(labelNivelCo2);
		f.add(labelNivelGas);
		f.add(labelNivelLuminosidade);
		f.add(labelNivelRuido);
		f.add(labelNivelUmidade);
		f.add(labelPressaoAtm);
		f.add(labelTemperatura);
		f.add(labelVelocidadeVento);
		
	}
	
	

	public void render(){
		Thread thread = new Thread(){
		    public void run(){
		    	while(true){
		    		
		    		labelNivelCo2.setText("Nivel CO2: "+ String.valueOf(sensor.getNivel_co2()));
		    		labelNivelGas.setText("Nível Gás: "+ String.valueOf(sensor.getNivel_gas()));
		    		labelNivelLuminosidade.setText("Nível Luminosidade: "+ String.valueOf(sensor.getNivel_luminosidade()));
		    		labelNivelRuido.setText("Nível Ruído: "+ String.valueOf(sensor.getNivel_ruido()));
		    		labelNivelUmidade.setText("Nível Umidade: "+ String.valueOf(sensor.getNivel_umidade()));
		    		labelPressaoAtm.setText("Pressão ATM: "+ String.valueOf(sensor.getPressao_atm()));
		    		labelTemperatura.setText("Temperatura: "+ String.valueOf(sensor.getTemperatura()));
		    		labelVelocidadeVento.setText("Velocidade Vento: "+ String.valueOf(sensor.getVelocidade_vento()));
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
