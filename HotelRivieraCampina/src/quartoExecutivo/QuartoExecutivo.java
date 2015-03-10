package quartoExecutivo;

import java.util.Calendar;

import contrato.Contrato;
import quarto.Quarto;

/**
 * Classe Quarto Executivo
 * @author akylles
 *
 */
public class QuartoExecutivo extends Quarto{

	private TipoQuartoExecutivo tipoQuarto;
	private TemCamaExtra camaExtra;
	
	/**
	 * Construtor da classe
	 * @param dataInicial
	 * 			A data de entrada do hospede no quarto
	 * @param dataFinal
	 * 			A data de saida do hospede no quarto
	 * @param tipoQuarto
	 * 			O tipo de quarto executivo alugado: simples, duplo ou triplo
	 * @param camaExtra
	 * 			Assegura se o quarto eh alugado com cama extra ou nao
	 */
	public QuartoExecutivo(Calendar dataInicial, Calendar dataFinal, TipoQuartoExecutivo tipoQuarto, TemCamaExtra camaExtra, Contrato contrato) {
		super(dataInicial, dataFinal, contrato);
		this.tipoQuarto = tipoQuarto;
		this.camaExtra = camaExtra;
	}

	/**
	 * Metodo que recupera o tipo do quarto executivo
	 * @return	o tipo do quarto executivo (simples, duplo ou triplo)
	 */
	public TipoQuartoExecutivo getTipoQuarto(){
		return this.tipoQuarto;
	}
	
	/**
	 * Metodo que verifica se o quarto possui cama extra ou nao
	 * @return	SIM ou NAO
	 */
	public TemCamaExtra getCamaExtra(){
		return this.camaExtra;
	}
	
	@Override
	public double getCusto() {
		return super.getNumeroDiasAluguel() * this.getTipoQuarto().getPrecoDiaria();
	}
	
	@Override
	public boolean equals(Object objeto) {
		if (!(objeto instanceof QuartoExecutivo))
			return false;
		QuartoExecutivo quarto = (QuartoExecutivo) objeto;
		
		return this.getDataInicial().getTime().equals(quarto.getDataInicial().getTime()) &&
				this.getDataFinal().getTime().equals(quarto.getDataFinal().getTime()) &&
				this.getTipoQuarto().equals(quarto.getTipoQuarto()) &&
				this.getCamaExtra().equals(quarto.getCamaExtra()) &&
				this.getCusto() == quarto.getCusto();
	}
	
	@Override
	public String toString() {
		
		return String.format("Quarto Executivo:\n" +
				"Tipo: %s\n" +
				"Tem Cama Extra? %s\n" +
				"Data Inicial: %d/%d/%d\n" +
				"Data Final: %d/%d/%d\n" +
				"Preco: %.2f R$",
				this.getTipoQuarto(),
				this.getCamaExtra(),
				super.getDataInicial().get(Calendar.DAY_OF_MONTH), 
				super.getDataInicial().get(Calendar.MONTH),
				super.getDataInicial().get(Calendar.YEAR),
				super.getDataFinal().get(Calendar.DAY_OF_MONTH), 
				super.getDataFinal().get(Calendar.MONTH),
				super.getDataFinal().get(Calendar.YEAR),
				this.getCusto());
				
	}
	
}