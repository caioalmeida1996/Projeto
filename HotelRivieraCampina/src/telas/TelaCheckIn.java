package telas;

import hospede.Hospede;
import hotel.Hotel;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

//import com.toedter.calendar.JDateChooser;







import contrato.Contrato;

import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.text.MaskFormatter;

import endereco.Endereco;
import quarto.Quarto;
import quartoExecutivo.QuartoExecutivo;
import quartoLuxo.QuartoLuxo;
import suitePresidencial.SuitePresidencial;
import servico.Servico;

public class TelaCheckIn extends JFrame {

	Color corFundo = new Color(244, 246, 245); 
	Color corBotao = new Color(68, 133, 244);
	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfDataDeNascimento;
	private JTextField tfPais;
	private JTextField tfCartaoDeCredito;
	private MaskFormatter format_1; // Formato do CPf
	private MaskFormatter format_2; // Formato da Data de Nascimento
	private MaskFormatter format_3; // Formato do Cartao de Credito
	private JTextField tfDataEntrada;
	private JTextField tfDataSaida;
	private JComboBox<String> comboBoxTipoDeQuarto = new JComboBox<String>();
	private JRadioButton RadioButtonCamaExtra = new JRadioButton("Cama extra");
	private static ArrayList<Servico> servicos = new ArrayList<Servico>(); 
	private Quarto quarto;
	private Contrato contrato;
	private JTextField tfEstado;
	private JTextField tfCidade;
	private JTextField tfRua;
	private JTextField tfNumero;
	private Hospede hospede;
	
	
	
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaCheckIn(final Hotel hotel) {
		setTitle("Check In");
		
		setBounds(300, 120, 648, 430);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		lblNome.setBounds(10, 53, 113, 14);

		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		tfNome.setBounds(80, 47, 169, 20);
		tfNome.setColumns(10);
		tfNome.setBorder(null);

		// Criando jCalendar

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		lblCpf.setBounds(10, 79, 113, 14);

		JLabel lblDataDeNascimento = new JLabel("Nascimento:");
		lblDataDeNascimento.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		lblDataDeNascimento.setBounds(10, 104, 113, 14);

		tfCPF = new JTextField();
		tfCPF.setBounds(79, 79, 169, 20);
		tfCPF.setColumns(10);

		JLabel tfCPF_1 = new JLabel("tfCPF:");
		tfCPF_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		tfCPF_1.setBounds(245, 409, 70, 15);
		getContentPane().add(tfCPF_1);

		try {
			format_1 = new MaskFormatter("###.###.###-##");
			format_1.setPlaceholderCharacter('_');
		} catch (ParseException e2) {
			e2.printStackTrace();
		}

		tfCPF = new JFormattedTextField(format_1);
		tfCPF.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		tfCPF.setText("( ) - ");
		tfCPF.setBounds(80, 73, 169, 20);
		getContentPane().add(tfCPF);
		tfCPF.setColumns(10);
		tfCPF.setBorder(null);

		tfDataDeNascimento = new JTextField();
		tfDataDeNascimento.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		tfDataDeNascimento.setBounds(80, 98, 169, 20);
		tfDataDeNascimento.setColumns(10);
		tfDataDeNascimento.setBorder(null);

		JLabel tfDataDeNascimento_1 = new JLabel("tfDataDeNascimento:");
		tfDataDeNascimento_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		tfDataDeNascimento_1.setBounds(245, 409, 70, 15);
		getContentPane().add(tfDataDeNascimento_1);

		// try {
		// format_2 = new MaskFormatter("## ## #####");
		// format_2.setPlaceholderCharacter('_');
		// } catch (ParseException e2) {
		// e2.printStackTrace();
		// }

		// tfDataDeNascimento = new JFormattedTextField(format_2);
		// tfDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		// tfDataDeNascimento.setText("( ) - ");
		// tfDataDeNascimento.setBounds(104, 105, 83, 23);
		// getContentPane().add(tfDataDeNascimento);
		// tfDataDeNascimento.setColumns(10);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(147, 534, 71, 23);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(236, 534, 75, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		lblEndereco.setBounds(394, 22, 113, 14);

		JLabel lblN = new JLabel("Cartao de Credito:");
		lblN.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		lblN.setBounds(10, 129, 113, 14);

		tfPais = new JTextField();
		tfPais.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		tfPais.setBounds(393, 47, 169, 20);
		tfPais.setColumns(10);
		tfPais.setBorder(null);

		tfCartaoDeCredito = new JTextField();
		tfCartaoDeCredito.setBounds(407, 79, 86, 20);
		tfCartaoDeCredito.setColumns(10);
		tfCartaoDeCredito.setBorder(null);

		JLabel tfCartaoDeCredito_1 = new JLabel("tfCartaoDeCredito:");
		tfCartaoDeCredito_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		tfCartaoDeCredito_1.setBounds(245, 409, 70, 15);
		getContentPane().add(tfCartaoDeCredito_1);

		try {
			format_3 = new MaskFormatter("###.###.####");
			format_3.setPlaceholderCharacter('_');
		} catch (ParseException e2) {
			e2.printStackTrace();
		}

		tfCartaoDeCredito = new JFormattedTextField(format_3);
		tfCartaoDeCredito.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		tfCartaoDeCredito.setText("( ) - ");
		tfCartaoDeCredito.setBounds(106, 123, 169, 20);
		getContentPane().add(tfCartaoDeCredito);
		tfCartaoDeCredito.setColumns(10);
		tfCartaoDeCredito.setBorder(null);

		JLabel lblQuarto = new JLabel("Quarto:");
		lblQuarto.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		lblQuarto.setBounds(20, 195, 55, 14);
		RadioButtonCamaExtra.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));

		
		RadioButtonCamaExtra.setBounds(20, 247, 111, 23);

		JLabel label = new JLabel("N\u00BA de pessoas");
		label.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		label.setBounds(20, 223, 88, 14);

		comboBoxTipoDeQuarto.setBounds(68, 192, 105, 20);
		comboBoxTipoDeQuarto.addItem("Presidencial");
		comboBoxTipoDeQuarto.addItem("Luxo Simples");
		comboBoxTipoDeQuarto.addItem("Luxo Duplo");
		comboBoxTipoDeQuarto.addItem("Luxo Triplo");
		comboBoxTipoDeQuarto.addItem("Executivo Simples");
		comboBoxTipoDeQuarto.addItem("Executivo Duplo");
		comboBoxTipoDeQuarto.addItem("Executivo Triplo");

		JLabel label_1 = new JLabel("Data de Entrada");
		label_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		label_1.setBounds(247, 192, 94, 14);

		JLabel label_5 = new JLabel("Data de Saida");
		label_5.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		label_5.setBounds(393, 192, 86, 14);
