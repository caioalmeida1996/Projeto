package telas;

import hospede.Hospede;
import hotel.Hotel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

import org.hamcrest.CoreMatchers;

import contrato.Contrato;

import java.awt.Font;
import java.awt.Color;

public class TelaHospedes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color corFundo = new Color(244, 246, 245); 
	private Color corBotao = new Color(68, 133, 244);
	private JPanel contentPane;
	private JTextField tfProcurarHospede;
	public JList<Hospede> list = null;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaHospedes() {
		setTitle("Ficha de Hospedes");
		
		setBounds(400, 200, 729, 551);
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
		
		JScrollPane TelaMostraHospede = new JScrollPane();
		TelaMostraHospede.setBounds(20, 62, 685, 387);
		contentPane.add(TelaMostraHospede);
		
		list = new JList<Hospede>();
		TelaMostraHospede.setViewportView(list);
		final DefaultListModel<Hospede> listModel = new DefaultListModel<Hospede>();
		
		for (int i = 0; i < 
				TelaPrincipal.hotel.getGerenteHospede().getHospedes().size(); i++) {
			listModel.addElement(TelaPrincipal.hotel.getGerenteHospede().getHospedes().get(i));
		}
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setForeground(Color.WHITE);
		btnProcurar.setBorder(null);
		btnProcurar.setBackground(corBotao);
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.clear();
				String busca = tfProcurarHospede.getText();
				
				if (busca.length() < 2) {
					JOptionPane.showMessageDialog(null,"Seja mais especifico em sua busca");
					JOptionPane.showMessageDialog(null,
							TelaPrincipal.hotel.getGerenteHospede().getHospedes().get(0).getNome());
					
				} else {
					
						
						for (int i = 0; i < TelaPrincipal.hotel.getGerenteHospede().getHospedes().size(); i++) {
//							System.out.println(TelaPrincipal.hotel.getContratos().get(i).getHospede().getNome());
//							System.out.println(TelaPrincipal.hotel.getContratos().get(i).getHospede().getNome().contains(busca));
							if (TelaPrincipal.hotel.getGerenteHospede().getHospedes().get(i).getNome().contains(busca))
								listModel.addElement(TelaPrincipal.hotel.getGerenteHospede().getHospedes().get(i));
						}
					
				}
				
			}
		});
		
		
		list.setModel(listModel);
		btnProcurar.setBounds(307, 128, 147, 41);
		getContentPane().add(btnProcurar);
		
		JLabel lblResultadosDaSua = new JLabel("Resultados da sua Busca:");
		lblResultadosDaSua.setBounds(42, 169, 160, 30);
		getContentPane().add(lblResultadosDaSua);
		
		btnProcurar.setBounds(487, 31, 117, 23);
		btnProcurar.setBorder(null);
		btnProcurar.setBackground(corBotao);
		contentPane.add(btnProcurar);
		
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
//				EditaHospede TEO = new EditaHospede(list.getSelectedValue());
//				TEO.show();
			}
		});
		btnEditar.setBounds(207, 474, 142, 28);
		contentPane.add(btnEditar);
	}
}
