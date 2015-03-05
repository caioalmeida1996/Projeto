package aluguelCarros;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class TestaAluguelCarro {

	private Calendar data1, data2;
	
	@Before
	public void iniciaDatas(){
		data1 = Calendar.getInstance();
		data2 = Calendar.getInstance();
	}
	
	@Test
	public void testaConstrutor() {
		data1.set(2010, 10, 28);
		data2.set(2011, 7, 19);
		
		AluguelCarro carro = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.SIM, TemSeguro.SIM, TipoCarro.EXECUTIVO);
		
		assertTrue(carro.getDataInicial().getTime().equals(data1.getTime()));
		assertTrue(carro.getDataFinal().getTime().equals(data2.getTime()));
		assertTrue(carro.getPlaca().equals("HVH-1404"));
		assertTrue(carro.getTanque().equals(TemTanqueCheio.SIM));
		assertTrue(carro.getSeguro().equals(TemSeguro.SIM));
		assertTrue(carro.getTipoDeCarro().equals(TipoCarro.EXECUTIVO));
		
	}// fim do metodo

	@Test
	public void testaPrecoExecutivoSemAditivos(){
		data1.set(2010, 10, 28);
		data2.set(2010, 10, 28);
		
		AluguelCarro carro1 = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.NAO, TemSeguro.NAO, TipoCarro.EXECUTIVO);
		assertTrue(carro1.getDiaria() == 60);
		assertTrue(carro1.getNumeroDiasAluguel() == 1);
		assertTrue(carro1.getCusto() == 60);
		
		Calendar data3 = Calendar.getInstance();
		Calendar data4 = Calendar.getInstance();
		
		data3.set(2013, 5, 18);
		data4.set(2013, 5, 19);

		AluguelCarro carro2 = new AluguelCarro(data3, data4, "HVH-1404", TemTanqueCheio.NAO, TemSeguro.NAO, TipoCarro.EXECUTIVO);
		assertTrue(carro2.getDiaria() == 60);
		assertTrue(carro2.getNumeroDiasAluguel() == 2);
		assertTrue(carro2.getCusto() == 120);
		
	}// fim do metodo
	
	@Test
	public void testaPrecoExecutivoComAditivos(){
		data1.set(2010, 10, 28);
		data2.set(2010, 10, 28);
		
		// Carro com tanque cheio e sem seguro tem 150 R$ incrementados na conta
		AluguelCarro carro1 = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.SIM, TemSeguro.NAO, TipoCarro.EXECUTIVO);
		assertTrue(carro1.getDiaria() == 60);
		assertTrue(carro1.getNumeroDiasAluguel() == 1);
		assertTrue(carro1.getCusto() == 210);
		
		// Carro sem tanque cheio e com seguro custa 100 R$ a mais
		AluguelCarro carro2 = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.NAO, TemSeguro.SIM, TipoCarro.EXECUTIVO);
		assertTrue(carro2.getDiaria() == 60);
		assertTrue(carro2.getNumeroDiasAluguel() == 1);
		assertTrue(carro2.getCusto() == 160);
		
		// Carro com tanque cheio e com seguro custa 250 R$ a mais
		AluguelCarro carro3 = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.SIM, TemSeguro.SIM, TipoCarro.EXECUTIVO);
		assertTrue(carro3.getDiaria() == 60);
		assertTrue(carro3.getNumeroDiasAluguel() == 1);
		assertTrue(carro3.getCusto() == 310);
		
		// Carro com tanque cheio e com seguro custa 250 R$ a mais
		AluguelCarro carro4 = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.SIM, TemSeguro.SIM, TipoCarro.EXECUTIVO);
		assertTrue(carro4.getDiaria() == 60);
		assertTrue(carro4.getNumeroDiasAluguel() == 1);
		assertTrue(carro4.getCusto() == 310);
	}// fim do metodo
	
	@Test
	public void testaPrecoLuxoSemAditivos(){
		data1.set(2010, 10, 28);
		data2.set(2010, 10, 28);
		
		AluguelCarro carro1 = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.NAO, TemSeguro.NAO, TipoCarro.LUXO);
		assertTrue(carro1.getDiaria() == 100);
		assertTrue(carro1.getNumeroDiasAluguel() == 1);
		assertTrue(carro1.getCusto() == 100);
		
		Calendar data3 = Calendar.getInstance();
		Calendar data4 = Calendar.getInstance();
		
		data3.set(2013, 5, 18);
		data4.set(2013, 5, 19);

		AluguelCarro carro2 = new AluguelCarro(data3, data4, "HVH-1404", TemTanqueCheio.NAO, TemSeguro.NAO, TipoCarro.LUXO);
		assertTrue(carro2.getDiaria() == 100);
		assertTrue(carro2.getNumeroDiasAluguel() == 2);
		assertTrue(carro2.getCusto() == 200);
		
	}// fim do metodo
	
	@Test
	public void testaPrecoLuxoComAditivos(){
		data1.set(2010, 10, 28);
		data2.set(2010, 10, 28);
		
		// Carro com tanque cheio e sem seguro tem 150 R$ incrementados na conta
		AluguelCarro carro1 = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.SIM, TemSeguro.NAO, TipoCarro.LUXO);
		assertTrue(carro1.getDiaria() == 100);
		assertTrue(carro1.getNumeroDiasAluguel() == 1);
		assertTrue(carro1.getCusto() == 250);
		
		// Carro sem tanque cheio e com seguro custa 100 R$ a mais
		AluguelCarro carro2 = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.NAO, TemSeguro.SIM, TipoCarro.LUXO);
		assertTrue(carro2.getDiaria() == 100);
		assertTrue(carro2.getNumeroDiasAluguel() == 1);
		assertTrue(carro2.getCusto() == 200);
		
		// Carro com tanque cheio e com seguro custa 250 R$ a mais
		AluguelCarro carro3 = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.SIM, TemSeguro.SIM, TipoCarro.LUXO);
		assertTrue(carro3.getDiaria() == 100);
		assertTrue(carro3.getNumeroDiasAluguel() == 1);
		assertTrue(carro3.getCusto() == 350);
		
		Calendar data3 = Calendar.getInstance();
		Calendar data4 = Calendar.getInstance();
		
		data3.set(2013, 5, 18);
		data4.set(2013, 5, 19);
		
		AluguelCarro carro4 = new AluguelCarro(data3, data4, "HVH-1404", TemTanqueCheio.NAO, TemSeguro.SIM, TipoCarro.LUXO);
		assertTrue(carro4.getDiaria() == 100);
		assertTrue(carro4.getNumeroDiasAluguel() == 2);
		assertTrue(carro4.getCusto() == 300);
	}// fim do metodo
	
	@Test
	public void testaEquals(){
	
		AluguelCarro carro1 = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.SIM, TemSeguro.NAO, TipoCarro.LUXO);
		AluguelCarro carro2 = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.SIM, TemSeguro.NAO, TipoCarro.LUXO);
		
		assertTrue(carro1.equals(carro1));
		assertTrue(carro1.equals(carro2));
		
		AluguelCarro carro3 = new AluguelCarro(data1, data2, "HVG-1404", TemTanqueCheio.SIM, TemSeguro.NAO, TipoCarro.LUXO);
		assertFalse(carro1.equals(carro3));
		assertFalse(carro2.equals(carro3));
		
		AluguelCarro carro4 = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.NAO, TemSeguro.NAO, TipoCarro.LUXO);
		assertFalse(carro1.equals(carro4));
		assertFalse(carro2.equals(carro4));
		
		AluguelCarro carro5 = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.SIM, TemSeguro.SIM, TipoCarro.LUXO);
		assertFalse(carro1.equals(carro5));
		assertFalse(carro2.equals(carro5));
		
		AluguelCarro carro6 = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.SIM, TemSeguro.NAO, TipoCarro.EXECUTIVO);
		assertFalse(carro1.equals(carro6));
		assertFalse(carro2.equals(carro6));
	}// fim do metodo
	
	@Test
	public void testaToString(){
		data1.set(2010, 6, 20);
		data2.set(2010, 6, 21);
		
		AluguelCarro carro = new AluguelCarro(data1, data2, "HVH-1404", TemTanqueCheio.SIM, TemSeguro.NAO, TipoCarro.LUXO);
		
		String mensagem = "Aluguel de Carro:\n" +
						  "Data Inicial: 20/6/2010\n" +
				          "Data Final: 21/6/2010\n" +
				          "Placa: HVH-1404\n" +
						  "Tipo de Carro: LUXO\n" +
						  "Foi alugado com tanque cheio? SIM\n" +
						  "Foi alugado com seguro? NAO\n" +
						  "Preco: 350,00 R$";
		
		assertTrue(mensagem.equals(carro.toString()));

	}// fim do metodo
	
}// fim da classe de testes
