package contrato;

import java.util.ArrayList;

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
	private Quarto quarto;
	private ArrayList<ServicoSuplementar> servicos;
	
	public Contrato(String numCartao, Quarto quarto) {
		super();
		//this.hospede = hospede;
		this.numCartao = numCartao;
		this.quarto = quarto;
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

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public ArrayList<ServicoSuplementar> getServicos() {
		return servicos;
	}

	public void setServicos(ArrayList<ServicoSuplementar> servicos) {
		this.servicos = servicos;
	}
		
}// fim da classe
