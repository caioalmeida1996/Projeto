package gerenteHospede;

import java.util.Calendar;
import java.util.List;

import contrato.Contrato;
import endereco.Endereco;
import hospede.Hospede;
import hotel.Hotel;

public class GerenteHospede extends Hotel {



        public GerenteHospede(List<Contrato> contratos) {
                super(contratos);
        }

        public void atualizaHospede(String nomeVelho, Hospede hospedeNovo){
                for (int i = 0; i < super.getContratos().size(); i++) {
                        if (super.getContratos().get(i).getHospede().getNome().equals(nomeVelho)) {
                                super.getContratos().get(i).getHospede().setNome(hospedeNovo.getNome());
                                super.getContratos().get(i).getHospede().setCpf(hospedeNovo.getCpf());
                                super.getContratos().get(i).getHospede().setDataNascimento(hospedeNovo.getDataNascimento());
                                System.out.println("Hospede atualizado com sucesso");
                                
                        }

                }

        }

        public Hospede pesquisaHospede(String nome) {
        	for (int i = 0; i < super.getContratos().size(); i++) {
        		 if (super.getContratos().get(i).getHospede().getNome().equals(nome)){
        			 return super.getContratos().get(i).getHospede();
        		 }
        		
				
			}
        	 System.out.println("Hospede não encontrado");
			 return null;
        }
        
        
        /*
        public void setHospede(Hospede hospede) {
                this.hospede = hospede;
        }

        public void setHospede(Hospede hospede) {
                this.hospede = hospede;
        }*/



}
