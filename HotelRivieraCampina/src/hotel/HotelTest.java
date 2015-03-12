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
        
        
        //@Test
        public void testHotel() throws Exception {
      

            hotelTeste = new Hotel();
            
            hospede1 = hotelTeste.getGerenteHospede().criaHospede("heitor", "2222222", Calendar.getInstance(), endereco1);
            hospede2 = hotelTeste.getGerenteHospede().criaHospede("aqulies", "2222222", Calendar.getInstance(), endereco2);
            hospede3 = hotelTeste.getGerenteHospede().criaHospede("gullo", "2222222", Calendar.getInstance(), endereco3);
        		
            
            contrato1 = hotelTeste.getGerenteContrato().criarContrato(hospede1, "1111111");
            contrato2 = hotelTeste.getGerenteContrato().criarContrato(hospede2, "2222222");
            contrato3 = hotelTeste.getGerenteContrato().criarContrato(hospede3, "3333333");
        	
        	
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
        
       @Test
        public void testGerenteServicos() throws Exception {
        	hotelTeste = new Hotel();
        	
        	 hospede1 = hotelTeste.getGerenteHospede().criaHospede("heitor", "2222222", Calendar.getInstance(), endereco1);
           
        	Contrato contrato = hotelTeste.getGerenteContrato().criarContrato(hospede1,"000");
        	
        	//System.out.println(hotelTeste.getGerenteServico().getServicos());
        	System.out.println("---");
        	//System.out.println(hotelTeste.getGerenteServico(contrato).getServicos());
        	System.out.println(hotelTeste.getGerenteServico().getnExecutivoSimples());
        	hotelTeste.getGerenteServico(contrato).criaServicoQuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.SIMPLES,TemCamaExtra.SIM );
        	System.out.println(hotelTeste.getGerenteServico().getnExecutivoSimples());
        	hotelTeste.getGerenteServico(contrato).criaServicoQuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.SIMPLES,TemCamaExtra.SIM );
        	System.out.println(hotelTeste.getGerenteServico().getnExecutivoSimples());
        	hotelTeste.getGerenteServico(contrato).criaServicoQuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.SIMPLES,TemCamaExtra.SIM );
        	System.out.println(hotelTeste.getGerenteServico().getnExecutivoSimples());
        	hotelTeste.getGerenteServico(contrato).criaServicoQuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.SIMPLES,TemCamaExtra.SIM );
        	System.out.println(hotelTeste.getGerenteServico().getnExecutivoSimples());
        	hotelTeste.getGerenteServico(contrato).criaServicoQuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.SIMPLES,TemCamaExtra.SIM );
        	System.out.println(hotelTeste.getGerenteServico().getnExecutivoSimples());
        	hotelTeste.getGerenteServico(contrato).criaServicoSuplementarRestaurante(Calendar.getInstance(), Calendar.getInstance(), 100);
        	hotelTeste.getGerenteServico(contrato).criaServicoSuplementarAluguelCarros(Calendar.getInstance(), Calendar.getInstance(), "asd123", TemTanqueCheio.SIM, TemSeguro.SIM, TipoCarro.EXECUTIVO);
        	
        	System.out.println("---");
        	System.out.println(hotelTeste.getGerenteServico(contrato).getServicos());
        	System.out.println("---");
        	AluguelCarro carro = hotelTeste.getGerenteServico().criaServicoSuplementarAluguelCarros(Calendar.getInstance(), Calendar.getInstance(), "asd123", TemTanqueCheio.SIM, TemSeguro.SIM, TipoCarro.EXECUTIVO);
        	System.out.println(hotelTeste.getGerenteServico(contrato).pesquisaServico(carro));
        	Servico carro2 = hotelTeste.getGerenteServico(contrato).pesquisaServico(carro);
        	hotelTeste.getGerenteServico(contrato).atualizarServicoSuplementarCarro((AluguelCarro) carro2, null, null, "aaabbb", TemTanqueCheio.NAO, TemSeguro.NAO, TipoCarro.LUXO);
        	System.out.println("---");
        	System.out.println(hotelTeste.getGerenteServico(contrato).getServicos());
        	
        	
        	
        	
        }
        

        //@Test
        public void testGerenteContratos() {
        	hotelTeste = new Hotel();
        	
        	hotelTeste.getGerenteContrato().criarContrato("111");
        	hotelTeste.getGerenteContrato().criarContrato("222");
        	hotelTeste.getGerenteContrato().criarContrato("333");
        	hotelTeste.getGerenteContrato().criarContrato("444");
        	hotelTeste.getGerenteContrato().criarContrato("555");
            System.out.println(hotelTeste.getGerenteContrato().getContratos());
                 
            System.out.println(hotelTeste.getGerenteContrato().pesquisaContrato("222"));
            Contrato contrato = hotelTeste.getGerenteContrato().pesquisaContrato("222");
            hotelTeste.getGerenteContrato().removeContrato(contrato);
            System.out.println(hotelTeste.getGerenteContrato().getContratos());
            
            Contrato contrato4 = hotelTeste.getGerenteContrato().pesquisaContrato("444");
            hotelTeste.getGerenteContrato().atualizarContrato(contrato4, "4321");
            hotelTeste.getGerenteContrato().criarContrato("222");
            System.out.println(hotelTeste.getGerenteContrato().getContratos());
            
            System.out.println(contrato4.getServicos());
            
               
        }
        
       /* @Test
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
        	
        }*/

}
