package aluguelCarros;

public enum TipoCarro {
	
	EXECUTIVO(60), LUXO(100);
	
	private int valorDiaria;
	
	private TipoCarro(int valorDiaria){
		this.valorDiaria = valorDiaria;
	}
	
	public int getValorDiaria(){
		return this.valorDiaria;
	}
	
}
