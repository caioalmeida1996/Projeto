package estrategiaDeCalculo;

public class EstrategiaNataleReveillon implements EstrategiaDeCalculo {
	
	private double acressimo = 0.2;
	private double valor;
	
	public EstrategiaNataleReveillon( double valor) {
		this.valor = valor;
	}

	@Override
	public double calculaValor() {
		double valornovo = valor + valor*acressimo;
		return valornovo;
	}

	@Override
	public String getTipoEstrategia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAcressimo() {
		// TODO Auto-generated method stub
		return acressimo;
	}

}
