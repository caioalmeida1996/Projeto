package telas;

import hospede.Hospede;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEditaHospede extends JFrame {
	
	Color corFundo = new Color(244, 246, 245); 
	Color corBotao = new Color(68, 133, 244);

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfDataDeNascimento;
	private JTextField tfPais;
	private JTextField tfRua;
	private JTextField tfCidade;
	private JTextField textField_1;
	private JTextField tfNumero;

	/**
	 * Create the frame.
	 */
	public TelaEditaHospede(Hospede hospede) {
		setTitle("Editar Hospede");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNome.setBounds(26, 22, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lbCpf = new JLabel("CPF:");
		lbCpf.setBounds(26, 49, 70, 15);
		contentPane.add(lbCpf);
		
		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(26, 76, 70, 15);
		contentPane.add(lblNascimento);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(273, 22, 70, 15);
		contentPane.add(lblPais);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(273, 49, 70, 15);
		contentPane.add(lblEstado);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(273, 90, 70, 15);
		contentPane.add(lblCidade);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(273, 136, 70, 15);
		contentPane.add(lblRua);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(273, 175, 70, 15);
		contentPane.add(lblNumero);
		
		tfNome = new JTextField();
		tfNome.setBounds(86, 19, 114, 19);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		tfNome.setText(hospede.getNome());
		
		tfCpf = new JTextField();
		tfCpf.setBounds(86, 49, 114, 19);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		tfNome.setText(hospede.getCpf());
		
		tfDataDeNascimento = new JTextField();
		tfDataDeNascimento.setBounds(96, 74, 114, 19);
		contentPane.add(tfDataDeNascimento);
		tfDataDeNascimento.setColumns(10);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		tfDataDeNascimento.setText(sdf.format(hospede.getDataNascimento()));
		
		tfPais = new JTextField();
		tfPais.setBounds(349, 20, 114, 19);
		contentPane.add(tfPais);
		tfPais.setColumns(10);
		tfPais.setText(hospede.getEndereco().getPais());
		
		tfRua = new JTextField();
		tfRua.setBounds(349, 47, 114, 19);
		contentPane.add(tfRua);
		tfRua.setColumns(10);
		tfRua.setText(hospede.getEndereco().getRua());
		
		tfCidade = new JTextField();
		tfCidade.setBounds(349, 88, 114, 19);
		contentPane.add(tfCidade);
		tfCidade.setColumns(10);
		
		tfRua = new JTextField();
		tfRua.setBounds(349, 133, 114, 19);
		contentPane.add(tfRua);
		tfRua.setColumns(10);
		
		tfNumero = new JTextField();
		tfNumero.setBounds(353, 172, 114, 19);
		contentPane.add(tfNumero);
		tfNumero.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(44, 171, 108, 38);
		btnSalvar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBorder(null);
		btnSalvar.setBackground(corBotao);
		
		contentPane.add(btnSalvar);
	}
}
