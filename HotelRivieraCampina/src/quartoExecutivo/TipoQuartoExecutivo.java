package quartoExecutivo;

/**
 * Enumeracao que representa o tipo de um quarto executivo: simples, duplo ou triplo
 * @author akylles
 *
 */
public enum TipoQuartoExecutivo {

	SIMPLES(360), DUPLO(385), TRIPLO(440);
	
	private int precoDiaria;
	
	/**
	 * Construtor da enumeracao
	 * @param precoDiaria
	 * 			O preco de uma diaria no quarto
	 */
	private TipoQuartoExecutivo(int precoDiaria){
		this.precoDiaria = precoDiaria;
	}
	
	/**
	 * Recupera o preco de uma diaria no quarto
	 * @return (double) o preco da diaria
	 */
	public int getPrecoDiaria(){
		return this.precoDiaria;
	}
	
}
