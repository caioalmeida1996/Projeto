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
	private Hospede hospede;
	private List<Servico> servicos;
	private String estadoDoContrato;
	private Calendar dataInicial,dataFinal;
	private checkout checkout; 
	private Tarifacao tarifacao;
	
	
	/**
	 * 
	 * @param dataInicial a data inicial do chekin do contrato
	 * @param dataFinal  a data final do chekin do contrato
	 * @param hospede   o Hospede responsável pelo contrato	
	 * @param tarifacao A tarifacao nessessária para o calculo do custo
	 */
	public Contrato(Calendar dataInicial, Calendar dataFinal,Hospede hospede,Tarifacao tarifacao) {
		super();
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.hospede = hospede;
		this.tarifacao = tarifacao;
		servicos = new ArrayList<Servico>();
		checkin();
	}

	/**
	 * 
	 * @return Hospede
	 * 		retorna um objeto hospede
	 */
	public Hospede getHospede() {
		return hospede;
	}

	/**
	 * 
	 * @param hospede novo hospede
	 * 			Subestitui o hospede por outro
	 */
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	/**
	 * 
	 * @return a tarifacao
	 * 		retona um objeto que calcula a tarifa do periodo
	 */
	public Tarifacao getTarifacao() {
		return tarifacao;
	}

	/**
	 * 
	 * @param tarifacao a tarifa
	 * 			troca a tarifa por uma nova
	 */
	public void setTarifacao(Tarifacao tarifacao) {
		this.tarifacao = tarifacao;
	}

	/**
	 * 
	 * @return Servicos
	 * 		retorna uma lista contendo todos os servicos do contrato
	 */
	public List<Servico> getServicos() {
		return servicos;
	}

	/**
	 * 
	 * @param servicos
	 * 		troca a lista de servicos por outra.
	 */
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	/**
	 * realiza o checkin no contrato
	 * e atribui o estado a "ABERTO"
	 */
	public void checkin(){
		estadoDoContrato = "ABERTO";
	}
	
	/**
	 * realiza o checkout no contrato
	 * criando um objeto "checkout" e colocando o contrato com estado "FECHADO"
	 * 
	 * @return CHEKOUT
	 * 		retorna um objeto contendo a tarifa e o preço total do contrato
	 */
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
	
	/**
	 * 
	 * @return a duração do contrato
	 * 			a quantidade de dias que o contrato esta aberto
	 */
	public int duracaoContrato(){
		int duracao = dataFinal.DAY_OF_YEAR - dataInicial.DAY_OF_YEAR;
		return duracao;
	}

	/**
	 * 
	 * @return a data inicial do contrato
	 */
	public Calendar getDataInicial() {
		return dataInicial;
	}

	/**
	 * 
	 * @param dataInicial muda a data inicial do contrato
	 */
	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	/**
	 * 
	 * @return retona a data fibal do contrato
 	 */
	public Calendar getDataFinal() {
		return dataFinal;
	}

	/**
	 * 
	 * @param dataFinal muda a data final do contrato
	 */
	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}

	/**
	 * 
	 * @return o estado do contrato
	 * 		se ele esta "ABERTO" ou "FECHADO"
	 */
	public String getEstadoDoContrato() {
		return estadoDoContrato;
	}
	
	
}// fim da classe
