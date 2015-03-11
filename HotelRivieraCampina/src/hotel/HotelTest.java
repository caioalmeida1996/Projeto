package hotel;

import static org.junit.Assert.*;
import hospede.Hospede;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import quarto.Quarto;
import quartoExecutivo.QuartoExecutivo;
import quartoExecutivo.TemCamaExtra;
import quartoExecutivo.TipoQuartoExecutivo;
import contrato.Contrato;
import endereco.Endereco;

public class HotelTest {
        private Hotel hotelTeste;

        private Contrato contrato1;
        private Contrato contrato2;
        private Contrato contrato3;

        private Hospede hospede1;
        private Hospede hospede2;
        private Hospede hospede3;

        private Endereco endereco1;
        private Endereco endereco2;
        private Endereco endereco3;

        private Quarto quarto1;
        private Quarto quarto2;
        private Quarto quarto3;
        
        
        @Before
        public void testHotel() {
      

            hotelTeste = new Hotel();
            
            contrato1 = hotelTeste.getGerenteContrato().criarContrato("1111111");
            contrato2 = hotelTeste.getGerenteContrato().criarContrato("2222222");
            contrato3 = hotelTeste.getGerenteContrato().criarContrato("3333333");
        	
        	
        	quarto1 = hotelTeste.getGerenteServico().criaServicoQuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.DUPLO, TemCamaExtra.SIM);
        	quarto2 = hotelTeste.getGerenteServico().criaServicoQuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.SIMPLES, TemCamaExtra.NAO);
        	quarto3 = hotelTeste.getGerenteServico().criaServicoQuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.DUPLO, TemCamaExtra.SIM);
        	
        	/*ontrato1 = hotelTeste.getGerenteContrato().criarContrato("111111");
        	contrato2 = hotelTeste.getGerenteContrato().criarContrato("111111");
        	contrato3 = hotelTeste.getGerenteContrato().criarContrato("111111");*/
        	
        	hotelTeste.getGerenteServico(contrato1).adiconarServico(quarto1);
			hotelTeste.getGerenteServico(contrato2).adiconarServico(quarto2);
			hotelTeste.getGerenteServico(contrato3).adiconarServico(quarto3);
        	
        		
        	endereco1 = new Endereco("br", "pb", "cg", "02", "02");
            endereco2 = new Endereco("br", "pb", "cg", "02", "02");
            endereco3 = new Endereco("br", "pb", "cg", "02", "02");
               
            hospede1 = hotelTeste.getGerenteHospede().criaHospede("heitor", "2222222", Calendar.getInstance(), endereco1, contrato1);
            hospede2 = hotelTeste.getGerenteHospede().criaHospede("aqulies", "2222222", Calendar.getInstance(), endereco2, contrato2);
            hospede3 = hotelTeste.getGerenteHospede().criaHospede("gullo", "2222222", Calendar.getInstance(), endereco3, contrato3);
        		
              
        }
        
        
        
        
       //@Test
        public void testGerenteHospede(){
        	System.out.println(hotelTeste.getGerenteHospede().getHospedes());
        	System.out.println(hotelTeste.getGerenteHospede().pesquisaHospede("heitor"));
        	System.out.println("--------------------------------------");
        	hotelTeste.getGerenteHospede().atualizaHospede("gullo", hospede2);
        	System.out.println(hotelTeste.getGerenteHospede().getHospedes());
        	System.out.println("--------------------------------------");
        	hotelTeste.getGerenteHospede().removeHospede(hospede3);
        	System.out.println(hotelTeste.getGerenteHospede().getHospedes());
            System.out.println("-------------------------------------");
            //testGetContratos();
             
            // hotelTeste.getGerenteHospede().criaHospede(nome, cpf, dataNascimento, endereco, contrato);
             
             
             }
        
      // @Test
        public void testGerenteServicos() {
    	   System.out.println("------------teste de servicos-----------");
        	System.out.println( hotelTeste.getGerenteServico(contrato1).getServicos());
        	System.out.println( hotelTeste.getGerenteServico(contrato2).getServicos());
        	System.out.println( hotelTeste.getGerenteServico(contrato3).getServicos());
        	System.out.println("-------------------");
        	System.out.println( hotelTeste.getGerenteServico(contrato1).pesquisaServico(Calendar.getInstance()));
        	System.out.println("-------------------");
        	/*System.out.println( hotelTeste.getGerenteServico(contrato1).AtualizarServico(Calendar.getInstance(), quarto3));
        	System.out.println( hotelTeste.getGerenteServico(contrato1).getServicos());*/
        	System.out.println("______________");
        	hotelTeste.getGerenteServico(contrato2).adiconarServico(quarto1);
        	System.out.println( hotelTeste.getGerenteServico(contrato2).getServicos());
        	hotelTeste.getGerenteServico(contrato2).removeServico(quarto2);
        	System.out.println( hotelTeste.getGerenteServico(contrato2).getServicos());
        	
        }
        

        @Test
        public void testGerenteContratos() {
               System.out.println(hotelTeste.getGerenteContrato().getContratos());
               System.out.println(hotelTeste.getGerenteContrato().pesquisaContrato("2222222"));
               hotelTeste.getGerenteContrato().removeContrato(contrato2);
               System.out.println(hotelTeste.getGerenteContrato().getContratos());
               
        }
        
        @Test
        public void usoGeraldoHotel(){
        	//uso do gerente contrato:
        	hotelTeste.getGerenteContrato().criarContrato(numCartao);
        	hotelTeste.getGerenteContrato().getContratos();
        	hotelTeste.getGerenteContrato().pesquisaContrato(numCartao);
        	hotelTeste.getGerenteContrato().removeContrato(contrato);
        	hotelTeste.getGerenteContrato().atualizarContrato(numCartao, contratoNovo);
        	
        	// uso do gerente hospede:
        	
        	hotelTeste.getGerenteHospede().criaHospede(nome, cpf, dataNascimento, endereco, contrato);
        	hotelTeste.getGerenteHospede().getHospedes();
        	hotelTeste.getGerenteHospede().pesquisaHospede(nome);
        	hotelTeste.getGerenteHospede().removeHospede(hospede);
        	hotelTeste.getGerenteHospede().atualizaHospede(nomeVelho, hospedeNovo);
        	
        	// uso do gerente servico:
        	
        	hotelTeste.getGerenteServico().adiconarServico(servico);
        	hotelTeste.getGerenteServico().AtualizarServico(datainicial, novoservico);
        	hotelTeste.getGerenteServico().criaServicoQuartoExecutivo(dataInicial, dataFinal, tipoQuarto, camaExtra);
        	hotelTeste.getGerenteServico().criaServicoQuartoLuxo(dataInicial, dataFinal, tipoQuarto, camaExtra);
        	hotelTeste.getGerenteServico().criaServicoQuartoPresidencial(dataInicial, dataFinal);
        	hotelTeste.getGerenteServico().CriaServicoSuplementarAluguelCarros(dataInicial, dataFinal, placa, tanque, seguro, tipo);
        	hotelTeste.getGerenteServico().CriaServicoSuplementarBabysitter(dataInicial, dataFinal);
        	hotelTeste.getGerenteServico().CriaServicoSuplementarRestaurante(dataInicial, dataFinal, valor);
        	hotelTeste.getGerenteServico().pesquisaServico(datainicial);
        	hotelTeste.getGerenteServico().removeServico(servico);
        	
        	//OBS: se deseja criar um objeto avulso use o .getGerenteServico() sem paramtamentro
        	// caso queira criar ou manipular um servico será necessário um contrato como parametro
        	// ex: .getGerenteServico(CONTRATO A SER MANIPULADO) : .getGerenteServico(contrato1).adiconaservico....
        	// ira adiciinar um servico ao contrato1.
        	
        }

}
