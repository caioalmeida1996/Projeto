package telas;

import hospede.Hospede;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.Font;
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

import quarto.Quarto;
import quartoExecutivo.QuartoExecutivo;
import quartoLuxo.QuartoLuxo;
import suitePresidencial.SuitePresidencial;
import servico.Servico;

public class TelaCheckIn extends JFrame {


	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfDataDeNascimento;
	private JTextField tfEndereco;
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
	
	
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaCheckIn() {
		setTitle("Check In");

		setBounds(300, 120, 572, 430);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 53, 59, 14);

		tfNome = new JTextField();
		tfNome.setBounds(79, 53, 169, 20);
		tfNome.setColumns(10);

		// Criando jCalendar

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 79, 42, 14);

		JLabel lblDataDeNascimento = new JLabel("Nascimento:");
		lblDataDeNascimento.setBounds(10, 105, 80, 14);

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
		tfCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCPF.setText("( ) - ");
		tfCPF.setBounds(80, 76, 169, 23);
		getContentPane().add(tfCPF);
		tfCPF.setColumns(10);

		tfDataDeNascimento = new JTextField();
		tfDataDeNascimento.setBounds(80, 102, 129, 20);
		tfDataDeNascimento.setColumns(10);

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
		lblEndereco.setBounds(295, 56, 71, 14);

		JLabel lblN = new JLabel("Cartao de Credito:");
		lblN.setBounds(295, 82, 113, 14);

		tfEndereco = new JTextField();
		tfEndereco.setBounds(407, 50, 86, 20);
		tfEndereco.setColumns(10);

		tfCartaoDeCredito = new JTextField();
		tfCartaoDeCredito.setBounds(407, 79, 86, 20);
		tfCartaoDeCredito.setColumns(10);

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
		tfCartaoDeCredito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCartaoDeCredito.setText("( ) - ");
		tfCartaoDeCredito.setBounds(419, 74, 113, 28);
		getContentPane().add(tfCartaoDeCredito);
		tfCartaoDeCredito.setColumns(10);

		JLabel lblQuarto = new JLabel("Quarto:");
		lblQuarto.setBounds(20, 195, 55, 14);

		
		RadioButtonCamaExtra.setBounds(20, 247, 111, 23);

		JLabel label = new JLabel("N\u00BA de pessoas");
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
		label_1.setBounds(247, 192, 94, 14);

		JLabel label_5 = new JLabel("Data de Saida");
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
		getContentPane().add(tfEndereco);
		getContentPane().add(lblN);
		getContentPane().add(tfCartaoDeCredito);

		JComboBox<String> comboBoxNdePessoas = new JComboBox<String>();
		comboBoxNdePessoas.setBounds(118, 220, 53, 20);
		getContentPane().add(comboBoxNdePessoas);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
//					Hospede hospede = new Hospede(tfNome.getText(),tfCPF.getText(), calHospede, tfEndereco.getText(), tfCartaoDeCredito.getText());
//					 
//					String itemSelecionado = comboBoxTipoDeQuarto.getSelectedItem().toString();
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

		JButton btnFechar = new JButton("Fechar");
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

		tfDataSaida = new JTextField();
		tfDataSaida.setBounds(393, 221, 114, 19);
		getContentPane().add(tfDataSaida);
		tfDataSaida.setColumns(10);
		comboBoxNdePessoas.addItem("1");
		comboBoxNdePessoas.addItem("2");
		comboBoxNdePessoas.addItem("3");
		comboBoxNdePessoas.addItem("4");

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
		
		if(tfEndereco.getText().equals("") || tfNome.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Nome e Endereco nao podem ser vazios");
			teveErro = true;
		}
		return teveErro;
	}
}
