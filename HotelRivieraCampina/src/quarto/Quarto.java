package quarto;

import java.util.Calendar;

import contrato.Contrato;
import servico.Servico;

/**
 * Classe Quarto
 * 
 * @author Alexandre, Heitor, Caio e Akylles.
 *
 */
public abstract class Quarto extends Servico{

	/**
	 * Construtor da classe
	 * @param dataInicial
	 * 			(Calendar) A data de inicio do aluguel de quarto.
	 * @param dataFinal
	 * 			(Calendar) A data do fim do aluguel de quarto.
	 */
	public Quarto(Calendar dataInicial, Calendar dataFinal, Contrato contrato){
		super(dataInicial, dataFinal, contrato);
	}

	/**
	 * Recupera a quantidade de dias em que o quarto foi alugado.
	 * @return (int) O numero de dias de aluguel do quarto.
	 */
	public int getNumeroDiasAluguel(){
		long dataInicial = super.getDataInicial().getTimeInMillis();   // A data de solicitação em milisegundos
		long dataFinal = super.getDataFinal().getTimeInMillis();	   // A data de finalizacao em milisegundos
		final int DIA_MILISEGUNDOS = 24 * 60 * 60 * 1000;              // O valor correspondente a um dia em milisegundos
		
		// Calcula a quantidade de dias em que o quarto esteve alugado e atribui o resultado a uma variavel
		int quantidadeDiasAluguel = ((int)((dataFinal - dataInicial) / DIA_MILISEGUNDOS)) + 1;
		
		return quantidadeDiasAluguel;
	}
	
}// fim da classe