//		JDateChooser entradaJdate = new JDateChooser();
//		entradaJdate.getCalendarButton().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				};
		getContentPane().setLayout(null);
		getContentPane().add(label);
		getContentPane().add(comboBoxTipoDeQuarto);
		getContentPane().add(label_1);
		getContentPane().add(label_5);
		getContentPane().add(lblQuarto);
		getContentPane().add(lblDataDeNascimento);
		getContentPane().add(lblCpf);
		getContentPane().add(lblNome);
		getContentPane().add(btnFinalizar);
		getContentPane().add(btnCancelar);
		getContentPane().add(tfNome);
		getContentPane().add(tfCPF);
		getContentPane().add(tfDataDeNascimento);
		getContentPane().add(RadioButtonCamaExtra);
		getContentPane().add(lblEndereco);
		getContentPane().add(tfPais);
		getContentPane().add(lblN);
		getContentPane().add(tfCartaoDeCredito);

		JComboBox<String> comboBoxNdePessoas = new JComboBox<String>();
		comboBoxNdePessoas.setBounds(118, 220, 53, 20);
		getContentPane().add(comboBoxNdePessoas);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Endereco endereco = new Endereco(tfPais.getText(), tfEstado.getText(), tfCidade.getText(), tfRua.getText(), tfNumero.getText());
				
				temErro();
				while (temErro() == false){
					// data de nascimento do hospede
					SimpleDateFormat formatoHospede = new SimpleDateFormat(
							"dd/MM/yyyy");
					Calendar calHospede = Calendar.getInstance();

					// data de entrada do hopede
					SimpleDateFormat formatoEntrada = new SimpleDateFormat(
							"dd/MM/yyyy");
					Calendar calEntrada = Calendar.getInstance();

					// data saida do hospede
					SimpleDateFormat formatoSaida = new SimpleDateFormat(
							"dd/MM/yyyy");
					Calendar calSaida = Calendar.getInstance();

					try {
						calHospede.setTime(formatoHospede.parse(tfDataDeNascimento.getText()));
						calEntrada.setTime(formatoEntrada.parse(tfDataEntrada.getText()));
						calSaida.setTime(formatoSaida.parse(tfDataSaida.getText()));

					} catch (ParseException e) {
						JOptionPane.showMessageDialog(null,"Formato da data tem que ser dd/MM/yyyy");
						e.printStackTrace();
					}
					//CRIA O OBJETO HOSPEDE----------------------------------------------------------
					hospede = hotel.getGerenteHospede().criaHospede(tfNome.getText(), tfCPF.getText(), calHospede, endereco);
					contrato = hotel.getGerenteContrato().Checkin(calEntrada, calSaida, hospede, tfCartaoDeCredito.getText());
					
					
					String itemSelecionado = comboBoxTipoDeQuarto.getSelectedItem().toString();
//					criaQuartos(calEntrada, calSaida, hospede, itemSelecionado);
//					servicos.add(quarto);
//					contrato = new Contrato(hospede, calEntrada, calSaida, servicos);
//					JOptionPane.showMessageDialog(null,"Cadastro feito");
//					TelaPrincipal.hotel.adicionaContrato(contrato);
//					JOptionPane.showMessageDialog(null,"Hospede: " + hospede.getNome());
//					hide();
//					break;
				}
			}

		});
		btnSalvar.setBounds(10, 332, 161, 50);
		getContentPane().add(btnSalvar);
		btnSalvar.setBorder(null);
		btnSalvar.setBackground(corBotao);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		btnFechar.setForeground(Color.WHITE);
		btnFechar.setBorder(null);
		btnFechar.setBackground(corBotao);
		btnFechar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				hide();
			}
		});
		btnFechar.setBounds(377, 332, 169, 50);
		getContentPane().add(btnFechar);

		tfDataEntrada = new JTextField();
		tfDataEntrada.setBounds(252, 221, 114, 19);
		getContentPane().add(tfDataEntrada);
		tfDataEntrada.setColumns(10);
		tfDataEntrada.setBorder(null);

		tfDataSaida = new JTextField();
		tfDataSaida.setBounds(393, 221, 114, 19);
		getContentPane().add(tfDataSaida);
		tfDataSaida.setColumns(10);
		tfDataSaida.setBorder(null);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setBounds(320, 53, 46, 14);
		getContentPane().add(lblPais);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(320, 79, 46, 14);
		getContentPane().add(lblEstado);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(320, 104, 46, 14);
		getContentPane().add(lblCidade);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(320, 129, 46, 14);
		getContentPane().add(lblRua);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(320, 155, 46, 14);
		getContentPane().add(lblNumero);
		
		tfEstado = new JTextField();
		tfEstado.setBounds(393, 73, 169, 20);
		getContentPane().add(tfEstado);
		tfEstado.setColumns(10);
		
		tfCidade = new JTextField();
		tfCidade.setBounds(393, 98, 200, 20);
		getContentPane().add(tfCidade);
		tfCidade.setColumns(10);
		
		tfRua = new JTextField();
		tfRua.setBounds(393, 123, 200, 20);
		getContentPane().add(tfRua);
		tfRua.setColumns(10);
		
		tfNumero = new JTextField();
		tfNumero.setBounds(393, 149, 200, 20);
		getContentPane().add(tfNumero);
		tfNumero.setColumns(10);
		comboBoxNdePessoas.addItem("1");
		comboBoxNdePessoas.addItem("2");
		comboBoxNdePessoas.addItem("3");
		comboBoxNdePessoas.addItem("4");
		
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		double width = screenSize.getWidth();
//		double height = screenSize.getHeight();
//		
//		if (getContentPane().getWidth() == width && getContentPane().getHeight() == height){
//			getContentPane().setLayout(new GridBagLayout());
//		}

	}
