package br.ufc.pds.view;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import br.ufc.pds.models.Sensor;

public abstract class SensorView {

	protected JFrame mainFrame;
	
	public SensorView(Sensor sensor){
		mainFrame = new JFrame("Sensor");
		mainFrame.setSize(500, 300);
		mainFrame.setLayout(new FlowLayout());
	}
	
	public abstract void render();
	
	public void show(){ 
		 mainFrame.setVisible(true); 
		 this.render();
	}
	
	public JFrame getFrame(){
		return this.mainFrame;
	}
	
}

