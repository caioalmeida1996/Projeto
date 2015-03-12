package babysitter;

import java.util.Calendar;

import contrato.Contrato;
import servico.ServicoSuplementar;

/**
 * Classe Babysitter 
 * 
 * @author Akylles.
 *
 */
public class Babysitter extends ServicoSuplementar{
	
	private int numHorasValorDobrado; // Contador do numero de horas em que o servico sera cobrado em dobro
	
	/**
	 * Construtor da classe
	 * @param dataInicial
	 * 			A data de inicio do servico
	 * @param dataFinal
	 * 			A data do fim do servico
	 */
	public Babysitter(Calendar dataInicial, Calendar dataFinal,Contrato contrato) {
		super(dataInicial, dataFinal, contrato);
	}

	/**
	 * Calcula a quantidade de horas em que uma crianca foi deixada sob os
	 * cuidados do servico de babysitter.
	 * @return (int) A quantidade de horas de tutela.
	 */
	public int getNumeroHoras(){
		long horaInicial = super.getDataInicial().getTimeInMillis();  // Conversao da data inicial para milisegundos
		long horaFinal = super.getDataFinal().getTimeInMillis();     // Conversao da data final para milisegundos
		final int HORA_MILISEGUNDOS = 60 * 60 * 1000;                     // Conversao de uma hora para milisegundos
		
		int quantidadeHoras = (int) ((horaFinal - horaInicial) / HORA_MILISEGUNDOS);
		return quantidadeHoras;
	}

	public int getNumHorasValorDobrado(){
		this.numHorasValorDobrado = 0;
		this.getCusto();
		
		return this.numHorasValorDobrado;
	}
	
	@Override
	public double getCusto() {
		int somador = 0;  // somador dos valores de todas as horas de babysitter 
		
		int horaInicial = super.getDataInicial().get(Calendar.HOUR_OF_DAY); // ponto de partida do contador do for.
		
		for (int i = horaInicial; i < horaInicial + this.getNumeroHoras(); i++){
			int horaCorrente = i - 24 * (i / 24);
			
			if (horaCorrente >= 7 && horaCorrente < 18){
				somador += 25;
			}else{
				somador += 50;
				numHorasValorDobrado++;
			}
		}// fim do for
		
		return somador;
	}// fim do metodo custo()
	
	@Override
	public boolean equals(Object objeto) {
		if (!(objeto instanceof Babysitter))
			return false;
		Babysitter baby = (Babysitter) objeto;
		
		return super.getDataInicial().DAY_OF_YEAR == baby.getDataInicial().DAY_OF_YEAR &&
				super.getDataFinal().DAY_OF_YEAR == baby.getDataFinal().DAY_OF_YEAR &&
				this.getCusto() == baby.getCusto();
	}// fim do esquals
	
	@Override
	public String toString() {
		
		return String.format("Servico de Babysitter:\n" +
							"Data/hora Iniciais: %d/%d/%d, as %d hs\n" +
							"Data/hora Finais: %d/%d/%d, as %d hs\n" +
							"Qtde. Horas Tarifa Normal: %d\n" +
							"Qtde. Horas Tarifa Dobrada: %d\n" +
							"Qtde. Horas Totais: %d\n" +
							"Preco: %.2f R$\n",
							super.getDataInicial().get(Calendar.DAY_OF_MONTH),
							super.getDataInicial().get(Calendar.MONTH),
							super.getDataInicial().get(Calendar.YEAR),
							super.getDataInicial().get(Calendar.HOUR_OF_DAY),
							super.getDataFinal().get(Calendar.DAY_OF_MONTH),
							super.getDataFinal().get(Calendar.MONTH),
							super.getDataFinal().get(Calendar.YEAR),
							super.getDataFinal().get(Calendar.HOUR_OF_DAY),
							this.getNumeroHoras() - this.getNumHorasValorDobrado(),
							this.getNumHorasValorDobrado(),
							this.getNumeroHoras(),
							this.getCusto());
	}// fim do toString
	
}// fim da classe