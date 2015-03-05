package endereco;

/**
 * Classe que representa um endereco de um hospede
 * @author akylles
 *
 */
public class Endereco {

	private String pais, estado, cidade, rua, numResidencia;

	/**
	 * Construtor da classe
	 * @param pais
	 * 			O pais onde mora o hospede
	 * @param estado
	 * 			O estado onde mora o hospede
	 * @param cidade
	 * 			A cidade onde mora o hospede
	 * @param rua
	 * 			A rua onde mora o hospede
	 * @param numResidencia
	 * 			O numero da residencia onde mora o hospede
	 */
	public Endereco(String pais, String estado, String cidade, String rua,
			String numResidencia) {
		super();
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
		this.numResidencia = numResidencia;
	}

	/**
	 * Recupera o nome do pais onde mora o hospede
	 * @return O nome do pais onde mora o hospede
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Configura o pais do endereco
	 * @param pais
	 * 			o novo pais do endereco
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	/**
	 * Recupera o nome do estado onde mora o hospede
	 * @return O nome do estado onde mora o hospede
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Configura o estado do endereco
	 * @param estado
	 * 			o novo estado do endereco
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	/**
	 * Recupera o nome da cidade onde mora o hospede
	 * @return O nome da cidade onde mora o hospede
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Configura a cidade do endereco
	 * @param cidade
	 * 			a nova cidade do endereco
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	/**
	 * Recupera o nome da rua onde mora o hospede
	 * @return O nome da rua onde mora o hospede
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * Configura a rua do endereco
	 * @param rua
	 * 			a rua do endereco
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	/**
	 * Recupera o numero da residencia onde mora o hospede
	 * @return O numero da residencia onde mora o hospede
	 */
	public String getNumResidencia() {
		return numResidencia;
	}
	
	/**
	 * Configura o numero de residencia do endereco
	 * @param numResidencia
	 * 			o numero de residencia do endereco
	 */
	public void setNumResidencia(String numResidencia) {
		this.numResidencia = numResidencia;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Endereco))
			return false;
		Endereco endereco = (Endereco) obj;
		
		return this.getPais().equals(endereco.getPais()) &&
				this.getEstado().equals(endereco.getEstado()) &&
				this.getCidade().equals(endereco.getCidade()) &&
				this.getRua().equals(endereco.getRua()) &&
				this.getNumResidencia().equals(endereco.getNumResidencia());
	}// fim do equals

	@Override
	public String toString() {
		
		return String.format("PAIS: %s\n" +
							"ESTADO: %s\n" +
							"CIDADE: %s\n" +
							"RUA: %s\n" +
							"NUM.RESIDENCIA: %s",
							this.getPais(), this.getEstado(), this.getCidade(), this.getRua(), this.getNumResidencia());
	}// fim do toString

		
}// fim da classe
