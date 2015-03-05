package endereco;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestaEndereco {

	private String pais = "Brasil";
	private String estado = "Ceará";
	private String cidade = "Umari";
	private String rua = "Rua 03 de agosto";
	private String numeroDeResidencia = "317";
	
	@Test
	public void testaMetodosGet() {
		Endereco endereco = new Endereco(pais, estado, cidade, rua, numeroDeResidencia);
		
		assertTrue(endereco.getPais().equals(pais));
		assertTrue(endereco.getEstado().equals(estado));
		assertTrue(endereco.getCidade().equals(cidade));
		assertTrue(endereco.getRua().equals(rua));
		assertTrue(endereco.getNumResidencia().equals(numeroDeResidencia));
		
	}// fim do metodo

	@Test
	public void testaMetodosSet(){
		Endereco endereco = new Endereco(pais, estado, cidade, rua, numeroDeResidencia);
		
		endereco.setPais("Argentina");
		assertTrue(endereco.getPais().equals("Argentina"));
		
		endereco.setEstado("Paraiba");
		assertTrue(endereco.getEstado().equals("Paraiba"));
		
		endereco.setCidade("Cajazeiras");
		assertTrue(endereco.getCidade().equals("Cajazeiras"));
		
		endereco.setRua("Rua das flores");
		assertTrue(endereco.getRua().equals("Rua das flores"));
		
		endereco.setNumResidencia("666");
		assertTrue(endereco.getNumResidencia().equals("666"));
		
	}// fim do metodo
	
	@Test
	public void testaEquals(){
		Endereco endereco1 = new Endereco(pais, estado, cidade, rua, numeroDeResidencia);
		assertTrue(endereco1.equals(endereco1));
		assertFalse(endereco1.equals(new Date()));
		
		Endereco endereco2 = new Endereco(pais, estado, cidade, rua, numeroDeResidencia);
		assertTrue(endereco2.equals(endereco2));
		
		assertTrue(endereco1.equals(endereco2));
		
		endereco2.setPais("Venezuela");
		assertFalse(endereco1.equals(endereco2));
	}// fim do metodo
	
	@Test
	public void testaToString(){
	
		Endereco endereco = new Endereco(pais, estado, cidade, rua, numeroDeResidencia);
		
		String mensagem = "PAIS: Brasil\n" +
							"ESTADO: Ceará\n" +
							"CIDADE: Umari\n" +
							"RUA: Rua 03 de agosto\n" +
							"NUM.RESIDENCIA: 317";
		
		assertTrue(endereco.toString().equals(mensagem));
		
		endereco.setNumResidencia("220");
		assertFalse(endereco.toString().equals(mensagem));
		
		String mensagem2 = "PAIS: Brasil\n" +
				"ESTADO: Ceará\n" +
				"CIDADE: Umari\n" +
				"RUA: Rua 03 de agosto\n" +
				"NUM.RESIDENCIA: 220";
		
		assertTrue(endereco.toString().equals(mensagem2));
		
	}// fim do metodo
	
}// fim da classe
