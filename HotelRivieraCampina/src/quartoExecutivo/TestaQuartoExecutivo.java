package quartoExecutivo;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import suitePresidencial.SuitePresidencial;

public class TestaQuartoExecutivo {

	private Calendar dataInicial, dataFinal;
	
	@Before
	public void iniciaDatas(){
		dataInicial = Calendar.getInstance();
		dataFinal = Calendar.getInstance();
	}
	
	@Test
	public void testaDatas() {
		// Configurando a data inicial como cinco de agosto de 1973
		dataInicial.set(1973, 8, 5);
		// Configurando a data final como sete de agosto de 1973
		dataFinal.set(1973, 8, 7);
				
		// Criando um quarto executivo simples com essas datas
		QuartoExecutivo quarto = new QuartoExecutivo(dataInicial, dataFinal, TipoQuartoExecutivo.SIMPLES, TemCamaExtra.NAO);
		
		// Assertivas
		assertTrue(quarto.getDataInicial().equals(dataInicial));
		assertTrue(quarto.getDataFinal().equals(dataFinal));
		assertFalse(quarto.getDataInicial().equals(dataFinal));
		assertFalse(quarto.getDataFinal().equals(dataInicial));
		assertTrue(quarto.getCamaExtra().equals(TemCamaExtra.NAO));
		assertFalse(quarto.getCamaExtra().equals(TemCamaExtra.SIM));
	}// fim do metodo

	@Test
	public void testaQuartoExecutivoSimples(){		
		// Configurando a data inicial como treze de maio de 2003
		dataInicial.set(2003, 5, 13);
		// Configurando a data final como treze de maio de 2003
		dataFinal.set(2003, 5, 13);
		
		// Em um quarto executivo simples que foi alugado e entregue no mesmo dia
		// espera-se que seja cobrado o valor de uma diaria, 360 R$.
		QuartoExecutivo quarto = new QuartoExecutivo(dataInicial, dataFinal, TipoQuartoExecutivo.SIMPLES, TemCamaExtra.SIM);
		assertTrue(quarto.getCusto() == 360);
		
		// Em dois dias de alguel de um quarto executivo simples eh esperado um custo de duas diarias, 720 R$
		dataFinal.set(2003, 5, 14);
		quarto.setDataFinal(dataFinal);
		assertTrue(quarto.getCusto() == 720);
		assertTrue(quarto.getCamaExtra().equals(TemCamaExtra.SIM));
	}// fim do metodo
	
	@Test
	public void testaQuartoExecutivoDuplo(){		
		// Configurando a data inicial como treze de maio de 2003
		dataInicial.set(2003, 5, 13);
		// Configurando a data final como treze de maio de 2003
		dataFinal.set(2003, 5, 13);
		
		// Em um quarto executivo duplo que foi alugado e entregue no mesmo dia
		// espera-se que seja cobrado o valor de uma diaria, 385 R$.
		QuartoExecutivo quarto = new QuartoExecutivo(dataInicial, dataFinal, TipoQuartoExecutivo.DUPLO, TemCamaExtra.NAO);
		assertTrue(quarto.getCusto() == 385);
		
		// Em dois dias de alguel de um quarto executivo duplo eh esperado um custo de duas diarias, 770 R$
		dataFinal.set(2003, 5, 14);
		quarto.setDataFinal(dataFinal);
		assertTrue(quarto.getCusto() == 770);
		assertTrue(quarto.getCamaExtra().equals(TemCamaExtra.NAO));
	}// fim do metodo

	@Test
	public void testaQuartoExecutivoTriplo(){		
		// Configurando a data inicial como treze de maio de 2003
		dataInicial.set(2003, 5, 13);
		// Configurando a data final como treze de maio de 2003
		dataFinal.set(2003, 5, 13);
		
		// Em um quarto executivo triplo que foi alugado e entregue no mesmo dia
		// espera-se que seja cobrado o valor de uma diaria, 440 R$.
		QuartoExecutivo quarto = new QuartoExecutivo(dataInicial, dataFinal, TipoQuartoExecutivo.TRIPLO, TemCamaExtra.SIM);
		assertTrue(quarto.getCusto() == 440);
		
		// Em dois dias de alguel de um quarto executivo duplo eh esperado um custo de duas diarias, 880 R$
		dataFinal.set(2003, 5, 14);
		quarto.setDataFinal(dataFinal);
		assertTrue(quarto.getCusto() == 880);
		assertTrue(quarto.getCamaExtra().equals(TemCamaExtra.SIM));
	}// fim do metodo

	@Test
	public void testaEquals(){
		dataInicial.set(2004, 10, 13);
		dataFinal.set(2004, 10, 13);
		
		QuartoExecutivo quarto1 = new QuartoExecutivo(dataInicial, dataFinal, TipoQuartoExecutivo.SIMPLES, TemCamaExtra.NAO);
		QuartoExecutivo quarto2 = new QuartoExecutivo(dataInicial, dataFinal, TipoQuartoExecutivo.SIMPLES, TemCamaExtra.NAO);
		assertTrue(quarto1.equals(quarto1));
		assertTrue(quarto1.equals(quarto2));
		assertTrue(quarto2.equals(quarto1));
		
		QuartoExecutivo quarto3 = new QuartoExecutivo(dataInicial, dataFinal, TipoQuartoExecutivo.TRIPLO, TemCamaExtra.NAO);
		assertFalse(quarto1.equals(quarto3));
		assertFalse(quarto3.equals(quarto1));
		
		Calendar outraData1 = Calendar.getInstance();
		Calendar outraData2 = Calendar.getInstance();
		outraData1.set(2015, 5, 1);
		outraData2.set(2015, 5, 13);
		
		QuartoExecutivo quarto4 = new QuartoExecutivo(outraData1, outraData2, TipoQuartoExecutivo.SIMPLES, TemCamaExtra.NAO);
		
		assertFalse(quarto4.equals(quarto1));
		assertFalse(quarto1.equals(quarto4));
		assertFalse(quarto2.equals(quarto4));
		assertFalse(quarto3.equals(quarto4));
		assertTrue(quarto4.equals(quarto4));
		
		QuartoExecutivo quarto5 = new QuartoExecutivo(outraData1, outraData2, TipoQuartoExecutivo.SIMPLES, TemCamaExtra.SIM);
		assertFalse(quarto5.equals(quarto4));
		assertFalse(quarto4.equals(quarto5));
		assertTrue(quarto5.equals(quarto5));
		
		QuartoExecutivo quarto6 = new QuartoExecutivo(outraData1, outraData2, TipoQuartoExecutivo.SIMPLES, TemCamaExtra.SIM);
		assertTrue(quarto5.equals(quarto6));
		assertTrue(quarto6.equals(quarto5));
		assertFalse(quarto5.equals(new SuitePresidencial(outraData1, outraData2)));
		
	}
	
	@Test
	public void testaToString(){
		dataInicial.set(2004, 9, 13);
		dataFinal.set(2004, 9, 14);
		
		QuartoExecutivo quarto = new QuartoExecutivo(dataInicial, dataFinal, TipoQuartoExecutivo.TRIPLO, TemCamaExtra.SIM);
		
		String mensagem = "Quarto Executivo:\n" +
				  "Tipo: TRIPLO\n" +
				  "Tem Cama Extra? SIM\n" +
				  "Data Inicial: 13/9/2004\n" +
				  "Data Final: 14/9/2004\n" +
				  "Preco: 880,00 R$";

		assertTrue(quarto.toString().equals(mensagem));		

	}
	
}// fim da classe
