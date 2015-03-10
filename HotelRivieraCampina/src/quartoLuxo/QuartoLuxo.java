package quartoLuxo;

import java.util.Calendar;

import contrato.Contrato;
import quarto.Quarto;
import quartoExecutivo.TemCamaExtra;

/**
 * Classe Quarto Luxo
 * @author akylles
 *
 */
public class QuartoLuxo extends Quarto{

	private TipoQuartoLuxo tipoQuarto;
	private TemCamaExtra camaExtra;
	
	/**
	 * Construtor da classe
	 * @param dataInicial
	 * 			A data de entrada do hospede no quarto
	 * @param dataFinal
	 * 			A data de saida do hospede no quarto
	 * @param tipoQuarto
	 * 			O tipo de quarto luxo alugado: simples, duplo ou triplo
	 * @param camaExtra
	 * 			Assegura se o quarto eh alugado com cama extra ou nao
	 */
	public QuartoLuxo(Calendar dataInicial, Calendar dataFinal, TipoQuartoLuxo tipoQuarto, TemCamaExtra camaExtra, Contrato contrato) {
		super(dataInicial, dataFinal, contrato);
		this.tipoQuarto = tipoQuarto;
		this.camaExtra = camaExtra;
	}

	/**
	 * Recupera o tipo de quarto luxo.
	 * @return o tipo de quarto luxo: simples, duplo ou triplo
	 */
	public TipoQuartoLuxo getTipoQuarto(){
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
		if (!(objeto instanceof QuartoLuxo))
			return false;
		QuartoLuxo quarto = (QuartoLuxo) objeto;
		
		return this.getDataInicial().getTime().equals(quarto.getDataInicial().getTime()) &&
				this.getDataFinal().getTime().equals(quarto.getDataFinal().getTime()) &&
				this.getTipoQuarto().equals(quarto.getTipoQuarto()) &&
				this.getCamaExtra().equals(quarto.getCamaExtra()) &&
				this.getCusto() == quarto.getCusto();
	}
	
	@Override
	public String toString() {
		
		return String.format("Quarto Luxo:\n" +
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
	
}// fim da classe