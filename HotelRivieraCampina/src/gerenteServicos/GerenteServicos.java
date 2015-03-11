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
 	public ServicoSuplementar criaServicoSuplementarAluguelCarros(Calendar dataInicial,Calendar dataFinal, String placa, TemTanqueCheio tanque, TemSeguro seguro, TipoCarro tipo){
		ServicoSuplementar carro = new AluguelCarro(dataInicial, dataFinal, placa, tanque, seguro, tipo, contrato);
		if (contrato == null) {
			return carro;
		}
		contrato.getServicos().add(carro);
		return carro;		
	}
	
	public ServicoSuplementar criaServicoSuplementarBabysitter(Calendar dataInicial,Calendar dataFinal){
		Babysitter babysitter = new Babysitter(dataInicial, dataFinal, contrato);
		if (contrato == null) {
			return babysitter;
		}
		contrato.getServicos().add(babysitter);
		return babysitter;
		
		
	}

	public ServicoSuplementar criaServicoSuplementarRestaurante(Calendar dataInicial,Calendar dataFinal,double valor){
		Refeicao refeicao = new Refeicao(dataInicial, dataFinal, valor,contrato);
		if (contrato == null) {
			return refeicao;
		}
		contrato.getServicos().add(refeicao);
		return refeicao;
	}
	
	
	//adicionar servico
	public void adiconarServico(Servico servico) throws Exception{
		if(contrato.equals(null)) throw new Exception("ERROR, contrato ausente.");
		contrato.getServicos().add(servico);
	}
	
	//pesquisar
	public Servico pesquisaServico(Servico servico) throws Exception{
		if(contrato.equals(null)) throw new Exception("ERROR, contrato ausente.");
		for (int i = 0; i < contrato.getServicos().size(); i++) {
			if (contrato.getServicos().get(i).equals(servico)) {
				return contrato.getServicos().get(i);
				
			}
			
		}
		return null;
	}
	
	//atualizar
	public Servico atualizarServicoQuarto(Quarto quarto,Calendar dataInicial,Calendar dataFinal) throws Exception{
		if(!dataFinal.equals(null)){
			quarto.setDataFinal(dataFinal);
			}
		if(!dataInicial.equals(null)){
			quarto.setDataFinal(dataInicial);
			}
		
		return quarto;
	}
	
	public Servico atualizarServicoSuplementarCarro(AluguelCarro carro, Calendar dataInicial,Calendar dataFinal, String placa, TemTanqueCheio tanque, TemSeguro seguro, TipoCarro tipo){
		if(!dataFinal.equals(null)){
			carro.setDataFinal(dataFinal);
			}
		if(!dataInicial.equals(null)){
			carro.setDataFinal(dataInicial);
			}
		if(!placa.equals(null)){
			carro.setPlaca(placa);
			}
		if(!tanque.equals(null)){
			carro.setTanque(tanque);
			}
		if(!seguro.equals(null)){
			carro.setSeguro(seguro);
			}
		return carro;
		
	}

	public Servico atualizarServicoSuplementarBabysitter(Babysitter baby ,Calendar dataInicial,Calendar dataFinal){
		if(!dataFinal.equals(null)){
			baby.setDataFinal(dataFinal);
			}
		if(!dataInicial.equals(null)){
			baby.setDataFinal(dataInicial);
			}
		return baby;
	}

	public ServicoSuplementar criaServicoSuplementarRestaurante(Refeicao restaurante, Calendar dataInicial,Calendar dataFinal,double valor){
		if(!dataFinal.equals(null)){
			restaurante.setDataFinal(dataFinal);
			}
		if(!dataInicial.equals(null)){
			restaurante.setDataFinal(dataInicial);
			}
		if(!(valor == 0)){
			restaurante.setValor(valor);
			}
		return restaurante;
		
	}

	
	//remover
	public void removeServico(Servico servico) throws Exception{
		if(contrato.equals(null)) throw new Exception("ERROR, contrato ausente.");
		contrato.getServicos().remove(servico);
	}

	public List<Servico> getServicos() throws Exception {
		System.out.println(contrato);
		if(contrato == null) throw new Exception("ERROR, contrato ausente.");
		return contrato.getServicos();
	}
	
	
		

	

}
