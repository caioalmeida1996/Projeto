package telas;

import hotel.Hotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.border.LineBorder;

import java.awt.SystemColor;

public class MainLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfLogin;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLogin frame = new MainLogin();
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
	public MainLogin() {
		setTitle("Hotel Riviera Campina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.GRAY);
		lblLogin.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		lblLogin.setBounds(46, 24, 70, 29);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBackground(Color.WHITE);
		lblSenha.setForeground(Color.GRAY);
		lblSenha.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		lblSenha.setBounds(46, 64, 70, 33);
		contentPane.add(lblSenha);
		
		tfLogin = new JTextField();
		tfLogin.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		tfLogin.setBounds(151, 24, 200, 29);
		contentPane.add(tfLogin);
		tfLogin.setColumns(10);
		tfLogin.setBorder(null);
		
		Color corFundo = new Color(244, 246, 245); 
		Color corBotao = new Color(68, 133, 244);
		contentPane.setBackground(corFundo);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(Color.BLACK);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfLogin.getText().equals("admin")
						&& pfSenha.getText().equals("admin")) {
					TelaPrincipal TP = new TelaPrincipal();
					TP.show();
					hide();

				} else
					JOptionPane.showMessageDialog(null, "Acesso Negado");
				{
					tfLogin.setText("");
					pfSenha.setText("");
				}
			}
		});
		
		btnEntrar.setBorder(null);
		btnEntrar.setBackground(corBotao);
		
		btnEntrar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		btnEntrar.setBounds(10, 126, 194, 29);
		contentPane.add(btnEntrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				tfLogin.setText("");
				pfSenha.setText("");
			}
		});
		
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(corBotao);
		
		btnCancelar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		btnCancelar.setBounds(215, 126, 194, 29);
		contentPane.add(btnCancelar);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(151, 68, 200, 29);
		contentPane.add(pfSenha);
		pfSenha.setBorder(null);
		
	}
}
