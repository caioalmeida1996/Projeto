package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaHospedes extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomeHospede;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TelaHospedes() {
		
		setTitle("Hospedes");
		
		setBounds(300, 120, 648, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHospede = new JLabel("Hospede:");
		lblHospede.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		lblHospede.setBounds(10, 11, 52, 22);
		contentPane.add(lblHospede);
		
		tfNomeHospede = new JTextField();
		tfNomeHospede.setBounds(72, 13, 404, 20);
		contentPane.add(tfNomeHospede);
		tfNomeHospede.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(Color.BLACK);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBounds(486, 12, 136, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane TelaMostraHospede = new JScrollPane();
		TelaMostraHospede.setBounds(10, 51, 612, 329);
		contentPane.add(TelaMostraHospede);
		
	}
}
