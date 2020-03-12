package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;


public interface ClienteDAO {

   public void regitrarCliente(Cliente cliente);

   public Cliente consultarCliente(long documento);

   public void modificarCliente(Cliente cliente);

}