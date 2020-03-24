package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;

import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.Exception.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

   @Inject
   private ItemDAO itemDAO;
   @Inject
   private ClienteDAO clienteDAO;
   @Inject
   private TipoItemDAO tipoItem;

   @Override
   public int valorMultaRetrasoxDia(int itemId) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
      try {
         return clienteDAO.consultarCliente(docu);
      } catch (PersistenceException ex){
         throw new ExcepcionServiciosAlquiler("No existe cliente con el documento: "+docu,ex);
      }
   }

   @Override
   public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
      try {
         return clienteDAO.ConsultarCliente(idcliente).getRentados();
      } catch (PersistenceException ex){
         throw new ExcepcionServiciosAlquiler("No existe cliente con el id: "+idcliente,ex);
      }
   }

   @Override
   public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
      try {
         return clienteDAO.consultarClientes();
      } catch (PersistenceException ex){
         throw new ExcepcionServiciosAlquiler("No existen clientes ",ex);
      }
   }

   @Override
   public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
      try {
         Item item = itemDAO.load(id);
         if (item == null) throw new ExcepcionServiciosAlquiler("No existe item con el id: "+id);
         return item;
      } catch (PersistenceException ex) {
         throw new ExcepcionServiciosAlquiler("No existe item con el id: "+id,ex);
      }
   }

   @Override
   public List<Item> consultarItemsDisponibles() throws ExcepcionServiciosAlquiler  {
      try{
         return itemDAO.loadItemsAvailable();
      }catch (PersistenceException ex){
         throw new ExcepcionServiciosAlquiler("No existen items disponibles ",ex);
      }
   }

   @Override
   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
      try{
         return itemDAO.loadMultaAlquiler(iditem,fechaDevolucion);
      }catch (PersistenceException ex){
         throw new ExcepcionServiciosAlquiler("No existe multa para el item con id "+iditem,ex);
      }
   }

   @Override
   public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
      try{
         return tipoItem.load(id);
      }catch (PersistenceException ex){
         throw new ExcepcionServiciosAlquiler("No existe item con id "+id,ex);
      }
   }

   @Override
   public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
      try{
         return tipoItem.load();
      }catch (PersistenceException ex){
         throw new ExcepcionServiciosAlquiler("No existe items para consultar",ex);
      }
   }

   @Override
   public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
      Date actual= new Date(Calendar.getInstance().getTime().getTime());
      try {
         clienteDAO.regitrarCliente(actual,(int) docu,item,numdias);
      } catch (PersistenceException e) {
         throw new ExcepcionServiciosAlquiler("Error al registrar el cliente",e);
      }
   }

   @Override
   public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
      try {
         clienteDAO.regitrarCliente(c);
      } catch (PersistenceException ex) {
         throw new ExcepcionServiciosAlquiler("Error al registrar el cliente",ex);
      }
   }

   @Override
   public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
      try {
         return itemDAO.loadCosto(iditem,numdias);
      } catch (PersistenceException ex) {
         throw new ExcepcionServiciosAlquiler("Error al consultar el item "+iditem,ex);
      }
   }

   @Override
   public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
      try {
         itemDAO.actualizarTarifaItem(id,tarifa);
      } catch (PersistenceException ex) {
         throw new ExcepcionServiciosAlquiler("Error al actualizar tarifa item "+id,ex);
      }
   }

   @Override
   public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
      try {
         itemDAO.save(i);
      } catch (PersistenceException ex) {
         throw new ExcepcionServiciosAlquiler("Error al actualizar tarifa item ",ex);
      }
   }

   @Override
   public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
      try {
         clienteDAO.vetarCliente(docu,estado);
      } catch (PersistenceException ex) {
         throw new ExcepcionServiciosAlquiler("Error al encontrar cliente"+docu,ex);
      }
   }

   @Override
   public List<Item> consultarItems() throws ExcepcionServiciosAlquiler {
      return null;
   }

   @Override
   public void registrarTipoItem(TipoItem it) throws ExcepcionServiciosAlquiler {

   }
}