package contrato;

import static org.junit.Assert.*;
import gerenteServicos.GerenteServicos;
import hospede.Hospede;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import quartoExecutivo.TemCamaExtra;
import quartoExecutivo.TipoQuartoExecutivo;
import aluguelCarros.TemSeguro;
import aluguelCarros.TemTanqueCheio;
import aluguelCarros.TipoCarro;
import endereco.Endereco;
import estrategiaDeCalculo.NatalReveillon;
import estrategiaDeCalculo.SaoJoao;
import estrategiaDeCalculo.Tarifacao;

public class ContratoTest {
	private Contrato contrato;
	private Calendar dataInicial = Calendar.getInstance();
	private Calendar dataFinal = Calendar.getInstance();
	private Hospede hospede, hospede2;
	private Tarifacao tarifa = new SaoJoao();
	private GerenteServicos gerente;
	private Endereco endereco;
	
	@Before
	public void testContrato() {
		String pais = "Brasil";
		String estado = "Bahia";
		String cidade = "Salvador";
		String rua = "Rua qualquer";
		String numResidencia = "333";
		endereco = new Endereco(pais, estado, cidade, rua, numResidencia);
		
		String nome = "Maria";
		String cpf = "1000";
		hospede = new Hospede(nome, cpf, dataInicial, endereco, "123");
		hospede2 = new Hospede("maria", cpf, dataInicial, endereco, "321");
		
		contrato = new Contrato(dataInicial, dataFinal, hospede, tarifa);
		gerente = new GerenteServicos(contrato);
		gerente.criaServicoQuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.SIMPLES,TemCamaExtra.SIM );
		gerente.criaServicoSuplementarAluguelCarros(Calendar.getInstance(), Calendar.getInstance(), "asd123", TemTanqueCheio.SIM, TemSeguro.SIM, TipoCarro.EXECUTIVO);
		gerente.criaServicoSuplementarRestaurante(Calendar.getInstance(), Calendar.getInstance(), 100);
         
	}

	@Test
	public void testGetHospede() {
		assertTrue(contrato.getHospede().equals(hospede));
	}

	@Test
	public void testSetHospede() {
		contrato.setHospede(hospede2);
		assertTrue(contrato.getHospede().equals(hospede2));
	}

	@Test
	public void testGetTarifacao() {
		Tarifacao tarifa2 = new SaoJoao();
		assertTrue(contrato.getTarifacao().getPreco(100) == tarifa2.getPreco(100));
	}

	@Test
	public void testSetTarifacao() {
		Tarifacao tarifa2 = new NatalReveillon();
		contrato.setTarifacao(tarifa2);
		assertTrue(contrato.getTarifacao().equals(tarifa2));
	}

	@Test
	public void testGetServicos() {
		assertTrue(contrato.getServicos().size() == 3 );
	}

	//@Test
	public void testSetServicos() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckin() {
		contrato.checkin();
		assertTrue(contrato.getEstadoDoContrato().equals("ABERTO"));
	}

	@Test
	public void testCheckout() {
		String fatura2 = "FATURA DO CONTRATO: " + "/n";
		double custo2 = 0;
		
		for (int i = 0; i < contrato.getServicos().size(); i++) {
			fatura2 += contrato.getServicos().get(i).toString() + "/n";
			fatura2 += "------------------------" + "/n";
			custo2 += contrato.getServicos().get(i).getCusto();
		}
		
		custo2 = tarifa.getPreco(custo2);
		fatura2 += "duracao do contrato:0";
		
		checkout checkout2 = new checkout(fatura2, custo2);
		
		assertTrue(contrato.checkout().getFatura().equals(checkout2.getFatura()));
		assertTrue(contrato.checkout().getCusto() == checkout2.getCusto());
		assertTrue(contrato.getEstadoDoContrato().equals("FECHADO"));
	}

	@Test
	public void testDuracaoContrato() {
		assertTrue(contrato.duracaoContrato() == 0);
	}

	@Test
	public void testGetDataInicial() {
		assertTrue(contrato.getDataInicial().equals(dataInicial));
	}

	@Test
	public void testSetDataInicial() {
		Calendar data2 = Calendar.getInstance();
		contrato.setDataInicial(data2);
		assertTrue(contrato.getDataInicial().equals(data2));
	}

	@Test
	public void testGetDataFinal() {
		assertTrue(contrato.getDataFinal().equals(dataFinal));
	}

	@Test
	public void testSetDataFinal() {
		Calendar data2 = Calendar.getInstance();
		contrato.setDataFinal(data2);
		assertTrue(contrato.getDataFinal().equals(data2));
	}
	
	@Test
	public void testgetEstadoDoContrato(){
		contrato.checkin();
		assertTrue(contrato.getEstadoDoContrato().equals("ABERTO"));
		contrato.checkout();
		assertTrue(contrato.getEstadoDoContrato().equals("FECHADO"));
		
	}


}
