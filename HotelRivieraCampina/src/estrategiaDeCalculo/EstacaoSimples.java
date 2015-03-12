package estrategiaDeCalculo;

/**
 * Classe que implementa uma interface que representa uma estrategia de contrato
 * @author raimundohsm
 *
 */
public class EstacaoSimples implements Tarifacao{

	@Override
	public double getPreco(double valor) {
		return valor;
	}

}
