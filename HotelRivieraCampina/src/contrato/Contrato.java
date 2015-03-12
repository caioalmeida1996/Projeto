package contrato;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import estrategiaDeCalculo.Tarifacao;
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
	private Calendar dataInicial,dataFinal;
	private checkout checkout; 
	private Tarifacao tarifacao;
	
	public Contrato(Calendar dataInicial, Calendar dataFinal,Hospede hospede,String numCartao, Tarifacao tarifacao) {
		super();
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.hospede = hospede;
		this.numCartao = numCartao;
		this.tarifacao = tarifacao;
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
	
	public Tarifacao getTarifacao() {
		return tarifacao;
	}

	public void setTarifacao(Tarifacao tarifacao) {
		this.tarifacao = tarifacao;
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
	
	public contrato.checkout checkout(){
		String fatura = "FATURA DO CONTRATO: " + "/n";
		double custo = 0;
		
		for (int i = 0; i < servicos.size(); i++) {
			fatura += servicos.get(i).toString() + "/n";
			fatura += "------------------------" + "/n";
			custo += servicos.get(i).getCusto();
		}
		
		custo = this.tarifacao.getPreco(custo);
		fatura += "duracao do contrato:" + duracaoContrato();
		
		checkout = new checkout(fatura, custo);
		estadoDoContrato = "FECHADO";
		return checkout;
	}

	private int DiferencaDiaFinaDiaAtual(){
		return Calendar.getInstance().DAY_OF_YEAR - dataFinal.DAY_OF_YEAR;}
	
	public int duracaoContrato(){
		int duracao = dataFinal.DAY_OF_YEAR - dataInicial.DAY_OF_YEAR;
		return duracao;
	}

	public Calendar getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Calendar getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getEstadoDoContrato() {
		return estadoDoContrato;
	}
	
	
	
	
		
	
}// fim da classe
