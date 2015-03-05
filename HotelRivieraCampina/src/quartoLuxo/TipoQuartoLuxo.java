package quartoLuxo;

/**
 * Enumeracao que indica o tipo de um quarto de luxo: simples, duplo ou triplo
 * @author akylles
 *
 */
public enum TipoQuartoLuxo {
	SIMPLES(520), DUPLO(570), TRIPLO(620);
	
	private int precoDiaria;
	
	/**
	 * Construtor da enumeracao
	 * @param precoDiaria
	 * 			O preco de uma diaria no quarto
	 */
	private TipoQuartoLuxo(int precoDiaria){
		this.precoDiaria = precoDiaria;
	}
	
	/**
	 * Recupera o preco da diaria
	 * @return
	 */
	public int getPrecoDiaria(){
		return this.precoDiaria;
	}
	
}
