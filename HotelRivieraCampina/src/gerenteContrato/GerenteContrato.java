package gerenteContrato;

import hospede.Hospede;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import contrato.Contrato;
import contrato.checkout;
import estrategiaDeCalculo.Tarifacao;

public class GerenteContrato {
	
	private List<Contrato> contratos;
	private int nCheckin = 0;
	private int nCheckout = 0;
	
	public GerenteContrato(){
		contratos = new ArrayList<Contrato>();
	}
	
	//criar,
	public Contrato Checkin(Calendar dataInicial, Calendar dataFinal,Hospede hospede,Tarifacao tarifa){
		Contrato contrato = new Contrato(dataInicial,dataFinal,hospede,tarifa);
		contrato.checkin();
		contratos.add(contrato);
		 nCheckin++;
		return contrato;
	}
	
	// pesquisar numero do hospede,
	public Contrato pesquisaContrato(Hospede hospede){
		for (int i = 0; i < contratos.size(); i++) {
			if (contratos.get(i).getHospede().equals(hospede)) {
				return contratos.get(i);
			}
		}
		return null;
	}
	
	
	
	
	// atualizar
	public Contrato atualizarContrato(Contrato contrato,Tarifacao tarifa ){
		contrato.setTarifacao(tarifa);
		return contrato;
		
	}
	
	
	// remover
	public void removeContrato(Contrato contrato){
		contratos.remove(contrato);
	}

	
	public List<Contrato> getContratos() {
		return contratos;
	}
	
	
	public checkout checkout(Contrato contrato){
		removeContrato(contrato);
		nCheckout++;
		return contrato.checkout();
	}

	
	public Hospede getHospede(Contrato contrato){
		return contrato.getHospede();
	}
	
	public int getnCheckin() {
		return nCheckin;
	}

	public int getnCheckout() {
		return nCheckout;
	}
	
	

}
