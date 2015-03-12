package telas;

import gerenteServicos.GerenteServicos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

import contrato.Contrato;
import aluguelCarros.AluguelCarro;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class telaServicoCarro extends JFrame {

	private JPanel contentPane;
	private JTextField tfDataEntrada;
	private JTextField tfDataSaida;
	private JTextField tfHospedeCarro;

	Color corFundo = new Color(244, 246, 245); 
	Color corBotao = new Color(68, 133, 244);
	private JTextField tfPlaca;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public telaServicoCarro() {
		setTitle("Carro");
		
		setBounds(420, 230, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipoDeCarro = new JLabel("Tipo De Carro");
		lblTipoDeCarro.setBounds(10, 11, 74, 14);
		contentPane.add(lblTipoDeCarro);
		
		final JComboBox<String> comboBoxTipoCarro = new JComboBox<String>();
		comboBoxTipoCarro.setBounds(94, 8, 128, 20);
		contentPane.add(comboBoxTipoCarro);
		comboBoxTipoCarro.addItem("Executivo");
		comboBoxTipoCarro.addItem("Luxo");
		
		final JRadioButton rdbtnTanqueCheio = new JRadioButton("Tanque Cheio");
		rdbtnTanqueCheio.setBounds(6, 45, 109, 23);
		contentPane.add(rdbtnTanqueCheio);
		
		final JRadioButton rdbtnSeguro = new JRadioButton("Seguro");
		rdbtnSeguro.setBounds(6, 71, 109, 23);
		contentPane.add(rdbtnSeguro);
		
		JLabel lblDataDeEntrada = new JLabel("Data de Entrada");
		lblDataDeEntrada.setBounds(277, 11, 109, 14);
		contentPane.add(lblDataDeEntrada);
		
		tfDataEntrada = new JTextField();
		tfDataEntrada.setBounds(277, 33, 89, 20);
		contentPane.add(tfDataEntrada);
		tfDataEntrada.setColumns(10);
		
		JLabel lblDataDeSaida = new JLabel("Data de Saida");
		lblDataDeSaida.setBounds(277, 62, 89, 14);
		contentPane.add(lblDataDeSaida);
		
		tfDataSaida = new JTextField();
		tfDataSaida.setBounds(277, 87, 89, 20);
		contentPane.add(tfDataSaida);
		tfDataSaida.setColumns(10);
		
		JLabel lblHospede = new JLabel("Hospede");
		lblHospede.setBounds(10, 203, 74, 14);
		contentPane.add(lblHospede);
		
		tfHospedeCarro = new JTextField();
		tfHospedeCarro.setBounds(10, 228, 86, 20);
		contentPane.add(tfHospedeCarro);
		tfHospedeCarro.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setBounds(106, 227, 89, 23);
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setBorder(null);
		btnAdicionar.setBackground(corBotao);
		btnAdicionar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 10));
		
		contentPane.add(btnAdicionar);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(10, 101, 46, 14);
		contentPane.add(lblPlaca);
		
		tfPlaca = new JTextField();
		tfPlaca.setBounds(10, 129, 86, 20);
		contentPane.add(tfPlaca);
		tfPlaca.setColumns(10);
	}
}
