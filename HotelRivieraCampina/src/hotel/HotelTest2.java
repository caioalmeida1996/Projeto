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
import estrategiaDeCalculo.EstacaoSimples;
import estrategiaDeCalculo.NatalReveillon;
import estrategiaDeCalculo.SaoJoao;
import estrategiaDeCalculo.Tarifacao;

public class HotelTest2 {
        private Hotel hotelTeste;

        private Contrato contrato1;
        private Hospede hospede1;
        private Endereco endereco1;
        private Quarto quarto1;       
        private Tarifacao tarifa1;        
        private Calendar datainicial = Calendar.getInstance();
        private Calendar datafinal = Calendar.getInstance();
      
        
        @Before
        public void testHotel() throws Exception {     
        	
            hotelTeste = new Hotel();  //cria um hotel
            
            tarifa1 = new NatalReveillon(); 
                            
          //cria 5 endereço	
        	endereco1 = new Endereco("br", "pb", "cg", "10", "01");
                   
            //cria 5 hospedes
            hospede1 = hotelTeste.getGerenteHospede().criaHospede("heitor", "2222222", Calendar.getInstance(), endereco1, "0000");
      
            //cria 5 contratos
            contrato1 = hotelTeste.getGerenteContrato().Checkin(datainicial, datafinal,hospede1, tarifa1);
     
        	//cria quartos
            //OBS: hotelTeste.getGerenteServico().cria.. -- cria objetos avulsos que seram usados para pesquisar 
            //OBS: hotelTeste.getGerenteServico(CONTRATO).cria... -- cria um objeto e ja o coloca dentro do CONTRATO de forma automantica
        	quarto1 = hotelTeste.getGerenteServico().criaServicoQuartoExecutivo(datainicial, datafinal, TipoQuartoExecutivo.DUPLO, TemCamaExtra.SIM);
     
        	//adicionando servicos
        	
        	hotelTeste.getGerenteServico(contrato1).adiconarServico(quarto1);  
        
            hotelTeste.getGerenteServico(contrato1).criaServicoQuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.SIMPLES,TemCamaExtra.SIM );
            
            hotelTeste.getGerenteServico(contrato1).criaServicoSuplementarAluguelCarros(Calendar.getInstance(), Calendar.getInstance(), "asd123", TemTanqueCheio.SIM, TemSeguro.SIM, TipoCarro.EXECUTIVO);
          
            hotelTeste.getGerenteServico(contrato1).criaServicoSuplementarRestaurante(Calendar.getInstance(), Calendar.getInstance(), 100);
            
           
        
              
        } 
        
        @Test
        public void testCheckout() throws Exception{
        
        	assertTrue( hotelTeste.Checkout(contrato1).getCusto() == 1386.0);
        	System.out.println(hotelTeste.Checkout(contrato1).getFatura());
        	
        	hotelTeste.getGerenteServico(contrato1).adiconarServico(quarto1);  
            
            hotelTeste.getGerenteServico(contrato1).criaServicoQuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.SIMPLES,TemCamaExtra.SIM );
            
            hotelTeste.getGerenteServico(contrato1).criaServicoSuplementarAluguelCarros(Calendar.getInstance(), Calendar.getInstance(), "asd123", TemTanqueCheio.SIM, TemSeguro.SIM, TipoCarro.EXECUTIVO);
          
            hotelTeste.getGerenteServico(contrato1).criaServicoSuplementarRestaurante(Calendar.getInstance(), Calendar.getInstance(), 100);
            
        	assertTrue( hotelTeste.Checkout(contrato1).getCusto() == 2772.0);
        	System.out.println(hotelTeste.Checkout(contrato1).getFatura());
             
             }
      
         
         
         
        
        
        
        
       
}
