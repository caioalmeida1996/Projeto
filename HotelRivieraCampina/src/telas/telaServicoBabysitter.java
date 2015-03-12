package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class telaServicoBabysitter extends JFrame {

	private JPanel contentPane;
	private JTextField tfInicioData;
	private JTextField tfInicioHora;
	private JTextField tfTerminoData;
	private JTextField tfTerminoHora;
	private JTextField tfHospedeBaby;
	
	Color corFundo = new Color(244, 246, 245); 
	Color corBotao = new Color(68, 133, 244);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaServicoBabysitter frame = new telaServicoBabysitter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public telaServicoBabysitter() {
		setTitle("BabySitter");
		
		setBounds(420, 230, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInicio = new JLabel("Inicio");
		lblInicio.setBounds(10, 11, 46, 14);
		contentPane.add(lblInicio);
		
		tfInicioData = new JTextField();
		tfInicioData.setBounds(65, 30, 86, 20);
		contentPane.add(tfInicioData);
		tfInicioData.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setBounds(10, 33, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTermino = new JLabel("Termino");
		lblTermino.setBounds(246, 11, 72, 14);
		contentPane.add(lblTermino);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(10, 61, 46, 14);
		contentPane.add(lblHora);
		
		tfInicioHora = new JTextField();
		tfInicioHora.setBounds(65, 58, 86, 20);
		contentPane.add(tfInicioHora);
		tfInicioHora.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(246, 33, 46, 14);
		contentPane.add(lblData);
		
		JLabel lblHora_1 = new JLabel("Hora");
		lblHora_1.setBounds(246, 61, 46, 14);
		contentPane.add(lblHora_1);
		
		tfTerminoData = new JTextField();
		tfTerminoData.setBounds(285, 30, 86, 20);
		contentPane.add(tfTerminoData);
		tfTerminoData.setColumns(10);
		
		tfTerminoHora = new JTextField();
		tfTerminoHora.setBounds(285, 58, 86, 20);
		contentPane.add(tfTerminoHora);
		tfTerminoHora.setColumns(10);
		
		JLabel lblHospde = new JLabel("Hospde");
		lblHospde.setBounds(10, 140, 46, 14);
		contentPane.add(lblHospde);
		
		tfHospedeBaby = new JTextField();
		tfHospedeBaby.setBounds(10, 165, 86, 20);
		contentPane.add(tfHospedeBaby);
		tfHospedeBaby.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setBounds(117, 164, 89, 23);
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setBorder(null);
		btnAdicionar.setBackground(corBotao);
		btnAdicionar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 10));
		
		contentPane.add(btnAdicionar);
	}

}
