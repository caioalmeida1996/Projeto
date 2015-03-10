package aluguelCarros;

import java.util.Calendar;

import contrato.Contrato;
import servico.ServicoSuplementar;

/**
 * Classe Aluguel de Carro
 * @author Alexandre, Heitor, Caio e Akylles.@author AKYLLES
 *
 */
public class AluguelCarro extends ServicoSuplementar{
	
	private String placa;              // Uma referencia a uma placa de carro.
	private TemTanqueCheio tanque;     // Indica se o carro foi alugado com tanque cheio ou nao
	private TemSeguro seguro;	       // Indica se o carro foi alugado com seguro ou nao 
	private TipoCarro tipoDeCarro;     // O tipo de carro alugado
	
	/**
	 * Construtor da classe
	 * @param dataInicial
	 * 			A data de inicio do aluguel de carro
	 * @param dataFinal
	 * 			A data de fim do aluguel do carro
	 * @param placa
	 * 			A placa do carro
	 * @param tanque
	 * 			O estado do tanque do carro: se esta cheio ou vazio.
	 * @param seguro
	 * 			A situacao do seguro do carro: se esta com seguro ou nao.
	 * @param tipo
	 * 			O tipo de carro a ser alugado
	 */
	public AluguelCarro(Calendar dataInicial, Calendar dataFinal, String placa,
			TemTanqueCheio tanque, TemSeguro seguro, TipoCarro tipo,Contrato contrato) {
		super(dataInicial, dataFinal, contrato);
		this.placa = placa;
		this.tanque = tanque;
		this.seguro = seguro;
		this.tipoDeCarro = tipo;
	}
	
	/**
	 * Recupera a placa do carro
	 * @return uma string que representa a placa do carro
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * Configura a placa do carro
	 * @param placa
	 * 		uma string que representa a placa
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	/**
	 * Recupera o estado do tanque do carro: se o carro foi alugado com tanque cheio incluso ou nao
	 * @return o estado do tanque
	 */
	public TemTanqueCheio getTanque() {
		return tanque;
	}
	
	/**
	 * Recupera a informacao de o carro ter sido alugado com seguro ou nao
	 * @return o estado do seguro: incluso no servico de carro ou nao
	 */
	public TemSeguro getSeguro() {
		return seguro;
	}
	
	/**
	 * Configura a opcao de o carro ter tanque cheio
	 * @param tanque
	 */
	public void setTanque(TemTanqueCheio tanque) {
		this.tanque = tanque;
	}
	
	/**
	 * Configura a opcao de o carro ser alugado com seguro
	 * @param seguro
	 */
	public void setSeguro(TemSeguro seguro) {
		this.seguro = seguro;
	}
	
	/**
	 * Recupera o tipo de carro alugado
	 * @return o tipo de carro
	 */
	public TipoCarro getTipoDeCarro(){
		return this.tipoDeCarro;
	}
	
	/**
	 * Configura o tipo de carro
	 * @param tipo
	 */
	public void setTipoDeCarro(TipoCarro tipo){
		this.tipoDeCarro = tipo;
	}
	
	/**
	 * Calcula e retorna a quantidade de dias em que o carro foi alugado.
	 * @return (int) O numero de dias de aluguel do carro.
	 */
	public int getNumeroDiasAluguel(){
		long dataInicial = super.getDataInicial().getTimeInMillis();  // A data de solicitação em milisegundos
		long dataFinal = super.getDataFinal().getTimeInMillis();	      // A data de devolução em milisegundos
		final int DIA_MILISEGUNDOS = 24 * 60 * 60 * 1000;                 // O valor correspondente a um dia em milisegundos
		
		// Calcula a quantidade de dias em que o carro esteve alugado e atribui o resultado a uma variavel
		int quantidadeDiasAluguel = ((int)((dataFinal - dataInicial) / DIA_MILISEGUNDOS)) + 1;
		
		return quantidadeDiasAluguel;
	}// fim do metodo
	
	/**
	 * Recupera o valor da diaria do quarto
	 * @return o valor da diaria do quarto
	 */
	public double getDiaria(){
		return this.getTipoDeCarro().getValorDiaria();
	}
	
	@Override
	public double getCusto() {
		return this.getNumeroDiasAluguel() * this.getDiaria() + this.tanque.getValor() + this.seguro.getValor();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AluguelCarro))
			return false;
		AluguelCarro carro = (AluguelCarro) obj;	
		
		return super.getDataInicial().getTime().equals(carro.getDataInicial().getTime()) &&
				super.getDataFinal().getTime().equals(carro.getDataFinal().getTime()) &&
				this.getPlaca().equals(carro.getPlaca()) &&
				this.getTanque().equals(carro.getTanque()) &&
				this.getSeguro().equals(carro.getSeguro()) &&
				this.getTipoDeCarro().equals(carro.getTipoDeCarro()) &&
				this.getCusto() == carro.getCusto();
	}
	
	@Override
	public String toString() {

		return String.format("Aluguel de Carro:\n" +
				"Data Inicial: %d/%d/%d\n" +
				"Data Final: %d/%d/%d\n" +
				"Placa: %s\n" +
				"Tipo de Carro: %s\n" +
				"Foi alugado com tanque cheio? %s\n" +
				"Foi alugado com seguro? %s\n" +
				"Preco: %.2f R$",
				super.getDataInicial().get(Calendar.DAY_OF_MONTH), 
				super.getDataInicial().get(Calendar.MONTH),
				super.getDataInicial().get(Calendar.YEAR),
				super.getDataFinal().get(Calendar.DAY_OF_MONTH), 
				super.getDataFinal().get(Calendar.MONTH),
				super.getDataFinal().get(Calendar.YEAR),
				this.getPlaca(),
				this.getTipoDeCarro(),
				this.getTanque(),
				this.getSeguro(),
				this.getCusto());
	
	}// fim do toString
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// final da classe