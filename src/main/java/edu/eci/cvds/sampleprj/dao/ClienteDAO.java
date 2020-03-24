package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;


import java.sql.Date;
import java.util.List;


public interface ClienteDAO {

   void regitrarCliente(Cliente cliente) throws PersistenceException;

   Cliente consultarCliente(long documento) throws PersistenceException;

   Cliente ConsultarCliente(long idcliente) throws PersistenceException;

   List<Cliente> consultarClientes() throws PersistenceException;

   void regitrarCliente(Date date, long docu, Item item, int numdias) throws PersistenceException;

   void vetarCliente(long docu, boolean estado) throws PersistenceException;
}