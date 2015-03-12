package contrato;

/**
 * 
 * @author heitor
 *
 */
public class checkout {
	
	private String Fatura;
	private double custo;
	
	/**
	 * 
	 * @param Fatura
	 * 		uma String contendo o toString de todos os servicos do contrato
	 * @param custo
	 * 		um Double somando o preco de cada respectivo servico no contrato
	 */
	public checkout(String Fatura,double custo){
	this.Fatura = Fatura;
	this.custo = custo;
	}

	/**
	 * 
	 * @return 
	 * 		uma String contendo os detalhes de cada servico do contrato
	 */
	public String getFatura() {
		return Fatura;
	}

	/**
	 * 
	 * @param fatura 
	 * 		troca uma fatura por outra
	 */
	public void setFatura(String fatura) {
		Fatura = fatura;
	}

	/**
	 * 
	 * @return
	 * 		retorna um double contendo a soma do preco de cada servico
	 */
	public double getCusto() {
		return custo;
	}

	/**
	 * 
	 * @param custo
	 * 		um novo custo no chekout;
	 */
	public void setCusto(double custo) {
		this.custo = custo;
	}

	
}
