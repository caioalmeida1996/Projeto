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
/**
 * 
 * @author heitor
 *
 */
public class GerenteServicos{
	private Contrato contrato;
	private int nPresidencial = 5;
	private static int nLuxoSimples = 5;
	private static int nLuxoDuplo = 15;
	private static int nLuxoTriplo = 20;
	private static int nExecutivoSimples = 5;
	private static int nExecutivoDuplo = 15;
	private static int nExecutivoTriplo = 20;
	
	

	/**
	 * cria um gerente servico sem contrato associado
	 */
 	public GerenteServicos(){
		
	}
	
 	/**
 	 * cria um gerente de servico associado a um contrato passado como parametro
 	 * @param contrato 
 	 * 				contrato que tera seus servicos manipulados
 	 */
	public GerenteServicos(Contrato contrato) {
		this.contrato = contrato;
	}
	
	
	
	
	//criar servicos esenciais 
	/**
	 * cria um Servico do tipo Quarto Presidencial
	 * @param dataInicial
	 * 			data incicial da ocupacao do quarto
	 * @param dataFinal
	 * 			data final da ocupacao do quarto
	 * @return
	 * 			retorna o quarto
	 * 
	 * 			se o gerente servico estiver associado a um contrato
	 * 			adiciona o quarto ao contrato de forma automatica.
	 */
	public Quarto criaServicoQuartoPresidencial(Calendar dataInicial,Calendar dataFinal){
		Quarto quarto = new SuitePresidencial(dataInicial, dataFinal, contrato);
		if (this.contrato == null) {
			return quarto;
		}
		nPresidencial--;
		contrato.getServicos().add(quarto);
		return quarto;
	}
	
	
	/**
	 * cria um Servico do tipo Quarto Luxo
	 * 
	* @param dataInicial
	 * 			data incicial da ocupacao do quarto
	 * @param dataFinal
	 * 			data final da ocupacao do quarto
	 * @param tipoQuarto
	 * 			o tipo do quarto(simples , duplo, triplo)
	 * @param camaExtra
	 * 			informa se o quarto possui cama extra
	 * @return
	 * 			retorna o quarto
	 * 
	 * 			se o gerente servico estiver associado a um contrato
	 * 			adiciona o quarto ao contrato de forma automatica.
	 */
	public Quarto criaServicoQuartoLuxo(Calendar dataInicial, Calendar dataFinal, TipoQuartoLuxo tipoQuarto, TemCamaExtra camaExtra){
		Quarto quarto = new QuartoLuxo(dataInicial,dataFinal, tipoQuarto, camaExtra, contrato);
		if (this.contrato == null) {
			return quarto;
		}
		
		switch (tipoQuarto) {
		case SIMPLES:
			nLuxoSimples--;
			break;
		case DUPLO:
			nLuxoDuplo--;
			break;
		case TRIPLO:
			nLuxoTriplo--;
			break;

		default:
			break;
		}
		
		contrato.getServicos().add(quarto);
		return quarto;
	}
	
	
	/**
	 * cria um Servico do tipo Quarto Executivo
	 * 
	* @param dataInicial
	 * 			data incicial da ocupacao do quarto
	 * @param dataFinal
	 * 			data final da ocupacao do quarto
	 * @param tipoQuarto
	 * 			o tipo do quarto(simples , duplo, triplo)
	 * @param camaExtra
	 * 			informa se o quarto possui cama extra
	 * @return
	 * 			retorna o quarto
	 * 
	 * 			se o gerente servico estiver associado a um contrato
	 * 			adiciona o quarto ao contrato de forma automatica.
	 */
	public Quarto criaServicoQuartoExecutivo(Calendar dataInicial, Calendar dataFinal, TipoQuartoExecutivo tipoQuarto, TemCamaExtra camaExtra){
		Quarto quarto = new QuartoExecutivo(dataInicial, dataFinal, tipoQuarto, camaExtra, contrato);
		if (this.contrato == null) {
			return quarto;
		}
		
		switch (tipoQuarto) {
		case SIMPLES:
			nExecutivoSimples--;
			break;
		case DUPLO:
			nExecutivoDuplo--;
			break;
		case TRIPLO:
			nExecutivoTriplo--;
			break;

		default:
			break;
		}
		
		contrato.getServicos().add(quarto);
		return quarto;
	}
	
	
	//------------metodos para criar servicos suplementares
	
