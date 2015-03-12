package gerenteContrato;

import hospede.Hospede;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import contrato.Contrato;
import contrato.checkout;

public class GerenteContrato {
	
	private List<Contrato> contratos;
	
	public GerenteContrato(){
		contratos = new ArrayList<Contrato>();
		
	}
	
	//criar,
	public Contrato Checkin(Calendar dataInicial, Calendar dataFinal,Hospede hospede, String numCartao){
		Contrato contrato = new Contrato(dataInicial,dataFinal, hospede,numCartao);
		contrato.checkin();
		contratos.add(contrato);
		return contrato;
	}
	
	// pesquisar,
	public Contrato pesquisaContrato(String numCartao){
		for (int i = 0; i < contratos.size(); i++) {
			if (contratos.get(i).getNumCartao().equals(numCartao)) {
				return contratos.get(i);
			}
		}
		return null;
	}
	
	
	// atualizar
	public Contrato atualizarContrato(Contrato contrato,String numCartao ){
		contrato.setNumCartao(numCartao);
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
		return contrato.checkout();
	}
	

}
