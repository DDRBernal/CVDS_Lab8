
package edu.eci.cvds.samples.services;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.Exception.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

    public class ServiciosAlquilerTest {


        ServiciosAlquiler serviciosAlquiler = ServiciosAlquilerFactory.getServiciosAlquilerTesting();
        ArrayList<ItemRentado> rentadosDefault = new ArrayList<>();


        @Before
        public void setUp() {

        }


        @Test
        public void deberiaConsultarCliente(){
            try {
                serviciosAlquiler.consultarCliente(2233);
                Assert.assertTrue(true);
            } catch (ExcepcionServiciosAlquiler ex) {
                Assert.fail();
            }
        }
        @Test
        public void deberiaInsertarCliente() throws ExcepcionServiciosAlquiler{

            try{
                serviciosAlquiler=ServiciosAlquilerFactory.getServiciosAlquilerTesting();
                serviciosAlquiler.registrarCliente(new Cliente("Saladoan",10010, "453322", "Cr1#22a43", "vlok@qek.com", false,rentadosDefault));
                Assert.assertTrue(true);
            }catch (ExcepcionServiciosAlquiler ex){
                Assert.fail();
            }

        }
        @Test
        public void deberiaVetarCliente() throws ExcepcionServiciosAlquiler{
            try{
                serviciosAlquiler.registrarCliente(new Cliente("Saladoan",10010, "453322", "Cr1#22a43", "vlok@qek.com", false,rentadosDefault));
                serviciosAlquiler.vetarCliente(10010, true);
                boolean valor = serviciosAlquiler.consultarCliente(10010).isVetado();
                Assert.assertEquals(valor, true);
            }catch (ExcepcionServiciosAlquiler ex){
                Assert.fail();
            }
        }
    }
