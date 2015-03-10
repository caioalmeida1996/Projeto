package restaurante;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class TestaRefeicao {

	@Test
	public void testaCustos() {
		Refeicao refeicao = new Refeicao(Calendar.getInstance(), Calendar.getInstance(), 30, null);
		assertTrue(30 == refeicao.getCusto());
		
		Refeicao refeicao2 = new Refeicao(Calendar.getInstance(), Calendar.getInstance(), 40, null);
		assertTrue(40 == refeicao2.getCusto());
		
		Refeicao refeicao3 = new Refeicao(Calendar.getInstance(), Calendar.getInstance(), 50, null);
		assertTrue(50 == refeicao3.getCusto());
	}// fim do metodo

	@Test
	public void testaDatas(){
		Calendar dataInicial = Calendar.getInstance();
		Calendar dataFinal = Calendar.getInstance();
		Refeicao refeicao = new Refeicao(dataInicial, dataFinal, 30, null);
		
		assertTrue(refeicao.getDataInicial().getTime().equals(dataInicial.getTime()));
		assertTrue(refeicao.getDataFinal().getTime().equals(dataFinal.getTime()));
	}// fim do metodo

	@Test
	public void testaEquals(){
		Calendar dataInicial = Calendar.getInstance();
		Calendar dataFinal = Calendar.getInstance();
		dataFinal.set(2010, 3, 3);
		
		Refeicao refeicao1 = new Refeicao(dataInicial, dataFinal, 30, null);
		Refeicao refeicao2 = new Refeicao(dataInicial, dataFinal, 30, null);
		
		assertTrue(refeicao1.equals(refeicao1));
		assertTrue(refeicao1.equals(refeicao2));
		assertTrue(refeicao2.equals(refeicao1));
		
		refeicao1.setValor(100);
		assertFalse(refeicao1.equals(refeicao2));
		assertFalse(refeicao2.equals(refeicao1));
		
	}// fim do metodo
	
	@Test
	public void testaToString(){
		Calendar dataInicial = Calendar.getInstance();
		Calendar dataFinal = Calendar.getInstance();
		dataInicial.set(2015, 2, 2);
		dataFinal.set(2015, 2, 2);
		
		Refeicao refeicao1 = new Refeicao(dataInicial, dataFinal, 30, null);
		
		String mensagem = "Servico de Restaurante:\n" +
						  "Data Inicial: 2/2/2015\n" +
						  "Data Final: 2/2/2015\n" +
						  "Preco: 30,00 R$";

		assertTrue(refeicao1.toString().equals(mensagem));
	
	}// fim do metodo
	
}// fim da classe de testes.