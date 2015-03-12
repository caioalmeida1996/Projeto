package contrato;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import quarto.Quarto;
import hospede.Hospede;
import servico.*;

/**
 * Classe Contrato
 * @author akylles,Heitor
 *
 */
public class Contrato {

	//private Hospede hospede;
	private String numCartao;
	private Hospede hospede;
	private List<Servico> servicos;
	private String estadoDoContrato;
	Calendar dataInicial,dataFinal;
	
	public Contrato(Calendar dataInicial, Calendar dataFinal,Hospede hospede,String numCartao) {
		super();
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.hospede = hospede;
		this.numCartao = numCartao;
		servicos = new ArrayList<Servico>();
		checkin();
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

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

	public void checkin(){
		estadoDoContrato = "ABERTO";
	}
	
	public void checkout(){
		String fatura = null;
		for (int i = 0; i < servicos.size(); i++) {
			fatura += servicos.get(i).toString() + "/n";			
		}
		
	}
	
	public int duracaoContrato(){
		int duracao = dataFinal.DAY_OF_YEAR - dataInicial.DAY_OF_YEAR;
		return duracao;
	}
	
	
		
	
}// fim da classe
