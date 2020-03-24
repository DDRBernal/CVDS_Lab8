package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Item;

import java.sql.Date;
import java.util.List;

public interface ItemDAO {

   public void save(Item it) throws PersistenceException;

   public Item load(int id) throws PersistenceException;

   List<Item> loadItemsAvailable()throws PersistenceException;

   Long loadMultaAlquiler(int iditem, Date fechaDevolucion) throws PersistenceException;


   long loadCosto(int iditem, int numdias) throws PersistenceException;

   void actualizarTarifaItem(int id, long tarifa) throws PersistenceException;
}