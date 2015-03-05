package servico;

import java.util.Calendar;

public abstract class ServicoSuplementar extends Servico{

	public ServicoSuplementar(Calendar dataInicial, Calendar dataFinal) {
		super(dataInicial, dataFinal);
	}

}
