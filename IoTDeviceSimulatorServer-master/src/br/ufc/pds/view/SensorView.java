package br.ufc.pds.view;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import br.ufc.pds.models.Sensor;

public abstract class SensorView {

	protected JFrame mainFrame;
	
	public SensorView(Sensor sensor){
		this.prepareGUI();
	}
	
	public abstract void render();
	
	private void prepareGUI(){
		mainFrame = new JFrame("Sensor");
		mainFrame.setSize(500, 300);
		mainFrame.setLayout(new FlowLayout());
	}
	
	public void show(){ 
		 mainFrame.setVisible(true); 
		 this.render();
	}
	
	public JFrame getFrame(){
		return this.mainFrame;
	}
	
}



