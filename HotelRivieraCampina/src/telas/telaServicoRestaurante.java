package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class telaServicoRestaurante extends JFrame {

	private JPanel contentPane;
	private JTextField tfValorRestaurante;
	private JTextField tfHospedeRestaurante;
	
	Color corFundo = new Color(244, 246, 245); 
	Color corBotao = new Color(68, 133, 244);

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public telaServicoRestaurante() {
		setTitle("Restaurante");
		
		setBounds(420, 230, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipoDeRestaurante = new JLabel("Tipo De Restaurante");
		lblTipoDeRestaurante.setBounds(10, 11, 122, 14);
		contentPane.add(lblTipoDeRestaurante);
		
		JComboBox<String> comboBoxTipoRestaurante = new JComboBox<String>();
		comboBoxTipoRestaurante.setBounds(10, 36, 122, 20);
		contentPane.add(comboBoxTipoRestaurante);
		comboBoxTipoRestaurante.addItem("Primeiro Andar");
		comboBoxTipoRestaurante.addItem("Cobertura");
		
		JLabel lblValorGasto = new JLabel("Valor Gasto");
		lblValorGasto.setBounds(231, 11, 70, 14);
		contentPane.add(lblValorGasto);
		
		tfValorRestaurante = new JTextField();
		tfValorRestaurante.setBounds(231, 35, 86, 20);
		contentPane.add(tfValorRestaurante);
		tfValorRestaurante.setColumns(10);
		
		JLabel lblHospede = new JLabel("Hospede");
		lblHospede.setBounds(10, 100, 70, 14);
		contentPane.add(lblHospede);
		
		tfHospedeRestaurante = new JTextField();
		tfHospedeRestaurante.setBounds(10, 123, 86, 20);
		contentPane.add(tfHospedeRestaurante);
		tfHospedeRestaurante.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setBounds(106, 122, 89, 23);
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setBorder(null);
		btnAdicionar.setBackground(corBotao);
		btnAdicionar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 10));
		
		contentPane.add(btnAdicionar);
	}

}
