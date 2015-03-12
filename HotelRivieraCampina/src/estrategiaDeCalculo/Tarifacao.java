package estrategiaDeCalculo;

/**
 * Interface que serve de auxilio no calculo de tarifaco do contrato
 * de acordo com a epoca
 * @author raimundohsm
 *
 */
public interface Tarifacao {

	/**
	 * Metodo que calcula o preco de um contrato passado por parametro
	 * de acordo com a estrategia
	 * @param valor
	 * 			O valor do contrato 
	 * @return o valor calculado de acordo com a estrategia
	 */	
	public abstract double getPreco(double valor);
	
}
