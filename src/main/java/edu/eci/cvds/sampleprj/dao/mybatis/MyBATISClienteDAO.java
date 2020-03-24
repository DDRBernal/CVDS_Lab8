package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class MyBATISClienteDAO implements ClienteDAO {

    @Inject
    private ClienteMapper clienteMapper;

    public void regitrarCliente(Cliente cliente) throws PersistenceException{
        try{
            clienteMapper.addCliente(cliente);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException ex){
            throw new PersistenceException("Error al registrar el cliente "+cliente.toString(),ex);
        }
    }

    public Cliente consultarCliente(long documento) throws PersistenceException{
        try{
            return clienteMapper.consultarCliente((int) documento);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException ex){
            throw new PersistenceException("Error al consultar el cliente con documento "+documento,ex);
        }
    }

    public Cliente ConsultarCliente(long idcliente) throws PersistenceException {
        try{
            return clienteMapper.consultarCliente((int) idcliente);
        } catch (org.apache.ibatis.exceptions.PersistenceException ex){
            throw new PersistenceException("Error al consultar el cliente con id: "+idcliente,ex);
        }
    }

    @Override
    public List<Cliente> consultarClientes() throws PersistenceException {
        return clienteMapper.consultarClientes();
    }

    @Override
    public void regitrarCliente(Date fechaInicio, long clienteId, Item itemAlquilado, int numdias) {
        //Date date, long docu, Item item, int numdias
        Calendar calendario=Calendar.getInstance();
        calendario.setTime(fechaInicio);
        calendario.add(Calendar.DAY_OF_YEAR, numdias);
        java.util.Date fechaFin=calendario.getTime();
        clienteMapper.agregarItemRentadoACliente((int)clienteId,itemAlquilado.getId(),fechaInicio,fechaFin);
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws PersistenceException {
        if (estado){
            clienteMapper.setVetado(docu,1);
        }else{
            clienteMapper.setVetado(docu,0);
        }
    }
}
