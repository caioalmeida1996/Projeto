package telas;

import hospede.Hospede;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class telaContratos extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private Color corFundo = new Color(244, 246, 245); 
	private Color corBotao = new Color(68, 133, 244);
	private JTextField tfProcurarHospede;
	public JList<Hospede> list = null;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public telaContratos() {
		setTitle("Ficha de Contratos");
		
		setBounds(100, 100, 729, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHospede = new JLabel("Hospede");
		lblHospede.setForeground(Color.GRAY);
		lblHospede.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		lblHospede.setBounds(20, 36, 86, 14);
		contentPane.add(lblHospede);
		
		tfProcurarHospede = new JTextField();
		tfProcurarHospede.setForeground(Color.LIGHT_GRAY);
		tfProcurarHospede.setFont(new Font("Arial Unicode MS", Font.PLAIN, 10));
		tfProcurarHospede.setText("Digite o nome do Hospede");
		tfProcurarHospede.setBounds(114, 33, 361, 20);
		contentPane.add(tfProcurarHospede);
		tfProcurarHospede.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProcurar.setForeground(Color.WHITE);
		btnProcurar.setBorder(null);
		btnProcurar.setBackground(corBotao);
		btnProcurar.setBounds(485, 34, 119, 20);
		getContentPane().add(btnProcurar);
		
		JButton btnDetalhes = new JButton("Detalhes");
		btnDetalhes.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		btnDetalhes.setBackground(corBotao);
		btnDetalhes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDetalhes.setForeground(Color.WHITE);
		btnDetalhes.setBorder(null);
		btnDetalhes.setBounds(20, 474, 142, 28);
		contentPane.add(btnDetalhes);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		btnEditar.setBackground(corBotao);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditar.setBounds(207, 474, 142, 28);
		contentPane.add(btnEditar);
		
		JScrollPane telaMostraContrato = new JScrollPane();
		telaMostraContrato.setBounds(10, 66, 693, 369);
		contentPane.add(telaMostraContrato);
		
		JList list_1 = new JList();
		telaMostraContrato.setViewportView(list_1);
		
		JButton btnServios = new JButton("Servi\u00E7os");
		btnServios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaAdiconaServico TAS = new telaAdiconaServico();
				TAS.show();
			}
		});
		btnServios.setBounds(386, 474, 142, 28);
		btnServios.setForeground(Color.WHITE);
		btnServios.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		btnServios.setBackground(corBotao);
		
		contentPane.add(btnServios);
	}
}
