package suitePresidencial;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class TestaSuitePresidencial {

	private Calendar dataInicial, dataFinal;
	
	@Before
	public void iniciaDatas(){
		dataInicial = Calendar.getInstance();
		dataFinal = Calendar.getInstance();
	}
	
	@Test
	public void testaDiarias() {
		dataInicial.set(2004, 10, 13);
		dataFinal.set(2004, 10, 13);
		
		// Em uma suite presidencial que foi alugada e entregue no mesmo dia
		// espera-se que seja cobrado o valor de uma diaria, 1200 R$.
		SuitePresidencial suite = new SuitePresidencial(dataInicial, dataFinal);
		assertTrue(suite.getCusto() == 1200);
		
		// Dois dias de diferenca, 2400 R$
		dataFinal.set(2004, 10, 14);
		suite.setDataFinal(dataFinal);
		assertTrue(suite.getCusto() == 2400);
		
		// Dois dias de diferenca, 2400 R$
		dataFinal.set(2004, 10, 15);
		suite.setDataFinal(dataFinal);
		assertTrue(suite.getCusto() == 3600);
		
	}
	
	@Test
	public void testaEquals(){
		dataInicial.set(2004, 10, 13);
		dataFinal.set(2004, 10, 13);
		
		SuitePresidencial suite1 = new SuitePresidencial(dataInicial, dataFinal);
		SuitePresidencial suite2 = new SuitePresidencial(dataInicial, dataFinal);
		
		assertTrue(suite1.equals(suite1));
		assertTrue(suite1.equals(suite2));
		assertTrue(suite2.equals(suite1));
		
		Calendar outraData1 = Calendar.getInstance();
		Calendar outraData2 = Calendar.getInstance();
		outraData1.set(2015, 5, 1);
		outraData2.set(2015, 5, 13);
		
		SuitePresidencial suite3 = new SuitePresidencial(outraData1, outraData2);
		assertTrue(suite3.equals(suite3));
		assertFalse(suite1.equals(suite3));
		assertFalse(suite3.equals(suite1));
		assertFalse(suite2.equals(suite3));
		assertFalse(suite3.equals(suite2));
		
	}// fim do metodo
	
	@Test
	public void testaToString(){
		dataInicial.set(2004, 9, 13);
		dataFinal.set(2004, 9, 13);
		SuitePresidencial suite1 = new SuitePresidencial(dataInicial, dataFinal);
		
		String mensagem = "Suite Presidencial:\n" +
				  "Data Inicial: 13/9/2004\n" +
				  "Data Final: 13/9/2004\n" +
				  "Preco: 1200,00 R$";
		
		assertTrue(suite1.toString().equals(mensagem));
	}// fim do metodo
	
}// fim da classe de teste
