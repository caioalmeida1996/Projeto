package restaurante;

import java.util.Calendar;

import contrato.Contrato;
import servico.ServicoSuplementar;

/**
 * Classe Refeicao
 * @author Alexandre, Heitor, Caio e Akylles.
 */
public class Refeicao extends ServicoSuplementar{

	private double valor;
	
	/**
	 * Construtor da classe
	 * @param dataInicial
	 * @param dataFinal
	 * @param valor
	 */
	public Refeicao(Calendar dataInicial, Calendar dataFinal, double valor,Contrato contrato) {
		super(dataInicial, dataFinal, contrato);
		this.valor = valor;
	}

	/**
	 * Configura a quantia que custaram as refeicaoes consumidas
	 * @param valor 
	 * 			(double) o valor da refeicao coobrado pelo restaurante 
	 */
	public void setValor(double valor){
		this.valor = valor;
	}
	
	@Override
	public double getCusto() {
		return this.valor;
	}

	@Override
	public boolean equals(Object objeto) {
		if (!(objeto instanceof Refeicao))
			return false;
		Refeicao refeicao = (Refeicao) objeto;
		
		return super.getDataInicial().DAY_OF_YEAR == refeicao.getDataInicial().DAY_OF_YEAR &&
				super.getDataFinal().DAY_OF_YEAR == refeicao.getDataFinal().DAY_OF_YEAR &&
				this.getCusto() == refeicao.getCusto();
	}
	
	@Override
	public String toString() {
		
		return String.format("Servico de Restaurante:\n" +
				"Data Inicial: %d/%d/%d\n" +
				"Data Final: %d/%d/%d\n" +
				"Preco: %.2f R$",
				super.getDataInicial().get(Calendar.DAY_OF_MONTH), 
				super.getDataInicial().get(Calendar.MONTH),
				super.getDataInicial().get(Calendar.YEAR),
				super.getDataInicial().get(Calendar.DAY_OF_MONTH), 
				super.getDataInicial().get(Calendar.MONTH),
				super.getDataInicial().get(Calendar.YEAR),
				this.getCusto());
				
	}
	
}// fim da classe