	/**
	 * cria um Servico Suplementar do tipo Aluguel de Carros
	 * @param dataInicial
	 * 			a data inicial da utilizacao do servico
	 * @param dataFinal
	 * 			a data Final da utilizacao do servico
	 * @param placa
	 * 			a placa do carro
	 * @param tanque
	 * 			informa se o tanque esta cheio ou nao
	 * @param seguro
	 * 			informa se possui seguro ou nao
	 * @param tipo
	 * 			informa o tipo do carro
	 * @return
	 * 			o servico criado;
	 * 
	 * caso o gerente servico estaja associado a um contrato, o serico criado sera automaticamnete
	 * adiciona na lista de servico do respectivo contrato.
	 */
 	public AluguelCarro criaServicoSuplementarAluguelCarros(Calendar dataInicial,Calendar dataFinal, String placa, TemTanqueCheio tanque, TemSeguro seguro, TipoCarro tipo){
		AluguelCarro carro = new AluguelCarro(dataInicial, dataFinal, placa, tanque, seguro, tipo, contrato);
		if (contrato == null) {
			return carro;
		}
		contrato.getServicos().add(carro);
		return carro;		
	}
	
 	/**
 	 * 
 	 * @param dataInicial
	 * 			a data inicial da utilizacao do servico
	 * @param dataFinal
	 * 			a data Final da utilizacao do servico
 	 * @return
	 * 			o servico criado;
	 * 
	 * caso o gerente servico estaja associado a um contrato, o serico criado sera automaticamnete
	 * adiciona na lista de servico do respectivo contrato.
	 */
	public Babysitter criaServicoSuplementarBabysitter(Calendar dataInicial,Calendar dataFinal){
		Babysitter babysitter = new Babysitter(dataInicial, dataFinal, contrato);
		if (contrato == null) {
			return babysitter;
		}
		contrato.getServicos().add(babysitter);
		return babysitter;
		
		
	}

	/**
	 * 
	 * @param dataInicial
	 * 			a data inicial da utilizacao do servico
	 * @param dataFinal
	 * 			a data Final da utilizacao do servico
	 * @param valor
	 * 			o valor da refeicao consumida
	 * @return
	 * 			o servico criado;
	 * 
	 * caso o gerente servico estaja associado a um contrato, o serico criado sera automaticamnete
	 * adiciona na lista de servico do respectivo contrato.
	 */
	public Refeicao criaServicoSuplementarRestaurante(Calendar dataInicial,Calendar dataFinal,double valor){
		Refeicao refeicao = new Refeicao(dataInicial, dataFinal, valor,contrato);
		if (contrato == null) {
			return refeicao;
		}
		contrato.getServicos().add(refeicao);
		return refeicao;
	}
	
	
	//adicionar servico
	/**
	 * adiciona um servico ao contrato
	 * @param servico
	 * 			servico a ser adicionado
	 */
	public void adiconarServico(Servico servico) throws Exception{
		if(contrato.equals(null)) throw new Exception("ERROR, contrato ausente.");
		contrato.getServicos().add(servico);
	}
	
	//pesquisar
	/**
	 *  pesquisa um servico na lista do contrato
	 * @param servico
	 * 			servico a ser pesquisado
	 * @return	
	 * 			caso encontre objeto retorna o mesmo, se nao retorna null
	 */
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
	/**
	 * atualizar o Servico de Quarto
	 * 
	 * @param quarto 
	 * 			quarto a ser atualizado
	 * @param dataInicial
	 * 			nova data inicial do servico
	 * @param dataFinal
	 * 			nova data final do contrato
	 * @return
	 * 			o servico atualizado
	 */
	public Quarto atualizarServicoQuarto(Quarto quarto,Calendar dataInicial,Calendar dataFinal) throws Exception{
		if(!dataFinal.equals(null)){
			quarto.setDataFinal(dataFinal);
			}
		if(!dataInicial.equals(null)){
			quarto.setDataFinal(dataInicial);
			}
		
		return quarto;
	}
	
