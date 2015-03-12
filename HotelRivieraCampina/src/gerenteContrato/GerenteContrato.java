package gerenteContrato;

import hospede.Hospede;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import contrato.Contrato;
import contrato.checkout;
import estrategiaDeCalculo.Tarifacao;

/**
 * 
 * @author heitor
 *
 */
public class GerenteContrato {
	
	private List<Contrato> contratos;
	private int nCheckin = 0;
	private int nCheckout = 0;
	
	/**
	 * gera um objeto contrato que servira para manipular os contratos do hotel
	 */
	public GerenteContrato(){
		contratos = new ArrayList<Contrato>();
	}
	
	//criar,
	/**
	 * 
	 * @param dataInicial a data inicial do chekin do contrato
	 * @param dataFinal  a data final do chekin do contrato
	 * @param hospede   o Hospede responsável pelo contrato	
	 * @param tarifacao A tarifacao nessessária para o calculo do custo
	 * @return retorna o contrato criado
	 */
	public Contrato Checkin(Calendar dataInicial, Calendar dataFinal,Hospede hospede,Tarifacao tarifa){
		Contrato contrato = new Contrato(dataInicial,dataFinal,hospede,tarifa);
		contrato.checkin();
		contratos.add(contrato);
		 nCheckin++;
		return contrato;
	}
	
	// pesquisar numero do hospede,
	/**
	 * a pesquisa funciona recebendo um hospede como parametro
	 * e entao um laço compara esse hospede com todos os hospedes que tem na lista 
	 * 
	 * @param hospede nome do hospde a ser pesquisadp
 	 * @return caso o hospede seja encontrado ele retonar o hospede
 	 * 			caso nao o metodo retorna null
	 */
	public Contrato pesquisaContrato(Hospede hospede){
		for (int i = 0; i < contratos.size(); i++) {
			if (contratos.get(i).getHospede().equals(hospede)) {
				return contratos.get(i);
			}
		}
		return null;
	}
	
	
	// atualizar
	/**
	 * o metodo atualizar funciona da seguinte forma:
	 *  sera repassado o Contrato a ser atualizado, e seus atributos novos
	 *  caso o utilizador nao queira atualizar um atributo basta passar NULL no lugar do atributo
	 * 
	 * @param contrato o Contrato a ser atualizado
	 * @param dataInicial A nova data inicial
	 * @param dataFinal A nova Data Final
	 * @param hospede o novo Hospede
	 * @param tarifacao uma nova tarifacao
	 * @return retorna o contrato atualizado
	 */
	public Contrato atualizarContrato(Contrato contrato,Calendar dataInicial, Calendar dataFinal,Hospede hospede,Tarifacao tarifacao ){
		if(!dataInicial.equals(null)){
			contrato.setDataInicial(dataInicial);
		}
		if(!dataFinal.equals(null)){
			contrato.setDataFinal(dataFinal);
		}
		if(!hospede.equals(null)){
			contrato.setHospede(hospede);
		}
		if(!tarifacao.equals(null)){
			contrato.setTarifacao(tarifacao);
		}
		return contrato;
		
	}
	
	
	// remover
	/**
	 *  remove um contrato da lista
	 * @param contrato a ser removido
	 */
	public void removeContrato(Contrato contrato){
		contratos.remove(contrato);
	}

	/**
	 * 
	 * @return retorna uma lista contendo contratos
	 */
	public List<Contrato> getContratos() {
		return contratos;
	}
	
	/**
	 *  realiza o chekout de acordo com especificacao
	 * @param contrato contrato que se deseja realizar o checkout
	 * @return um objeto checkout contendo a custo do contrato e a fatura de todos os servicos
	 */
	public checkout checkout(Contrato contrato){
		removeContrato(contrato);
		nCheckout++;
		return contrato.checkout();
	}

	/**
	 * 
	 * @param contrato contrato que se deseja pegar o hospde
	 * 
	 * @return o hospede do determinado contrato
	 */
	public Hospede getHospede(Contrato contrato){
		return contrato.getHospede();
	}
	
	/**
	 * 
	 * @return o numero de chekins feitos 
	 */
	public int getnCheckin() {
		return nCheckin;
	}

	/**
	 * 
	 * @return o numero de checkout feitos
	 */
	public int getnCheckout() {
		return nCheckout;
	}
	
	

}
