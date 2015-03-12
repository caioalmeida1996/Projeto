package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class telaRelatorio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public telaRelatorio() {
		setTitle("Relatorio");
		
		setBounds(420, 230, 648, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPaneRelatorio = new JScrollPane();
		scrollPaneRelatorio.setBounds(10, 62, 612, 318);
		contentPane.add(scrollPaneRelatorio);
		
		JList list = new JList();
		scrollPaneRelatorio.setViewportView(list);
	}
}
