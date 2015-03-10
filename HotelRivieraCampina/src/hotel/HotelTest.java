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


                quarto1 = new QuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.DUPLO, TemCamaExtra.SIM);
                quarto2 = new QuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.SIMPLES, TemCamaExtra.NAO);
                quarto3 = new QuartoExecutivo(Calendar.getInstance(), Calendar.getInstance(), TipoQuartoExecutivo.DUPLO, TemCamaExtra.SIM);

                endereco1 = new Endereco("br", "pb", "cg", "02", "02");
                endereco2 = new Endereco("br", "pb", "cg", "02", "02");
                endereco3 = new Endereco("br", "pb", "cg", "02", "02");

                hospede1 = new Hospede("heitor", "2222222", Calendar.getInstance(), endereco1);
                hospede2 = new Hospede("aqulies", "2222222", Calendar.getInstance(), endereco2);
                hospede3 = new Hospede("gullo", "2222222", Calendar.getInstance(), endereco3);

                contrato1 = new Contrato(hospede1, "111111", quarto1);
                contrato2 = new Contrato(hospede2, "111111", quarto2);
                contrato3 = new Contrato(hospede3, "111111", quarto3);

                contratos.add(contrato1);
                contratos.add(contrato2);
                contratos.add(contrato3);

                hotelTeste = new Hotel(contratos);
        }
        
        
        @Test
        public void testGetContratos() {
                System.out.println(hotelTeste.getContratos());
                for (int i = 0; i < hotelTeste.getContratos().size(); i++) {
                        System.out.println(hotelTeste.getContratos().get(i).getHospede());
                }
               
        }
        
        
        @Test
        public void testGerenteHospede(){
        	 hotelTeste.getGerenteHospede().atualizaHospede("heitor", hospede3);
             System.out.println("-----------------");
             testGetContratos();
             
             hotelTeste.getGerenteHospede().pesquisaHospede("gullo");
             }
        

        //@Test
        public void testSetContratos() {
                fail("Not yet implemented");
        }

}
