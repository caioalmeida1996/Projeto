package contrato;

public class checkout {
	
	private String Fatura;
	private double custo;
	
	public checkout(String Fatura,double custo){
	this.Fatura = Fatura;
	this.custo = custo;
	}

	public String getFatura() {
		return Fatura;
	}

	public void setFatura(String fatura) {
		Fatura = fatura;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	
}
