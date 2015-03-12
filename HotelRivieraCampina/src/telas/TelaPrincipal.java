package telas;

import hotel.Hotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {
	
	Color corFundo = new Color(244, 246, 245); 
	Color corBotao = new Color(68, 133, 244);
	static Hotel hotel = new Hotel();
	private JPanel contentPane;

	public TelaPrincipal() {
		
		setTitle("Hotel Riviera Campina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 102);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(corFundo);
		
		JButton btnCheckIn = new JButton("Check In");
		btnCheckIn.setForeground(Color.WHITE);
		btnCheckIn.setBorder(null);
		btnCheckIn.setBackground(corBotao);

		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCheckIn TH = new TelaCheckIn();
				TH.show();
			}
		});
		btnCheckIn.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		btnCheckIn.setBounds(10, 21, 139, 23);
		contentPane.add(btnCheckIn);
		
		JButton btnHospedes = new JButton("Hospedes");
		btnHospedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaHospedes TH = new TelaHospedes();
				TH.show();
			}
		});
		btnHospedes.setForeground(Color.WHITE);
		btnHospedes.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		btnHospedes.setBounds(176, 21, 139, 23);
		contentPane.add(btnHospedes);
		btnHospedes.setBorder(null);
		btnHospedes.setBackground(corBotao);
	}
	
	public Hotel getHotel(){
		return hotel;
	}
}
