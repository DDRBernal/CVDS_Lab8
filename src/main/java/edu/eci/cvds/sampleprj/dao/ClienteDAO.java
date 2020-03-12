package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;


import java.util.List;


public interface ClienteDAO {

   public void regitrarCliente(Cliente cliente);

   public Cliente consultarCliente(long documento);

   public void modificarCliente(Cliente cliente);

   public List<Cliente> consultarCliente();

}