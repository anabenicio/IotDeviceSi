package br.ufc.pds.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.ufc.pds.iot.service.IIoTRepository;
import br.ufc.pds.iot.service.ServicesProvider;
import br.ufc.pds.models.Sensor;

public class MainWindow {

	static IIoTRepository collection = ServicesProvider.provideSensorCollection();
	static Sensor selected;
	
	static JFrame mainFrame;
	static JButton showButton;
	static JList<Sensor> list;
	static DefaultListModel<Sensor> model = new DefaultListModel<Sensor>();
	
	public static void prepareGUI(){
		mainFrame = new JFrame("IOT Device Simulator");
		mainFrame.setSize(800, 600);
		mainFrame.setLayout(new GridLayout(1, 2));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
		    }        
		});     
	
		list = new JList<Sensor>(model);
		list.setVisibleRowCount(10);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.setCellRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                if (renderer instanceof JLabel && value instanceof Sensor) {
	                    ((JLabel) renderer).setText(((Sensor) value).getIdentifier()+"  >>>  "+((Sensor) value).getHost());
	                }
	                return renderer;
	            }
	    });
		
		list.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				JList<Sensor> list = (JList<Sensor>) e.getSource();
				selected = (Sensor) list.getSelectedValue();
			}
		});

		showButton = new JButton("Manage Sensor");
		showButton.setPreferredSize(new Dimension(10, 10));
		showButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(selected == null){
					JOptionPane.showMessageDialog(mainFrame, "Selecione um sensor para visualiza-lo.");
				}else{
				   new SensorViewFactory(selected);
			    }
			}
		});
		 
		mainFrame.add(new JScrollPane(list));
	    mainFrame.add(showButton);
		mainFrame.setVisible(true); 
		 
		Thread thread = new Thread(){
			public void run(){
				while(true){
					try {
			    		refreshList();
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			    }
			 }
		 };
		 thread.start();
	}
	
	static void refreshList(){
		for(Object s : collection.getAll()){
			if(!model.contains(s)){
				model.addElement((Sensor) s);
			}
		}
	}
}
