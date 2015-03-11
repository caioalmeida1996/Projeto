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
        
        //cria hospede
        public Hospede criaHospede(String nome,String cpf,Calendar dataNascimento,Endereco endereco, Contrato contrato){
        	Hospede hospedeNovo = new Hospede(nome, cpf, dataNascimento, endereco, contrato);
        	if(contrato.equals(null)){
        		return hospedeNovo;
        	}
        	hospedes.add(hospedeNovo);
        	return hospedeNovo;
        }
        
        
        //remove Hospede
        public void removeHospede(Hospede hospede)throws Exception{
        	hospedes.remove(hospede);
        }
        
        
        //atualiza hospede
        public void atualizaHospede(Hospede hospede,String nome,String cpf,Calendar dataNascimento,Endereco endereco){
            		if(!nome.equals(null)){
            			hospede.setNome(nome);
            		}
            		if(!endereco.equals(null)){
            			hospede.setEndereco(endereco);
            		}
            		if(!dataNascimento.equals(null)){
            			hospede.setDataNascimento(dataNascimento);
            		}
            		if(!cpf.equals(null)){
            			   hospede.setCpf(cpf);
            		}
            		  					
				
				
			

        }
        
        
        // pesquisar hospede
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
