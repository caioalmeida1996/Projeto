package gerenteHospede;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import contrato.Contrato;
import endereco.Endereco;
import hospede.Hospede;
import hotel.Hotel;

public class GerenteHospede{

	 private List<Hospede> hospedes;


        public GerenteHospede() {
        	hospedes = new ArrayList<Hospede>();
        	
        }
        
        
        
        public List<Hospede> getHospedes(){
        	return hospedes;
        }
        
        public Hospede criaHospede(String nome,String cpf,Calendar dataNascimento,Endereco endereco, Contrato contrato){
        	Hospede hospedeNovo = new Hospede(nome, cpf, dataNascimento, endereco, contrato);
        	hospedes.add(hospedeNovo);
        	return hospedeNovo;
        }
        
        public void removeHospede(Hospede hospede){
        	hospedes.remove(hospede);
        }
        
        public void atualizaHospede(String nomeVelho, Hospede hospedeNovo){
               for (int i = 0; i < hospedes.size(); i++) {
            	   if (hospedes.get(i).getNome().equals(nomeVelho)) {
            		   hospedes.get(i).setNome(hospedeNovo.getNome());
            		   hospedes.get(i).setEndereco(hospedeNovo.getEndereco());
            		   hospedes.get(i).setDataNascimento(hospedeNovo.getDataNascimento());
            		   hospedes.get(i).setCpf(hospedeNovo.getCpf());
					
				}
				
			}

        }

        public Hospede pesquisaHospede(String nome) {
        	for (int i = 0; i < hospedes.size(); i++) {
         	   if (hospedes.get(i).getNome().equals(nome)) {
         		   return hospedes.get(i);
         	   }
         	   
         	   }
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
