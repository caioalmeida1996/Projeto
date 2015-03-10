package suitePresidencial;

import java.util.Calendar;

import contrato.Contrato;
import quarto.Quarto;

/**
 * Classe Suite Presidencial
 * 
 * @author Alexandre, Heitor, Caio e Akylles.
 *
 */
public class SuitePresidencial extends Quarto{

	private static double valorDiaria = 1200;
	
	/**
	 * Construtor da classe
	 * @param dataInicial
	 * 			(Calendar) A data de inicio do aluguel da suite
	 * @param dataFinal
	 * 			(Calendar) A data de fim do aluguel da suite
	 */
	public SuitePresidencial(Calendar dataInicial, Calendar dataFinal,Contrato contrato) {
		super(dataInicial, dataFinal, contrato);		
	}
	
	/**
	 * Recupera o valor monetario de uma diaria de aluguel em uma suite presidencial
	 * @return O valor monetario da diaria
	 */
	public static double getValorDiaria() {
		return valorDiaria;
	}
	
	@Override
	public double getCusto() {
		return super.getNumeroDiasAluguel() * getValorDiaria();
	}

	@Override
	public boolean equals(Object objeto) {
		if (!(objeto instanceof SuitePresidencial))
			return false;
		SuitePresidencial suite = (SuitePresidencial) objeto;
		
		return this.getDataInicial().getTime().equals(suite.getDataInicial().getTime()) &&
				this.getDataFinal().getTime().equals(suite.getDataFinal().getTime()) &&
				this.getCusto() == suite.getCusto();
	}
	
	@Override
	public String toString() {
		
		return String.format("Suite Presidencial:\n" +
				"Data Inicial: %d/%d/%d\n" +
				"Data Final: %d/%d/%d\n" +
				"Preco: %.2f R$",
				super.getDataInicial().get(Calendar.DAY_OF_MONTH), 
				super.getDataInicial().get(Calendar.MONTH),
				super.getDataInicial().get(Calendar.YEAR),
				super.getDataFinal().get(Calendar.DAY_OF_MONTH), 
				super.getDataFinal().get(Calendar.MONTH),
				super.getDataFinal().get(Calendar.YEAR),
				this.getCusto());
				
	}
	
}// fim da classe
