package babysitter;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class TestaBabysitter {

	private Calendar data1, data2;
	
	@Before
	public void iniciaDatas(){
		// Criando um objeto Calendar e posteriormente configurando sua data e hora
		data1 = Calendar.getInstance();
		data1.set(Calendar.YEAR, 2014);
		data1.set(Calendar.MONTH, 5);
		data1.set(Calendar.DAY_OF_MONTH, 13);
		data1.set(Calendar.HOUR_OF_DAY, 7);
		
		// Criando um outro objeto Calendar e posteriormente configurando sua data e hora
		data2 = Calendar.getInstance();
		data2.set(Calendar.YEAR, 2014);
		data2.set(Calendar.MONTH, 5);
		data2.set(Calendar.DAY_OF_MONTH, 13);
		data2.set(Calendar.HOUR_OF_DAY, 18);
	}
	
	@Test
	public void testaBabysitterNormal() {
		assertTrue(data1.get(Calendar.YEAR) == 2014);
		assertTrue(data1.get(Calendar.MONTH) == 5);
		assertTrue(data1.get(Calendar.DAY_OF_MONTH) == 13);
		assertTrue(data1.get(Calendar.HOUR_OF_DAY) == 7);
		
		assertTrue(data2.get(Calendar.YEAR) == 2014);
		assertTrue(data2.get(Calendar.MONTH) == 5);
		assertTrue(data2.get(Calendar.DAY_OF_MONTH) == 13);
		assertTrue(data2.get(Calendar.HOUR_OF_DAY) == 18);
		
		Babysitter b1 = new Babysitter(data1, data2);
		
		// Testando o custo do servico de babysitter normal durante todo o horario disponivel (7h às 18h).
		assertTrue(275 == b1.getCusto());
		
		// Testando o custo do servico de babysitter durante uma hora.
		data2.set(Calendar.HOUR_OF_DAY, 8);
		b1.setDataFinal(data2);
		assertTrue(25 == b1.getCusto());
		
	}// fim de testaBabysitterNormal()

	@Test
	public void testaBabysitterDobrado() {
		data1.set(Calendar.DAY_OF_MONTH, 13);
		data1.set(Calendar.HOUR_OF_DAY, 18);
		
		data2.set(Calendar.DAY_OF_MONTH, 14);
		data2.set(Calendar.HOUR_OF_DAY, 7);
		
		Babysitter b1 = new Babysitter(data1, data2);

		// Testando o custo do servico de babysitter dobrado durante todo o horario disponivel (18h às 7h).
		assertTrue(650 == b1.getCusto());
		
		// Testando o custo do servico de babysitter durante uma hora.
		data2.set(Calendar.DAY_OF_MONTH, 13);
		data2.set(Calendar.HOUR_OF_DAY, 19);
		b1.setDataFinal(data2);
		assertTrue(50 == b1.getCusto());
		
	}// fim de testaBabysitterNormal()
	
	@Test
	public void testaBabysitterSimplesDobrado() {
		
		data1.set(Calendar.DAY_OF_MONTH, 13);
		data1.set(Calendar.HOUR_OF_DAY, 12);
		
		data2.set(Calendar.DAY_OF_MONTH, 14);
		data2.set(Calendar.HOUR_OF_DAY, 12);
		
		Babysitter b1 = new Babysitter(data1, data2);
		
		// Testando o custo do servico de babysitter durante 24 horas, 11 horas simples mais 13 dobradas.
		assertTrue(925 == b1.getCusto());
		
	}// fim de testaBabysitterNormal()

	@Test
	public void testaEquals(){
		Babysitter baby1 = new Babysitter(data1, data2);
		Babysitter baby2 = new Babysitter(data1, data2);
		
		assertTrue(baby1.equals(baby1));
		assertTrue(baby2.equals(baby2));
		assertTrue(baby1.equals(baby2));
		assertTrue(baby2.equals(baby1));
		
		Calendar data3 = Calendar.getInstance();
		Calendar data4 = Calendar.getInstance();
		
		data3.set(Calendar.DAY_OF_MONTH, 13);
		data3.set(Calendar.HOUR_OF_DAY, 12);
		
		data4.set(Calendar.DAY_OF_MONTH, 14);
		data4.set(Calendar.HOUR_OF_DAY, 12);
		
		Babysitter baby3 = new Babysitter(data3, data4);
		
		assertTrue(baby3.equals(baby3));
		assertFalse(baby2.equals(baby3));
		assertFalse(baby3.equals(baby2));
		
	}// fim do metodo
	
	@Test
	public void testaToString(){
		data1.set(Calendar.DAY_OF_MONTH, 13);
		data1.set(Calendar.HOUR_OF_DAY, 12);
		
		data2.set(Calendar.DAY_OF_MONTH, 14);
		data2.set(Calendar.HOUR_OF_DAY, 12);
		
		Babysitter baby = new Babysitter(data1, data2);
		
		String mensagem = "Servico de Babysitter:\n" +
						  "Data/hora Iniciais: 13/5/2014, as 12 hs\n" +
						  "Data/hora Finais: 14/5/2014, as 12 hs\n" +
						  "Qtde. Horas Tarifa Normal: 11\n" +
						  "Qtde. Horas Tarifa Dobrada: 13\n" +
						  "Qtde. Horas Totais: 24\n" +
						  "Preco: 925,00 R$\n";

		assertTrue(baby.toString().equals(mensagem));
	}// fim do metodo
	
}// fim da classe
