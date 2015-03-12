package estrategiaDeCalculo;

/**
* Classe que implementa uma interface que representa uma estrategia de contrato
* @author raimundohsm
*
*/
public class AltaEstacao implements Tarifacao{

	@Override
	public double getPreco(double valor) {
		return valor * 1.5;
	}

}
