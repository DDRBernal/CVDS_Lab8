package edu.eci.cvds.sampleprj.dao.mybatis;

import edu.eci.cvds.sampleprj.dao.PersistenceException;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class MyBATISItemDAO implements ItemDAO{

  @Inject
  private ItemMapper itemMapper;    

  @Override
  public void save(Item it) throws PersistenceException{
  try{
      itemMapper.insertarItem(it);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al registrar el item "+it.toString(),e);
  }        

  }

  @Override
  public Item load(int id) throws PersistenceException {
  try{
      return itemMapper.consultarItem(id);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al consultar el item "+id,e);
  }


  }

  @Override
  public List<Item> loadItemsAvailable() throws PersistenceException {
    return null;
  }

  @Override
  public Long loadMultaAlquiler(int iditem, Date fechaDevolucion) throws PersistenceException {
    return null;
  }

  @Override
  public long loadCosto(int iditem, int numdias) {
    return itemMapper.consultarCostoTarifa(iditem,numdias);
  }

  @Override
  public void actualizarTarifaItem(int id, long tarifa) throws PersistenceException {
    itemMapper.actualizarTarifa(id,tarifa);
  }

}