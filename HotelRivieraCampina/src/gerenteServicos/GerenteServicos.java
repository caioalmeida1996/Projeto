package gerenteServicos;

import java.util.Calendar;
import java.util.List;

import babysitter.Babysitter;
import aluguelCarros.AluguelCarro;
import aluguelCarros.TemSeguro;
import aluguelCarros.TemTanqueCheio;
import aluguelCarros.TipoCarro;
import restaurante.Refeicao;
import servico.Servico;
import servico.ServicoSuplementar;
import contrato.Contrato;
import hotel.Hotel;

public class GerenteServicos extends Hotel{

	public GerenteServicos(List<Contrato> contratos) {
		super(contratos);
		
	}
	
	public void atualizarservico(String hospede, Servico novo){
		pesquisarServico(velho).
	}
	
	
	public Servico pesquisarServico(Servico servico){
		for (int i = 0; i < super.getContratos().size(); i++) { //pegar todos os contratos
			for (int j = 0; j < super.getContratos().get(i).getServicos().size(); j++) { //pegar todos os serviços de cada contrato
				if(super.getContratos().get(i).getServicos().get(i).equals(servico)){
					return super.getContratos().get(i).getServicos().get(i);
			}			
			}
			
		}
		return null;
	}
	
	
	//------------metodos para criar servicos suplementares
 	public ServicoSuplementar CriaServicoAluguelCarros(Calendar dataInicial,Calendar dataFinal, String placa, TemTanqueCheio tanque, TemSeguro seguro, TipoCarro tipo){
		ServicoSuplementar carro = new AluguelCarro(dataInicial, dataFinal, placa, tanque, seguro, tipo);
		
		return carro;		
	}
	
	
	public ServicoSuplementar CriaServicoBabysitter(Calendar dataInicial,Calendar dataFinal){
		Babysitter babysitter = new Babysitter(dataInicial, dataFinal);
		return babysitter;
		
		
	}

	
	public ServicoSuplementar CriaServicoRestaurante(Calendar dataInicial,Calendar dataFinal,double valor){
		Refeicao refeicao = new Refeicao(dataInicial, dataFinal, valor);
		return refeicao;
	}
}
