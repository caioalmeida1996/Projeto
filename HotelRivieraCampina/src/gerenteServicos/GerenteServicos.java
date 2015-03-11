package gerenteServicos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import babysitter.Babysitter;
import aluguelCarros.AluguelCarro;
import aluguelCarros.TemSeguro;
import aluguelCarros.TemTanqueCheio;
import aluguelCarros.TipoCarro;
import quarto.Quarto;
import quartoExecutivo.QuartoExecutivo;
import quartoExecutivo.TemCamaExtra;
import quartoExecutivo.TipoQuartoExecutivo;
import quartoLuxo.QuartoLuxo;
import quartoLuxo.TipoQuartoLuxo;
import restaurante.Refeicao;
import servico.Servico;
import servico.ServicoSuplementar;
import suitePresidencial.SuitePresidencial;
import contrato.Contrato;
import hotel.Hotel;

public class GerenteServicos{
	private Contrato contrato;
	


	public GerenteServicos(){
		
	}
	
	public GerenteServicos(Contrato contrato) {
		this.contrato = contrato;
	}
	
	
	
	
	//criar servicos esenciais 
	public Quarto criaServicoQuartoPresidencial(Calendar dataInicial,Calendar dataFinal){
		Quarto quarto = new SuitePresidencial(dataInicial, dataFinal, contrato);
		if (this.contrato == null) {
			return quarto;
		}
		contrato.getServicos().add(quarto);
		return quarto;
	}
	
	public Quarto criaServicoQuartoLuxo(Calendar dataInicial, Calendar dataFinal, TipoQuartoLuxo tipoQuarto, TemCamaExtra camaExtra){
		Quarto quarto = new QuartoLuxo(dataInicial,dataFinal, tipoQuarto, camaExtra, contrato);
		if (this.contrato == null) {
			return quarto;
		}
		contrato.getServicos().add(quarto);
		return quarto;
	}
	
	public Quarto criaServicoQuartoExecutivo(Calendar dataInicial, Calendar dataFinal, TipoQuartoExecutivo tipoQuarto, TemCamaExtra camaExtra){
		Quarto quarto = new QuartoExecutivo(dataInicial, dataFinal, tipoQuarto, camaExtra, contrato);
		if (this.contrato == null) {
			return quarto;
		}
		contrato.getServicos().add(quarto);
		return quarto;
	}
	
	
	//------------metodos para criar servicos suplementares
 	public ServicoSuplementar CriaServicoSuplementarAluguelCarros(Calendar dataInicial,Calendar dataFinal, String placa, TemTanqueCheio tanque, TemSeguro seguro, TipoCarro tipo){
		ServicoSuplementar carro = new AluguelCarro(dataInicial, dataFinal, placa, tanque, seguro, tipo, contrato);
		if (contrato == null) {
			return carro;
		}
		contrato.getServicos().add(carro);
		return carro;		
	}
	
	public ServicoSuplementar CriaServicoSuplementarBabysitter(Calendar dataInicial,Calendar dataFinal){
		Babysitter babysitter = new Babysitter(dataInicial, dataFinal, contrato);
		if (contrato == null) {
			return babysitter;
		}
		contrato.getServicos().add(babysitter);
		return babysitter;
		
		
	}

	public ServicoSuplementar CriaServicoSuplementarRestaurante(Calendar dataInicial,Calendar dataFinal,double valor){
		Refeicao refeicao = new Refeicao(dataInicial, dataFinal, valor,contrato);
		if (contrato == null) {
			return refeicao;
		}
		contrato.getServicos().add(refeicao);
		return refeicao;
	}
	
	
	//adicionar servico
	public void adiconarServico(Servico servico){
		contrato.getServicos().add(servico);
	}
	
	//pesquisar
	public Servico pesquisaServico(Calendar datainicial){
		for (int i = 0; i < contrato.getServicos().size(); i++) {
			if (contrato.getServicos().get(i).getDataInicial().equals(datainicial)) {
				return contrato.getServicos().get(i);
				
			}
			
		}
		return null;
	}
	
	//atualizar
	public Servico AtualizarServico(Calendar datainicial, Servico novoservico){
		Servico servicovelho = pesquisaServico(datainicial);
		servicovelho.setContrato(novoservico.getContrato());
		servicovelho.setDataFinal(novoservico.getDataFinal());
		servicovelho.setDataInicial(novoservico.getDataInicial());
		return servicovelho;
	}
	
	//remover
	public void removeServico(Servico servico){
		contrato.getServicos().remove(servico);
	}

	public List<Servico> getServicos() {
		return contrato.getServicos();
	}
	
	
		

	

}
