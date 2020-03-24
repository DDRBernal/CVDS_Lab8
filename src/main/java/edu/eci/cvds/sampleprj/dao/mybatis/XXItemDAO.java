package edu.eci.cvds.sampleprj.dao.mybatis;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import java.util.Date;
import java.util.List;

public class XXItemDAO implements ItemDAO{
    @Override
    public void save(Item it) throws PersistenceException {

    }

    @Override
    public Item load(int id) throws PersistenceException {
        return null;
    }

    @Override
    public List<Item> loadItemsAvailable() throws PersistenceException {
        return null;
    }

    @Override
    public Long loadMultaAlquiler(int iditem, java.sql.Date fechaDevolucion) throws PersistenceException {
        return null;
    }

    @Override
    public long loadCosto(int iditem, int numdias) throws PersistenceException {
        return 0;
    }

    @Override
    public void actualizarTarifaItem(int id, long tarifa) throws PersistenceException {

    }
}
