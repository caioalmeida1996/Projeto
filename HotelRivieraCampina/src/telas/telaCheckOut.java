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

public class telaCheckOut extends JFrame {

	private JPanel contentPane;
	private JTextField tfHospedeOut;
	
	Color corFundo = new Color(244, 246, 245); 
	Color corBotao = new Color(68, 133, 244);
	private JLabel lblTotalGasto;
	private JTextField textField;
	private JButton btnBuscar;
	private JLabel lblFatura;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public telaCheckOut() {
		setTitle("Check Out");
		
		setBounds(420, 230, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHospede = new JLabel("Hospede");
		lblHospede.setBounds(10, 11, 86, 14);
		contentPane.add(lblHospede);
		
		tfHospedeOut = new JTextField();
		tfHospedeOut.setBounds(10, 36, 86, 20);
		contentPane.add(tfHospedeOut);
		tfHospedeOut.setColumns(10);
		
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCheckOut.setBounds(141, 219, 103, 34);
		btnCheckOut.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		btnCheckOut.setForeground(Color.WHITE);
		btnCheckOut.setBorder(null);
		btnCheckOut.setBackground(corBotao);
		contentPane.add(btnCheckOut);
		
		lblTotalGasto = new JLabel("Total Gasto");
		lblTotalGasto.setBounds(10, 205, 103, 14);
		contentPane.add(lblTotalGasto);
		
		textField = new JTextField();
		textField.setBounds(10, 230, 103, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(106, 35, 89, 23);
		btnBuscar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(corBotao);
		contentPane.add(btnBuscar);
		
		lblFatura = new JLabel("Fatura");
		lblFatura.setBounds(10, 93, 59, 14);
		contentPane.add(lblFatura);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 118, 385, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}

}
