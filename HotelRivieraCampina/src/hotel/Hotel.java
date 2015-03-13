package hotel;

import gerenteContrato.GerenteContrato;
import gerenteHospede.GerenteHospede;
import gerenteServicos.GerenteServicos;

import java.util.ArrayList;
import java.util.List;

import contrato.Contrato;
import contrato.checkout;
 
public class Hotel {
	
        private GerenteHospede gerenteHospede;
        private GerenteServicos gerenteServico;
        private GerenteContrato gerenteContrato;

        /**
         * 
         */
        public Hotel() {
        	gerenteHospede = new GerenteHospede(); 
        	gerenteContrato = new GerenteContrato();                
        }

        /**
         * 
         * @return gerente Hospede
         */
        public GerenteHospede getGerenteHospede(){        	
                return gerenteHospede;
        }
        
        /**
         * 
         * @param contrato1 retorna um gerente  servico associado a um contrato
         * @return
         */
		public GerenteServicos getGerenteServico(Contrato contrato1) {
			gerenteServico = new GerenteServicos(contrato1);
			return gerenteServico;
		}
		
		/**
		 * 
		 * @return gerente servico
		 */
		public GerenteServicos getGerenteServico() {
			gerenteServico = new GerenteServicos();
			return gerenteServico;
		}

		/**
		 * 
		 * @return gerente contrato
		 */
		public GerenteContrato getGerenteContrato() {
			return gerenteContrato;
			
		}
		
		public checkout Checkout(Contrato contrato) throws Exception{
			checkout resultado = this.getGerenteContrato().checkout(contrato);
			getGerenteHospede().removeHospede(contrato.getHospede());
			return resultado;
		}


		       
        

}