//	public void criaQuartos(Calendar calEntrada, Calendar calSaida, Hospede hospede, String itemSelecionado){
//		switch (itemSelecionado) {
//		case "Presidencial":
//			try {
//				quarto = new SuitePresidencial(calEntrada, calSaida, hospede.getNome());
//			} catch (Exception e) {
//				JOptionPane.showMessageDialog(null, e.getMessage());
//			}
//			break;
//			
//		case "Executivo Simples":
//			try {
//				quarto = new QuartoExecutivo("simples", calEntrada, calSaida, hospede.getNome(), RadioButtonCamaExtra.isSelected());				
//			} catch (Exception e){
//				JOptionPane.showMessageDialog(null, e.getMessage());
//			}
//		
//			break;
//		
//		case "Executivo Duplo":
//			try {
//				quarto = new QuartoExecutivo("duplo", calEntrada, calSaida, hospede.getNome(), RadioButtonCamaExtra.isSelected());
//			} catch (Exception e){
//				JOptionPane.showMessageDialog(null, e.getMessage());
//			}
//			break;
//		
//		case "Executivo Triplo":
//			try {
//				quarto = new QuartoExecutivo("triplo", calEntrada, calSaida, hospede.getNome(), RadioButtonCamaExtra.isSelected());
//			} catch (Exception e){
//				JOptionPane.showMessageDialog(null, e.getMessage());
//			}
//			break;
//		
//		case "Luxo Simples":
//			try {
//				quarto = new QuartoLuxo("simples", calEntrada, calSaida, hospede.getNome(), RadioButtonCamaExtra.isSelected());
//			} catch (Exception e){
//				JOptionPane.showMessageDialog(null, e.getMessage());
//			}
//			break;
//		
//		case "Luxo Duplo":
//			try {
//				quarto = new QuartoLuxo("duplo", calEntrada, calSaida, hospede.getNome(), RadioButtonCamaExtra.isSelected());
//			} catch (Exception e){
//				JOptionPane.showMessageDialog(null, e.getMessage());
//			}
//			break;
//		
//		case "Luxo Triplo":
//			try {
//				quarto = new QuartoLuxo("triplo", calEntrada, calSaida, hospede.getNome(), RadioButtonCamaExtra.isSelected());
//			} catch (Exception e){
//				JOptionPane.showMessageDialog(null, e.getMessage());
//			}
//			break;
//		}
//	}
	public boolean temErro(){
		boolean teveErro = false;
		if (tfDataDeNascimento.getText().length() != 10 || tfDataEntrada.getText().length() != 10 || tfDataSaida.getText().length() != 10) {
			JOptionPane.showMessageDialog(null,"Formato da data tem que ser dd/MM/yyyy");
			teveErro = true;
		}
		
		if (tfCPF.getText().length() != 14){
			JOptionPane.showMessageDialog(null,"CPF invalido");
			teveErro = true;
		}
		
		if (tfCartaoDeCredito.getText().length() != 12){
			JOptionPane.showMessageDialog(null,"Cartao de credito invalido");
			teveErro = true;
		}
		
		if(tfPais.getText().equals("") || tfNome.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Nome e Endereco nao podem ser vazios");
			teveErro = true;
		}
		return teveErro;
	}
}
