package edu.eci.cvds.samples.services.Exception;

import edu.eci.cvds.sampleprj.dao.PersistenceException;

public class ExcepcionServiciosAlquiler extends Exception {

    public ExcepcionServiciosAlquiler(String message){
        super(message);
    }

    public ExcepcionServiciosAlquiler(String message, PersistenceException ex) {
        super(message);
    }
}
