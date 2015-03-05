package hospede;

import java.util.Calendar;

import endereco.Endereco;;

/**
 * Classe que representa um hospede do hotel
 * @author akylles
 *
 */
public class Hospede {

	private String nome, cpf;
	private Calendar dataNascimento;
	private Endereco endereco;
	
	/**
	 * Construtor da classe
	 * @param nome
	 * 			nome do hospede
	 * @param cpf
	 * 			CPF do hospede
	 * @param dataNascimento
	 * 			data de nascimento do hospede
	 * @param endereco
	 * 			endereco do hospede
	 */
	public Hospede(String nome, String cpf, Calendar dataNascimento, Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	/**
	 * Recupera o nome do hospede
	 * @return	o nome do hospede
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Configura o nome do hospede
	 * @param nome
	 * 			o novo nome do hospede
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Recupera o CPF do hospede
	 * @return o CPF do hospede
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Configura o CPF do hospede
	 * @param cpf
	 * 			o novo CPF do hospede
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Recupera a data de nascimento
	 * @return a data
	 */
	public Calendar getDataNascimento(){
		return this.dataNascimento;
	}
	
	/**
	 * Configura a data de nascimento
	 * @param data
	 */
	public void setDataNascimento(Calendar data){
		this.dataNascimento = data;
	}
	
	/**
	 * Recupera o endereco do hospede
	 * @return o endereco do hospede
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * Configura o endereco do hospede
	 * @param endereco
	 * 			o novo endereco do hospede
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public boolean equals(Object objeto) {
		if (!(objeto instanceof Hospede))
			return false;
		Hospede hospede = (Hospede) objeto;
		
		return this.getNome().equals(hospede.getNome()) &&
				this.getCpf().equals(hospede.getCpf()) &&
				this.IsDatasIguais(hospede) &&
				this.getEndereco().equals(hospede.getEndereco());
	}// fim do equals
	
	/**
	 * Compara se duas datas de nascimento sao iguais.
	 * Auxilia o metodo equals
	 * @param outraData
	 * 			A outra data em comparacao
	 * @return o resultado da comparacao (true ou false)
	 */
	private boolean IsDatasIguais(Hospede outroHospede){
		return this.getDataNascimento().get(Calendar.DAY_OF_MONTH) == outroHospede.getDataNascimento().get(Calendar.DAY_OF_MONTH) &&
				this.getDataNascimento().get(Calendar.MONTH) == outroHospede.getDataNascimento().get(Calendar.MONTH) &&
				this.getDataNascimento().get(Calendar.YEAR) == outroHospede.getDataNascimento().get(Calendar.YEAR);
	}// fim do metodo
	
	@Override
	public String toString() {

		return String.format("--INFORMACOES DO HOSPEDE--\n" +
							"NOME: %s\n" +
							"CPF: %s\n" +
							"Data de Nascimento: %s\n" +
							"%s\n",
							this.getNome(),
							this.getCpf(),
							this.recuperaDataFormatada(),
							this.getEndereco().toString());
	}// fim do toString
	
	/**
	 * Metodo que retorna uma String representando a data formatada.
	 * Auxilia o metodo toString.
	 * @return uma string no formato dia/mes/ano
	 */
	private String recuperaDataFormatada(){
		
		return String.format("%d/%d/%d",
				this.getDataNascimento().get(Calendar.DAY_OF_MONTH),
				this.getDataNascimento().get(Calendar.MONTH),
				this.getDataNascimento().get(Calendar.YEAR));
		
	}// fim do metodo
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// fim da classe
