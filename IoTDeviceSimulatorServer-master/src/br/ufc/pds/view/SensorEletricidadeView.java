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

import br.ufc.pds.models.SensorEletricidade;
import br.ufc.pds.view.SensorView;

public class SensorEletricidadeView extends SensorView {

	boolean Evento;
	SensorEletricidade sensor;
	JLabel labelCorrente;
	JLabel labelTensao;
	JLabel labelConsumo;
	JFrame f;
    JXMapKit jXMapKit = new JXMapKit();
	
	public SensorEletricidadeView(SensorEletricidade sensor) {
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
        
		f.setTitle("Sensor Eletricidade: "+sensor.getIdentifier());
		labelCorrente = new JLabel("A", JLabel.LEFT);
		labelTensao = new JLabel("B", JLabel.CENTER);
		labelConsumo = new JLabel("C", JLabel.RIGHT);
		
	//------------------------------------------
	// Corrente
		JButton evAltaBtn = new JButton("Evento: Corrente Alta");
		JButton evBaixaBtn = new JButton("Evento: Corrente Baixa");
		JButton evNormalBtn = new JButton("Evento: Corrente Normal");
		
		evAltaBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				sensor.eventoCorrenteAlta();
			}
		});
		
		evBaixaBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				sensor.eventoCorrenteBaixa();
			}
		});
		
		evNormalBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				sensor.eventoCorrenteNormal();
			}
		});
		
	//---------------------------------------------------------
	//Tensão
		JButton evAltaTensao = new JButton("Evento: Tensão Alta");
		JButton evNormalTensao = new JButton("Evento: Tensão Normal");
		JButton evBaixaTensao = new JButton("Evento: Tensão Baixa");

		evAltaTensao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoCorrenteNormal();
			}
		});
		
		
		evNormalTensao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoCorrenteNormal();
			}
		});
		
		evBaixaTensao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoCorrenteNormal();
			}
		});
		
		//------------------------------------------------------
		
		
		f.add(evAltaBtn);
		f.add(evBaixaBtn);
		f.add(evNormalBtn);
		
		f.add(evAltaTensao);
		f.add(evBaixaTensao);
		f.add(evNormalTensao);
		
		f.add(jXMapKit);
		
		f.add(labelCorrente);
		f.add(labelTensao);
		f.add(labelConsumo);
	}

	public void render(){
		Thread thread = new Thread(){
		    public void run(){
		    	while(true){
		    				    		
		    		labelTensao.setText("Tensão: "+ String.valueOf(sensor.getTensao()));
		    		labelCorrente.setText("Corrente: "+ String.valueOf(sensor.getCorrente()));
		    		labelConsumo.setText("Consumo: "+ String.valueOf(sensor.getConsumo()));
		    		
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