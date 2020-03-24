/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.Exception.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2146516
 */
@ManagedBean(name="servAlquiler")
@SessionScoped
public class ServiciosAlquilerBean extends BasePageBean{
    private ArrayList<ItemRentado> rentadosDefault = new ArrayList<>(); 
    @Inject
    private ServiciosAlquiler serviciosAlquiler;
    private Cliente clienteSeleccionado;
    private long costo;
    public Cliente consultarCliente(long id){
        try {
            return serviciosAlquiler.consultarCliente(id);
        } catch (ExcepcionServiciosAlquiler ex) {
            return null;
        }
    }
    public List<Cliente> consultarClientes(){
        try {        
            return serviciosAlquiler.consultarClientes();
        } catch (ExcepcionServiciosAlquiler ex) {
            return null;
        }
    }
    public void registrarCliente(long doc,String nombre,String telefono, String direccion,String mail){
        Cliente aux = new Cliente ( nombre,doc, telefono, direccion,mail,false , rentadosDefault);
        try {
            serviciosAlquiler.registrarCliente(aux);
        } catch (ExcepcionServiciosAlquiler ex) {
            Logger.getLogger(ServiciosAlquilerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registrarAlquiler(Date date, long docu, int iditem, int numdias){
        try {
            Item item;
            item = serviciosAlquiler.consultarItem(iditem);
            serviciosAlquiler.registrarAlquilerCliente((java.sql.Date) date,docu,item,numdias);
        } catch (ExcepcionServiciosAlquiler ex) {
            Logger.getLogger(ServiciosAlquilerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void consultarCostoRenta(int iditem,int numerodias){
        try {
            costo = serviciosAlquiler.consultarCostoAlquiler(iditem, numerodias);
        } catch (ExcepcionServiciosAlquiler ex) {
            costo = 0;
        }
    }
    public void setClienteSeleccionado(Cliente cliente){
        this.clienteSeleccionado = cliente;
    }
    public Cliente getClienteSeleccionado(){
        return this.clienteSeleccionado;
    }
    public void setCosto(long costo){
        this.costo = costo;
    }
    public long getCosto(){
        return costo;
    }
    
    
}
