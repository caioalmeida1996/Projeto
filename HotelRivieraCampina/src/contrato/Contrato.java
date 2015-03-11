package contrato;

import java.util.ArrayList;
import java.util.List;

import quarto.Quarto;
import hospede.Hospede;
import servico.*;

/**
 * Classe Contrato
 * @author akylles
 *
 */
public class Contrato {

	//private Hospede hospede;
	private String numCartao;
	private List<Servico> servicos;
	
	public Contrato(String numCartao) {
		super();
		//this.hospede = hospede;
		this.numCartao = numCartao;
		servicos = new ArrayList<Servico>();
	}

	/*public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}*/

	public String getNumCartao() {
		return numCartao;
	}

	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}


	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
		
}// fim da classe
