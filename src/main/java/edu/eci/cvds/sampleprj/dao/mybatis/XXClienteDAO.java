/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.mybatis;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Item;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 2152805
 */
public class XXClienteDAO implements ClienteDAO{

    @Override
    public void regitrarCliente(Cliente cliente) throws PersistenceException {

    }

    @Override
    public Cliente consultarCliente(long documento) throws PersistenceException {
        return null;
    }

    @Override
    public Cliente ConsultarCliente(long idcliente) throws PersistenceException {
        return null;
    }

    @Override
    public List<Cliente> consultarClientes() throws PersistenceException {
        return null;
    }

    @Override
    public void regitrarCliente(java.sql.Date date, long docu, Item item, int numdias) throws PersistenceException {

    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws PersistenceException {

    }
}