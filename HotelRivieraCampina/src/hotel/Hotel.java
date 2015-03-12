package hotel;

import gerenteContrato.GerenteContrato;
import gerenteHospede.GerenteHospede;
import gerenteServicos.GerenteServicos;

import java.util.ArrayList;
import java.util.List;

import contrato.Contrato;
 
public class Hotel {
	
        private GerenteHospede gerenteHospede;
        private GerenteServicos gerenteServico;
        private GerenteContrato gerenteContrato;


        public Hotel() {
        	gerenteHospede = new GerenteHospede(); 
        	gerenteContrato = new GerenteContrato();                
        }

  
        public GerenteHospede getGerenteHospede(){        	
                return gerenteHospede;
        }
        

		public GerenteServicos getGerenteServico(Contrato contrato1) {
			gerenteServico = new GerenteServicos(contrato1);
			return gerenteServico;
		}
		
		public GerenteServicos getGerenteServico() {
			gerenteServico = new GerenteServicos();
			return gerenteServico;
		}

		public GerenteContrato getGerenteContrato() {
			return gerenteContrato;
			
		}


		       
        

}
