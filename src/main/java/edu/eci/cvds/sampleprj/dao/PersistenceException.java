package edu.eci.cvds.sampleprj.dao;


public class PersistenceException extends Exception {
    
    public PersistenceException(String message){
        super(message);
    }

    public PersistenceException(String message, Throwable e) {
        super(message);
    }
}