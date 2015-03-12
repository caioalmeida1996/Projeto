package gerenteHospede;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import endereco.Endereco;
import hospede.Hospede;

/**
 * 
 * @author heitor
 *
 */
public class GerenteHospede{

	 private List<Hospede> hospedes;


        public GerenteHospede() {
        	hospedes = new ArrayList<Hospede>();
        	
        }
        
        
        /**
         *  
         * @return uma lista de hospedes
         */
        public List<Hospede> getHospedes(){
        	return hospedes;
        }
        
        //cria hospede
        /**
         * 
       	 * @param nome
       	 * 			nome do hospede
       	 * @param cpf
       	 * 			CPF do hospede
       	 * @param dataNascimento
       	 * 			data de nascimento do hospede
       	 * @param endereco
       	 * 			endereco do hospede
       	 * @param numcartao
       	 * 			numero do cartão do hospede
         * @return
         * 			um objeto hospede criado
         */
        public Hospede criaHospede(String nome,String cpf,Calendar dataNascimento,Endereco endereco, String numCartao){
        	Hospede hospedeNovo = new Hospede(nome, cpf, dataNascimento, endereco, numCartao);
        	hospedes.add(hospedeNovo);
        	return hospedeNovo;
        }
        
        
        //remove Hospede
        /**
         * remove um hospede da lista
         * @param hospede
         * 				hospede a ser removido
         */
        public void removeHospede(Hospede hospede)throws Exception{
        	hospedes.remove(hospede);
        }
        
        
        //atualiza hospede
        /**
         * metodo que faz a atualizacao do hospede
         * ele recebe um hospede e todos os paramentros que seram atualizados
         * caso um parametro nao queira ser atualizado basta coloca-lo como null
         * 
         * @param hospede
         * 			hospde a ser atualizado
         * @param nome
         * 			novo nome do hospede
         * @param cpf
         * 			novo cpf do hospede
         * @param dataNascimento
         * 			nova data do hospede
         * @param endereco
         * 			novo endereco 
         * @param numCartao
         * 			novo numero do cartao de creditos
         */
        public void atualizaHospede(Hospede hospede,String nome,String cpf,Calendar dataNascimento,Endereco endereco, String numCartao){
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
            		if(! numCartao.equals(null)){
            				hospede.setNumCartao(numCartao);
            		}
            		  					
				
				
			

        }
        
        
        // pesquisar hospede
        /**
         * pesquisa um hospede na lista aparti do nome
         * @param nome nomo do hospede a ser pesquisado 
         * @return caso encontre o hospede retorna ele
         * 			caso nao, retorna null
         */
        public Hospede pesquisaHospede(String nome) {
        	for (int i = 0; i < hospedes.size(); i++) {
         	   if (hospedes.get(i).getNome().equals(nome)) {
         		   return hospedes.get(i);
         	   }
         	   
         	   }
			return null;
        }

}
