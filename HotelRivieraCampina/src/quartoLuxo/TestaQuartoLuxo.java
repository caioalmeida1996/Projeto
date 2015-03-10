package quartoLuxo;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import quartoExecutivo.TemCamaExtra;
import suitePresidencial.SuitePresidencial;

public class TestaQuartoLuxo {

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
		
		// Criando um quarto luxo simples com essas datas
		QuartoLuxo quarto = new QuartoLuxo(dataInicial, dataFinal, TipoQuartoLuxo.SIMPLES, TemCamaExtra.SIM, null);
		
		// Assertivas
		assertTrue(quarto.getDataInicial().equals(dataInicial));
		assertTrue(quarto.getDataFinal().equals(dataFinal));
		assertFalse(quarto.getDataInicial().equals(dataFinal));
		assertFalse(quarto.getDataFinal().equals(dataInicial));
		assertTrue(quarto.getCamaExtra().equals(TemCamaExtra.SIM));
		assertFalse(quarto.getCamaExtra().equals(TemCamaExtra.NAO));
		
	}// fim do metodo

	@Test
	public void testaQuartoLuxoSimples(){		
		// Configurando a data inicial como treze de maio de 2003
		dataInicial.set(2003, 5, 13);
		// Configurando a data final como treze de maio de 2003
		dataFinal.set(2003, 5, 13);
		
		// Em um quarto luxo simples que foi alugado e entregue no mesmo dia
		// espera-se que seja cobrado o valor de uma diaria, 520 R$.
		QuartoLuxo quarto = new QuartoLuxo(dataInicial, dataFinal, TipoQuartoLuxo.SIMPLES, TemCamaExtra.NAO, null);
		assertTrue(quarto.getCusto() == 520);
		
		// Em dois dias de alguel de um quarto luxo simples eh esperado um custo de duas diarias, 1040 R$
		dataFinal.set(2003, 5, 14);
		quarto.setDataFinal(dataFinal);
		assertTrue(quarto.getCusto() == 1040);
		
		assertTrue(quarto.getCamaExtra().equals(TemCamaExtra.NAO));
		assertFalse(quarto.getCamaExtra().equals(TemCamaExtra.SIM));
	}// fim do metodo
	
	@Test
	public void testaQuartoLuxoDuplo(){		
		// Configurando a data inicial como treze de maio de 2003
		dataInicial.set(2003, 5, 13);
		// Configurando a data final como treze de maio de 2003
		dataFinal.set(2003, 5, 13);
		
		// Em um quarto luxo duplo que foi alugado e entregue no mesmo dia
		// espera-se que seja cobrado o valor de uma diaria, 570 R$.
		QuartoLuxo quarto = new QuartoLuxo(dataInicial, dataFinal, TipoQuartoLuxo.DUPLO, TemCamaExtra.NAO, null);
		assertTrue(quarto.getCusto() == 570);
		
		// Em dois dias de alguel de um quarto luxo duplo eh esperado um custo de duas diarias, 1140 R$
		dataFinal.set(2003, 5, 14);
		quarto.setDataFinal(dataFinal);
		assertTrue(quarto.getCusto() == 1140);
		
		assertTrue(quarto.getCamaExtra().equals(TemCamaExtra.NAO));
		assertFalse(quarto.getCamaExtra().equals(TemCamaExtra.SIM));
	}// fim do metodo
	
	@Test
	public void testaQuartoLuxoTriplo(){		
		// Configurando a data inicial como treze de maio de 2003
		dataInicial.set(2003, 5, 13);
		// Configurando a data final como treze de maio de 2003
		dataFinal.set(2003, 5, 13);
		
		// Em um quarto luxo triplo que foi alugado e entregue no mesmo dia
		// espera-se que seja cobrado o valor de uma diaria, 620 R$.
		QuartoLuxo quarto = new QuartoLuxo(dataInicial, dataFinal, TipoQuartoLuxo.TRIPLO, TemCamaExtra.SIM, null);
		assertTrue(quarto.getCusto() == 620);
		
		// Em dois dias de alguel de um quarto luxo triplo eh esperado um custo de duas diarias, 1240 R$
		dataFinal.set(2003, 5, 14);
		quarto.setDataFinal(dataFinal);
		assertTrue(quarto.getCusto() == 1240);
		
		assertTrue(quarto.getCamaExtra().equals(TemCamaExtra.SIM));
		assertFalse(quarto.getCamaExtra().equals(TemCamaExtra.NAO));
	}// fim do metodo

	@Test
	public void testaEquals(){
		dataInicial.set(2004, 10, 13);
		dataFinal.set(2004, 10, 13);
		
		QuartoLuxo quarto1 = new QuartoLuxo(dataInicial, dataFinal, TipoQuartoLuxo.SIMPLES, TemCamaExtra.NAO, null);
		QuartoLuxo quarto2 = new QuartoLuxo(dataInicial, dataFinal, TipoQuartoLuxo.SIMPLES, TemCamaExtra.NAO, null);
		assertTrue(quarto1.equals(quarto1));
		assertTrue(quarto1.equals(quarto2));
		assertTrue(quarto2.equals(quarto1));
		
		QuartoLuxo quarto3 = new QuartoLuxo(dataInicial, dataFinal, TipoQuartoLuxo.TRIPLO, TemCamaExtra.NAO, null);
		assertFalse(quarto1.equals(quarto3));
		assertFalse(quarto3.equals(quarto1));
		
		Calendar outraData1 = Calendar.getInstance();
		Calendar outraData2 = Calendar.getInstance();
		outraData1.set(2015, 5, 1);
		outraData2.set(2015, 5, 13);
		
		QuartoLuxo quarto4 = new QuartoLuxo(outraData1, outraData2, TipoQuartoLuxo.SIMPLES, TemCamaExtra.NAO, null);
		
		assertFalse(quarto4.equals(quarto1));
		assertFalse(quarto1.equals(quarto4));
		assertFalse(quarto2.equals(quarto4));
		assertFalse(quarto3.equals(quarto4));
		assertTrue(quarto4.equals(quarto4));
		
		QuartoLuxo quarto5 = new QuartoLuxo(outraData1, outraData2, TipoQuartoLuxo.SIMPLES, TemCamaExtra.SIM, null);
		assertFalse(quarto5.equals(quarto4));
		assertFalse(quarto4.equals(quarto5));
		assertTrue(quarto5.equals(quarto5));
		
		QuartoLuxo quarto6 = new QuartoLuxo(outraData1, outraData2, TipoQuartoLuxo.SIMPLES, TemCamaExtra.SIM, null);
		assertTrue(quarto5.equals(quarto6));
		assertTrue(quarto6.equals(quarto5));
		assertFalse(quarto5.equals(new SuitePresidencial(outraData1, outraData2, null)));
	}

	@Test
	public void testaToString(){
		dataInicial.set(2004, 9, 13);
		dataFinal.set(2004, 9, 13);
		
		QuartoLuxo quarto = new QuartoLuxo(dataInicial, dataFinal, TipoQuartoLuxo.TRIPLO, TemCamaExtra.SIM, null);
		
		String mensagem = "Quarto Luxo:\n" +
				  "Tipo: TRIPLO\n" +
				  "Tem Cama Extra? SIM\n" +
				  "Data Inicial: 13/9/2004\n" +
				  "Data Final: 13/9/2004\n" +
				  "Preco: 620,00 R$";

		assertTrue(quarto.toString().equals(mensagem));
	}
	
}// fim da classe