package hospede;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import endereco.Endereco;

public class TestaHospede {

	private Endereco endereco;
	private Hospede hospede1;
	
	@Test
	public void testaMetodosGet() {
		// Criando um objeto Endereco
		
		String pais = "Brasil";
		String estado = "Bahia";
		String cidade = "Salvador";
		String rua = "Rua qualquer";
		String numResidencia = "333";
		endereco = new Endereco(pais, estado, cidade, rua, numResidencia);
		
		// Criando uma data de nascimento 02/03/1994
		
		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, 2);
		data.set(Calendar.MONTH, 3);
		data.set(Calendar.YEAR, 1994);
		
		// Criando um objeto Hospede
		
		String nome = "Maria";
		String cpf = "1000";
		hospede1 = new Hospede(nome, cpf, data, endereco);
		
		// Assertivas
		
		assertTrue(hospede1.getNome().equals(nome));
		assertTrue(hospede1.getCpf().equals(cpf));
		assertTrue(hospede1.getDataNascimento().equals(data));
		assertTrue(hospede1.getEndereco().equals(endereco));
		
	}// fim do metodo

	@Test
	public void testametodosSet(){
		// Criando um objeto Endereco
		
		String pais = "Brasil";
		String estado = "Bahia";
		String cidade = "Salvador";
		String rua = "Rua qualquer";
		String numResidencia = "333";
		endereco = new Endereco(pais, estado, cidade, rua, numResidencia);
		
		// Criando uma data de nascimento 02/03/1994
		
		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, 2);
		data.set(Calendar.MONTH, 3);
		data.set(Calendar.YEAR, 1994);
		
		// Criando um objeto Hospede
		
		String nome = "Maria";
		String cpf = "1000";
		hospede1 = new Hospede(nome, cpf, data, endereco);

		// Assertivas
		
		hospede1.setNome("Rivaldo");
		assertTrue(hospede1.getNome().equals("Rivaldo"));
		
		hospede1.setCpf("2000");
		assertTrue(hospede1.getCpf().equals("2000"));
		
		Calendar data2 = Calendar.getInstance();
		data2.set(1980, 10, 25);
		hospede1.setDataNascimento(data2);
		assertTrue(hospede1.getDataNascimento().equals(data2));
		
		Endereco outroEndereco = new Endereco("xxx", "yyy", "zzz", "www", "666");
		hospede1.setEndereco(outroEndereco);
		assertTrue(hospede1.getEndereco().equals(outroEndereco));
		
	}// fim do metodo
	
	@Test
	public void testaEquals(){
		// Criando um objeto Endereco
		
		String pais = "Brasil";
		String estado = "Bahia";
		String cidade = "Salvador";
		String rua = "Rua qualquer";
		String numResidencia = "333";
		endereco = new Endereco(pais, estado, cidade, rua, numResidencia);
		
		// Criando uma data de nascimento 02/03/1994
		
		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, 2);
		data.set(Calendar.MONTH, 3);
		data.set(Calendar.YEAR, 1994);
		
		// Criando um objeto Hospede
		
		String nome = "Maria";
		String cpf = "1000";
		hospede1 = new Hospede(nome, cpf, data, endereco);

		// Comparando um objeto com ele mesmo
		
		assertTrue(hospede1.equals(hospede1));
		
		// Comparando dois objetos com atributos identicos
		
		Hospede hospede2 = new Hospede(nome, cpf, data, endereco);
		assertTrue(hospede1.equals(hospede2));
		
		// Comparando dois objetos com atributos distintos
		
		Calendar data2 = Calendar.getInstance();
		data2.set(1980, 10, 25);
		Hospede hospede3 = new Hospede(nome, cpf, data2, endereco);
		
		assertFalse(hospede1.equals(hospede3));
		assertFalse(hospede3.equals(hospede1));
		
		// Comparando dois hospedes instanciados com alguns atributos diferentes
		
		Hospede hospede4 = new Hospede("Benedita", "3333334", data, endereco);
		assertFalse(hospede1.equals(hospede4));
		assertFalse(hospede4.equals(hospede1));
		
	}// fim do metodo
	
	@Test
	public void testaToString(){
		// Criando um objeto Endereco
		
		String pais = "Brasil";
		String estado = "Bahia";
		String cidade = "Salvador";
		String rua = "Rua qualquer";
		String numResidencia = "333";
		endereco = new Endereco(pais, estado, cidade, rua, numResidencia);
		
		// Criando uma data de nascimento 02/03/1994
		
		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, 2);
		data.set(Calendar.MONTH, 3);
		data.set(Calendar.YEAR, 1994);
		
		// Criando um objeto Hospede
		
		String nome = "Maria";
		String cpf = "1000";
		hospede1 = new Hospede(nome, cpf, data, endereco);
		
		String mensagem = "--INFORMACOES DO HOSPEDE--\n" +
							"NOME: Maria\n" +
							"CPF: 1000\n" +
							"Data de Nascimento: 2/3/1994\n" +
							"PAIS: Brasil\n" +
							"ESTADO: Bahia\n" +
							"CIDADE: Salvador\n" +
							"RUA: Rua qualquer\n" +
							"NUM.RESIDENCIA: 333\n";

		assertTrue(hospede1.toString().equals(mensagem));
		
	}// fim do metodo

}// fim da classe