	/**
	 * Atualiza um Servico Suplementar do tipo Aluguel de Carros
	 * 
	 * @param carro
	 * 			carro a ser atualizado
	 * @param dataInicial
	 * 			a nova data inicial da utilizacao do servico
	 * @param dataFinal
	 * 			a nova data Final da utilizacao do servico
	 * @param placa
	 * 			a nova placa do carro
	 * @param tanque
	 * 			informa se o tanque esta cheio ou nao
	 * @param seguro
	 * 			informa se possui seguro ou nao
	 * @param tipo
	 * 			informa o novo tipo do carro
	 * @return
	 * 			o servico atualizado;
	 */
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

	/**
 	 * @param baby
 	 * 			o baysister a ser atualizado
 	 * @param dataInicial
	 * 			a data nova inicial da utilizacao do servico
	 * @param dataFinal
	 * 			a data nova Final da utilizacao do servico
 	 * @return
	 * 			o servico atualizado;
	 * 
	 */
	public Babysitter atualizarServicoSuplementarBabysitter(Babysitter baby ,Calendar dataInicial,Calendar dataFinal){
		if(!dataFinal.equals(null)){
			baby.setDataFinal(dataFinal);
			}
		if(!dataInicial.equals(null)){
			baby.setDataFinal(dataInicial);
			}
		return baby;
	}

	/**
	 * 
	 * @param restaurante
	 * 			a refeicao a ser atualizada
	 * @param dataInicial
	 * 			a nova data inicial da utilizacao do servico
	 * @param dataFinal
	 * 			a nova data Final da utilizacao do servico
	 * @param valor
	 * 			o novo valor da refeicao consumida
	 * @return
	 * 			o servico atualizado;
	 * 
	 */
	public Refeicao atualizarServicoSuplementarRestaurante(Refeicao restaurante, Calendar dataInicial,Calendar dataFinal,double valor){
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
	/**
	 * remove um servico do contrato
	 * @param servico
	 * 			servico a ser removido
	 */
	public void removeServico(Servico servico) throws Exception{
		if(contrato.equals(null)) throw new Exception("ERROR, contrato ausente.");
		contrato.getServicos().remove(servico);
	}

	/**
	 * 
	 * @return
	 * 		retorna uma lista de servicos do contrato
	 */
	public List<Servico> getServicos() throws Exception {
		System.out.println(contrato);
		if(contrato == null) throw new Exception("ERROR, contrato ausente.");
		return contrato.getServicos();
	}

	/**
	 * 
	 * @return a quantida restante de suite presidencial
	 */
	public int getnPresidencial() {
		return nPresidencial;
	}

	/**
	 * 
	 * @return a quantida restante de quarto luxo simples
	 */
	public int getnLuxoSimples() {
		return nLuxoSimples;
	}

	/**
	 * 
	 * @return a quantida restante de quarto luxo duplo
	 */
	public int getnLuxoDuplo() {
		return nLuxoDuplo;
	}

	/**
	 * 
	 * @return a quantida restante de quarto luxo triplo
	 */
	public int getnLuxoTriplo() {
		return nLuxoTriplo;
	}

	/**
	 * 
	 * @return a quantida restante de quarto executivo simples
	 */
	public int getnExecutivoSimples() {
		return nExecutivoSimples;
	}

	/**
	 * 
	 * @return a quantida restante de quarto executivo duplo
	 */
	public int getnExecutivoDuplo() {
		return nExecutivoDuplo;
	}

	/**
	 * 
	 * @return a quantida restante de quarto executivo triplo
	 */
	public int getnExecutivoTriplo() {
		return nExecutivoTriplo;
	}
	
	

}
