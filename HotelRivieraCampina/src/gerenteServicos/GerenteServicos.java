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
 	public AluguelCarro criaServicoSuplementarAluguelCarros(Calendar dataInicial,Calendar dataFinal, String placa, TemTanqueCheio tanque, TemSeguro seguro, TipoCarro tipo){
		AluguelCarro carro = new AluguelCarro(dataInicial, dataFinal, placa, tanque, seguro, tipo, contrato);
		if (contrato == null) {
			return carro;
		}
		contrato.getServicos().add(carro);
		return carro;		
	}
	
	public Babysitter criaServicoSuplementarBabysitter(Calendar dataInicial,Calendar dataFinal){
		Babysitter babysitter = new Babysitter(dataInicial, dataFinal, contrato);
		if (contrato == null) {
			return babysitter;
		}
		contrato.getServicos().add(babysitter);
		return babysitter;
		
		
	}

	public Refeicao criaServicoSuplementarRestaurante(Calendar dataInicial,Calendar dataFinal,double valor){
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
	public Quarto atualizarServicoQuarto(Quarto quarto,Calendar dataInicial,Calendar dataFinal) throws Exception{
		if(!dataFinal.equals(null)){
			quarto.setDataFinal(dataFinal);
			}
		if(!dataInicial.equals(null)){
			quarto.setDataFinal(dataInicial);
			}
		
		return quarto;
	}
	
	public AluguelCarro atualizarServicoSuplementarCarro(AluguelCarro carro, Calendar dataInicial,Calendar dataFinal, String placa, TemTanqueCheio tanque, TemSeguro seguro, TipoCarro tipo){
		if(!(dataFinal == null)){
			System.out.println("1");
			carro.setDataFinal(dataFinal);
			}
		if(!(dataInicial == null)){
			System.out.println("2");
			carro.setDataFinal(dataInicial);
			}
		if(!(placa == null)){
			System.out.println("3");
			carro.setPlaca(placa);
			}
		if(!(tanque == null)){
			carro.setTanque(tanque);
			}
		if(!(seguro == null)){
			carro.setSeguro(seguro);
			}
		if(!(tipo == null)){
			carro.setTipoDeCarro(tipo);
		}
		return carro;
		
	}

	public Babysitter atualizarServicoSuplementarBabysitter(Babysitter baby ,Calendar dataInicial,Calendar dataFinal){
		if(!dataFinal.equals(null)){
			baby.setDataFinal(dataFinal);
			}
		if(!dataInicial.equals(null)){
			baby.setDataFinal(dataInicial);
			}
		return baby;
	}

	public Refeicao criaServicoSuplementarRestaurante(Refeicao restaurante, Calendar dataInicial,Calendar dataFinal,double valor){
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
