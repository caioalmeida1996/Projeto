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
        private List<Contrato> contratos = new ArrayList<Contrato>();

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
        		contrato1 = new Contrato("111111", quarto1);
        		contrato2 = new Contrato("111111", quarto2);
        		contrato3 = new Contrato("111111", quarto3);
        		
        		endereco1 = new Endereco("br", "pb", "cg", "02", "02");
                endereco2 = new Endereco("br", "pb", "cg", "02", "02");
                endereco3 = new Endereco("br", "pb", "cg", "02", "02");
                
                hotelTeste.getGerenteHospede().criaHospede("heitor", "2222222", Calendar.getInstance(), endereco1, contrato1);
                hotelTeste.getGerenteHospede().criaHospede("aqulies", "2222222", Calendar.getInstance(), endereco2, contrato2);
                hotelTeste.getGerenteHospede().criaHospede("gullo", "2222222", Calendar.getInstance(), endereco3, contrato3);
        		

                quarto1 = new QuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.DUPLO, TemCamaExtra.SIM, contrato1);
                quarto2 = new QuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.SIMPLES, TemCamaExtra.NAO, contrato2);
                quarto3 = new QuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.DUPLO, TemCamaExtra.SIM,contrato3);

                contratos.add(contrato1);
                contratos.add(contrato2);
                contratos.add(contrato3);

                hotelTeste = new Hotel(contratos);
        }
        
        
        //@Test
        public void testGetContratos() {
                System.out.println(hotelTeste.getContratos());
                for (int i = 0; i < hotelTeste.getContratos().size(); i++) {
                        System.out.println(hotelTeste.getContratos().get(i).getHospede());
                }
               
        }
        
        
        @Test
        public void testGerenteHospede(){
        	System.out.println(hotelTeste.getGerenteHospede().getHospedes());
        	System.out.println(hotelTeste.getGerenteHospede().pesquisaHospede("heitor"));
        	hotelTeste.getGerenteHospede().atualizaHospede("gullo", hospede2);
        	System.out.println(hotelTeste.getGerenteHospede().getHospedes());
        	hotelTeste.getGerenteHospede().removeHospede(hospede3);
        	System.out.println(hotelTeste.getGerenteHospede().getHospedes());
             System.out.println("-----------------");
             testGetContratos();
             
            // hotelTeste.getGerenteHospede().criaHospede(nome, cpf, dataNascimento, endereco, contrato);
             
             
             }
        

        //@Test
        public void testSetContratos() {
                fail("Not yet implemented");
        }

}
