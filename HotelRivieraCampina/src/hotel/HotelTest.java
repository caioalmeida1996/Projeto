package hotel;

import static org.junit.Assert.*;
import hospede.Hospede;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import aluguelCarros.AluguelCarro;
import aluguelCarros.TemSeguro;
import aluguelCarros.TemTanqueCheio;
import aluguelCarros.TipoCarro;
import quarto.Quarto;
import quartoExecutivo.QuartoExecutivo;
import quartoExecutivo.TemCamaExtra;
import quartoExecutivo.TipoQuartoExecutivo;
import quartoLuxo.TipoQuartoLuxo;
import servico.Servico;
import contrato.Contrato;
import endereco.Endereco;
import estrategiaDeCalculo.AltaEstacao;
import estrategiaDeCalculo.BaixaEstacao;
import estrategiaDeCalculo.Tarifacao;

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
        
        private Tarifacao tarifa;
        
        @Test
        public void testHotel() throws Exception {
      
        	
            hotelTeste = new Hotel();  //cria um hotel
            
            tarifa = new AltaEstacao(); {
				
            
            
          //cria endereço	
        	endereco1 = new Endereco("br", "pb", "cg", "02", "02");
            endereco2 = new Endereco("br", "pb", "cg", "02", "02");
            endereco3 = new Endereco("br", "pb", "cg", "02", "02");
            
            //cria 3 hospedes
            hospede1 = hotelTeste.getGerenteHospede().criaHospede("heitor", "2222222", Calendar.getInstance(), endereco1);
            hospede2 = hotelTeste.getGerenteHospede().criaHospede("aqulies", "2222222", Calendar.getInstance(), endereco2);
            hospede3 = hotelTeste.getGerenteHospede().criaHospede("gullo", "2222222", Calendar.getInstance(), endereco3);
        		
            //cria 3 contratos
            contrato1 = hotelTeste.getGerenteContrato().Checkin(Calendar.getInstance(), Calendar.getInstance(),hospede1, tarifa);
            contrato2 = hotelTeste.getGerenteContrato().Checkin(Calendar.getInstance(), Calendar.getInstance(),hospede2, tarifa);
            contrato3 = hotelTeste.getGerenteContrato().Checkin(Calendar.getInstance(), Calendar.getInstance(),hospede3, tarifa);
        	
        	//cria quartos
            //OBS: hotelTeste.getGerenteServico().cria.. -- cria objetos avulsos que seram usados para pesquisar 
            //OBS: hotelTeste.getGerenteServico(CONTRATO).cria... -- cria um objeto e ja o coloca dentro do CONTRATO de forma automantica
        	quarto1 = hotelTeste.getGerenteServico().criaServicoQuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.DUPLO, TemCamaExtra.SIM);
        	quarto2 = hotelTeste.getGerenteServico().criaServicoQuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.SIMPLES, TemCamaExtra.NAO);
        	quarto3 = hotelTeste.getGerenteServico().criaServicoQuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.DUPLO, TemCamaExtra.SIM);
     
        	//adicionando servicos
        	hotelTeste.getGerenteServico(contrato1).adiconarServico(quarto1);
			hotelTeste.getGerenteServico(contrato2).adiconarServico(quarto2);
			hotelTeste.getGerenteServico(contrato3).adiconarServico(quarto3);
			
        	
        	
            
            
            hotelTeste.getGerenteServico(contrato1).criaServicoQuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.SIMPLES,TemCamaExtra.SIM );
            hotelTeste.getGerenteServico(contrato1).criaServicoSuplementarAluguelCarros(Calendar.getInstance(), Calendar.getInstance(), "asd123", TemTanqueCheio.SIM, TemSeguro.SIM, TipoCarro.EXECUTIVO);
            hotelTeste.getGerenteServico(contrato1).criaServicoSuplementarRestaurante(Calendar.getInstance(), Calendar.getInstance(), 100);
            
            System.out.println(hotelTeste.getGerenteHospede().getHospedes());
            System.out.println(hotelTeste.getGerenteServico(contrato1).getServicos());
            System.out.println(hotelTeste.getGerenteContrato().getContratos());
            
            System.out.println(hotelTeste.getGerenteContrato().checkout(contrato1).getFatura());
            System.out.println("preco total: " + hotelTeste.getGerenteContrato().checkout(contrato1).getCusto());
            }
            
        
              
        }
        
      //@Test
        public void testGerenteHospede() throws Exception{
        	System.out.println(hotelTeste.getGerenteHospede().getHospedes());
        	System.out.println(hotelTeste.getGerenteHospede().pesquisaHospede("heitor"));
        	System.out.println("--------------------------------------");
        	hotelTeste.getGerenteHospede().atualizaHospede(hospede2, "dsrgasrg", null, null,null );
        	System.out.println(hotelTeste.getGerenteHospede().getHospedes());
        	System.out.println("--------------------------------------");
        	hotelTeste.getGerenteHospede().removeHospede(hospede3);
        	System.out.println(hotelTeste.getGerenteHospede().pesquisaHospede("heitor"));
            System.out.println("-------------------------------------");
            //testGetContratos();
             
            // hotelTeste.getGerenteHospede().criaHospede(nome, cpf, dataNascimento, endereco, contrato);
             
             
             }
        
        
        
        
        
       
}
