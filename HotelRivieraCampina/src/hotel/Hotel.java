package hotel;

import gerenteHospede.GerenteHospede;

import java.util.ArrayList;
import java.util.List;

import contrato.Contrato;

public class Hotel {

        private List<Contrato> contratos;
        private GerenteHospede gerenteHospede = new GerenteHospede();



        public Hotel(List<Contrato> contratos) {
                super();
                this.contratos = contratos;
                
                
        }

        //caso de uso 1




        public List<Contrato> getContratos() {
                return contratos;
        }

        public void setContratos(List<Contrato> contratos) {
                this.contratos = contratos;
        }

        public GerenteHospede getGerenteHospede(){
                return gerenteHospede;
        }

}
