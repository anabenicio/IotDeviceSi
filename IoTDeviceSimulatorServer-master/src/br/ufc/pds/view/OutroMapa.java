package br.ufc.pds.view;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import br.ufc.pds.models.SensorEletricidade;



public class OutroMapa extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String host;
	public  OutroMapa(SensorEletricidade sensor) {
		SensorEletricidade eletricidade = new SensorEletricidade(host);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1078, 817);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		JLabel label = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, label, 23, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 330, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, label, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label, -10, SpringLayout.EAST, getContentPane());
		Image img = new ImageIcon(this.getClass().getResource("/image.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		getContentPane().add(label);
		
		JButton btnTensoNormal = new JButton("Corrente Baixa");
		btnTensoNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eletricidade.eventoCorrenteBaixa();
			}
		});
		btnTensoNormal.addMouseListener(new MouseAdapter() {
			
		});
		springLayout.putConstraint(SpringLayout.WEST, btnTensoNormal, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(btnTensoNormal);
		
		JButton button = new JButton("Corrente Alta");
		springLayout.putConstraint(SpringLayout.EAST, button, -759, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnTensoNormal, -6, SpringLayout.NORTH, button);
		springLayout.putConstraint(SpringLayout.EAST, btnTensoNormal, 0, SpringLayout.EAST, button);
		springLayout.putConstraint(SpringLayout.WEST, button, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, button, 101, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, button, 76, SpringLayout.NORTH, getContentPane());
		button.addMouseListener(new MouseAdapter() {
			public void actionPerformed(ActionEvent arg1) {
				eletricidade.eventoCorrenteAlta();
			}
		});
		getContentPane().add(button);
		
		JButton btnNewButton = new JButton("Corrente Normal");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -6, SpringLayout.NORTH, btnTensoNormal);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -759, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, getContentPane());
		btnNewButton.addMouseListener(new MouseAdapter() {
			
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg2) {
				eletricidade.eventoCorrenteNormal();
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnTensoNormal_1 = new JButton("Tens\u00E3o Normal");
		springLayout.putConstraint(SpringLayout.NORTH, btnTensoNormal_1, 20, SpringLayout.SOUTH, button);
		springLayout.putConstraint(SpringLayout.WEST, btnTensoNormal_1, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnTensoNormal_1, -29, SpringLayout.WEST, label);
		btnTensoNormal_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eletricidade.eventoTensaoNormal();
			}
		});
		getContentPane().add(btnTensoNormal_1);
		
		
		JButton btnTensoBaixa = new JButton("Tens\u00E3o Baixa");
		springLayout.putConstraint(SpringLayout.NORTH, btnTensoBaixa, 5, SpringLayout.SOUTH, btnTensoNormal_1);
		springLayout.putConstraint(SpringLayout.WEST, btnTensoBaixa, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnTensoBaixa, -29, SpringLayout.WEST, label);
		btnTensoBaixa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eletricidade.eventoTensaoBaixa();
			}
		});
		getContentPane().add(btnTensoBaixa);
		
		JButton btnTensoAlta = new JButton("Tens\u00E3o Alta");
		btnTensoAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eletricidade.eventoTensaoAlta();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnTensoAlta, 6, SpringLayout.SOUTH, btnTensoBaixa);
		springLayout.putConstraint(SpringLayout.WEST, btnTensoAlta, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnTensoAlta, -29, SpringLayout.WEST, label);
		btnTensoAlta.addMouseListener(new MouseAdapter() {
			
			
		});
		getContentPane().add(btnTensoAlta);
		
		JLabel lblAleatorio = new JLabel("aleatorio");
		springLayout.putConstraint(SpringLayout.NORTH, lblAleatorio, 629, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblAleatorio, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblAleatorio, -37, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblAleatorio, -40, SpringLayout.WEST, label);
		lblAleatorio.setText("<HTML>"+ eletricidade.toString() + "</HTML");
		getContentPane().add(lblAleatorio);
		
		JLabel lblCorrente = new JLabel("Corrente");
		springLayout.putConstraint(SpringLayout.NORTH, lblCorrente, 56, SpringLayout.SOUTH, btnTensoAlta);
		springLayout.putConstraint(SpringLayout.WEST, lblCorrente, 0, SpringLayout.WEST, btnTensoNormal);
		springLayout.putConstraint(SpringLayout.SOUTH, lblCorrente, 98, SpringLayout.SOUTH, btnTensoAlta);
		springLayout.putConstraint(SpringLayout.EAST, lblCorrente, 0, SpringLayout.EAST, btnTensoNormal);
		lblCorrente.setText("<HTML>" + eletricidade.CorrenteEletricidade() + "</HTML>");
		getContentPane().add(lblCorrente);
		
		JLabel lblTensao = new JLabel("Tensao");
		springLayout.putConstraint(SpringLayout.NORTH, lblTensao, 27, SpringLayout.SOUTH, lblCorrente);
		springLayout.putConstraint(SpringLayout.WEST, lblTensao, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblTensao, 69, SpringLayout.SOUTH, lblCorrente);
		springLayout.putConstraint(SpringLayout.EAST, lblTensao, 290, SpringLayout.WEST, getContentPane());
		lblTensao.setText("<HTML>" + eletricidade.TensaoEletricidade() + "</HTML>");
		getContentPane().add(lblTensao);
		
		JLabel lblConsumo = new JLabel("Consumo");
		springLayout.putConstraint(SpringLayout.NORTH, lblConsumo, 28, SpringLayout.SOUTH, lblTensao);
		springLayout.putConstraint(SpringLayout.WEST, lblConsumo, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblConsumo, 70, SpringLayout.SOUTH, lblTensao);
		springLayout.putConstraint(SpringLayout.EAST, lblConsumo, 0, SpringLayout.EAST, btnTensoNormal);
		
		lblConsumo.setText("<HTML>" + eletricidade.ConsumoEletricidade() + "</HTML>");
		getContentPane().add(lblConsumo);
	
	}
	
	public String destino()
	{
		String DestinoDoArquivo = "imagem.jpg";
		String str = DestinoDoArquivo;
		return str;
	}
}
