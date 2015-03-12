package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class telaServicos extends JFrame {

	private JPanel contentPane;
	private Color corFundo = new Color(244, 246, 245); 
	private Color corBotao = new Color(68, 133, 244);
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public telaServicos() {
		setTitle("Servi\u00E7os");
		
		setBounds(400, 200, 729, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane MostraServicos = new JScrollPane();
		MostraServicos.setBounds(10, 29, 693, 393);
		contentPane.add(MostraServicos);
		
		JList list = new JList();
		MostraServicos.setViewportView(list);
	}

}
