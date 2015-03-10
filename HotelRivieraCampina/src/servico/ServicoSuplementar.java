package servico;

import java.util.Calendar;

import contrato.Contrato;

public abstract class ServicoSuplementar extends Servico{

	public ServicoSuplementar(Calendar dataInicial, Calendar dataFinal, Contrato contrato) {
		super(dataInicial, dataFinal, contrato);
	}

}
