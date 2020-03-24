package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.TipoItem;

import javax.xml.registry.infomodel.PersonName;
import java.util.List;

public interface TipoItemDAO {
    TipoItem load (int id)throws PersistenceException;

    List<TipoItem> load() throws PersistenceException;

}
