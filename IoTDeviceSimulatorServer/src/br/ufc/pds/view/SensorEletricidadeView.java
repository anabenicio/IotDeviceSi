package br.ufc.pds.view;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.swingx.JXMapKit;
import org.jdesktop.swingx.OSMTileFactoryInfo;
import org.jdesktop.swingx.mapviewer.DefaultTileFactory;
import org.jdesktop.swingx.mapviewer.GeoPosition;
import org.jdesktop.swingx.mapviewer.TileFactoryInfo;

import br.ufc.pds.models.SensorEletricidade;

public class SensorEletricidadeView extends SensorView {

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
		labelCorrente = new JLabel("", JLabel.LEFT);
		labelTensao = new JLabel("", JLabel.CENTER);
		labelConsumo = new JLabel("", JLabel.RIGHT); 
		
		JButton evAltaBtn = new JButton("Evento: Corrente Alta");
		JButton evBaixaBtn = new JButton("Evento: Corrente Baixa");
		JButton evNormalBtn = new JButton("Evento: Corrente Normal");
		
		
		
		
		//
		
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

		//-------------------------------
		// Tensao
		
		JButton evAltaTensao = new JButton("Evento: Tens�o Alta");
		JButton evBaixaTensao = new JButton("Evento: Tens�o Baixa");
		JButton evNormalTensao = new JButton("Evento: Tens�o Normal");
		
		evAltaTensao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoTensaoAlta();
			}
		});
		
		evBaixaTensao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoTensaoBaixa();
			}
		});
		
		evNormalTensao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sensor.eventoTensaoNormal();
			}
		});
	
		//----------
		GroupLayout gl_contentPane = new GroupLayout(jXMapKit);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(evBaixaBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(evAltaBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
						.addComponent(evNormalBtn, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(evNormalTensao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(evBaixaTensao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(evAltaTensao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(312, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(evAltaBtn)
						.addComponent(evAltaTensao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(evBaixaBtn)
						.addComponent(evBaixaTensao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(evNormalBtn)
						.addComponent(evNormalTensao))
					.addContainerGap(273, Short.MAX_VALUE))
		);
		jXMapKit.setLayout(gl_contentPane);
		
		//-------
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
		    				    		
		    		labelTensao.setText("Tens�o: "+ String.valueOf(sensor.getTensao()));
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
