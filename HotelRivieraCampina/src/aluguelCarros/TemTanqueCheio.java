package aluguelCarros;

/**
 * Enumeracao que indica se o carro foi alugado de tanque cheio ou nao
 * @author akylles
 *
 */
public enum TemTanqueCheio {
	
	SIM(150), NAO(0);
	
	private int valor;
	
	/**
	 * Construtor da enumeracao
	 * @param valor
	 * 			O valor do tanque cheio
	 */
	private TemTanqueCheio(int valor){
		this.valor = valor;
	}
	
	/**
	 * Recupera o valor do tanque cheio
	 * @return o valor do tanque cheio 
	 */
	public int getValor(){
		return this.valor;
	}
	
}