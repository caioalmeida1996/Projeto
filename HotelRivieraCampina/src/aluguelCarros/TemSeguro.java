package aluguelCarros;

/**
 * Enumeracao que indica se o carro foi alugado com seguro ou nao
 * @author akylles
 *
 */
public enum TemSeguro {

	SIM(100), NAO(0);
	
	private int valor;
	
	/**
	 * Construtor da enumeracao
	 * @param valor
	 */
	private TemSeguro(int valor){
		this.valor = valor;
	}
	
	/**
	 * Recupera o valor do seguro
	 * @return (int) o valor do seguro
	 */
	public int getValor(){
		return this.valor;
	}
	
}
