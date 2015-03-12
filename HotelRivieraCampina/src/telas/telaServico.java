package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class telaServico extends JFrame {

	private JPanel contentPane;
	Color corFundo = new Color(244, 246, 245); 
	Color corBotao = new Color(68, 133, 244);

	/**
	 * Launch the application.
	 */

	

	/**
	 * Create the frame.
	 */
	public telaServico() {
		setTitle("Servi\u00E7os");
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCarro = new JButton("Carro");
		btnCarro.setForeground(Color.WHITE);
		btnCarro.setBorder(null);
		btnCarro.setBackground(corBotao);
		
		btnCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaServicoCarro TSC = new telaServicoCarro();
				TSC.show();
			}
		});
		
		btnCarro.setBounds(156, 67, 121, 23);
		btnCarro.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		contentPane.add(btnCarro);
		
		
		
		JButton btnBabysitter = new JButton("BabySitter");
		btnBabysitter.setBounds(156, 101, 121, 23);
		btnBabysitter.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		btnBabysitter.setForeground(Color.WHITE);
		btnBabysitter.setBorder(null);
		btnBabysitter.setBackground(corBotao);
		
		contentPane.add(btnBabysitter);
		
		JButton btnRestaurante = new JButton("Restaurante");
		btnRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRestaurante.setBounds(156, 135, 121, 23);
		btnRestaurante.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		btnRestaurante.setForeground(Color.WHITE);
		btnRestaurante.setBorder(null);
		btnRestaurante.setBackground(corBotao);
		contentPane.add(btnRestaurante);
		
	}

}
