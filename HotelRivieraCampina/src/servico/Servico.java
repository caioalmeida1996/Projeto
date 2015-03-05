package servico;

import java.util.Calendar;

/**
 * Classe Servico
 * 
 * @author Alexandre, Heitor, Caio e Akylles. 
 *
 */
public abstract class Servico {
	
	private Calendar dataInicial, dataFinal; // as datas em que o servico foi iniciado e finalizado, respectivamente.
	
	/**
	 * Construtor da classe
	 * @param dataInicial
	 * 			data de inicio de um servico
	 * @param dataFinal
	 * 			data de fim de um servico
	 */
	public Servico(Calendar dataInicial, Calendar dataFinal){
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	/**
	 * Recupera a data de solicitacao do servico
	 * @return (Calendar) A data de solicitacao do servico
	 */
	public Calendar getDataInicial() {
		return dataInicial;
	}

	/** Configura o dia em que algum servico do hotel foi solicitado 
	 * @param data
	 * 			(Calendar) Um objeto que indica ano, mes, dia e hora em que um
	 * 			servico foi solicitado ao hotel
	 */
	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	/**
	 * Recupera a data de finalizacao do servico.
	 * @return (Calendar) A data de finalizacao do servico.
	 */
	public Calendar getDataFinal() {
		return dataFinal;
	}

	/** Configura o dia em que algum servico do hotel foi finalizado 
	 * @param data
	 * 			(Calendar) Um objeto que indica ano, mes, dia e hora em que um
	 * 			servico do hotel foi finalizado.
	 */
	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	/**
	 * Metodo que recupera o custo do servico
	 * @return um valor real que representa o custo
	 */
	public abstract double getCusto();
	
}// fim da classe
