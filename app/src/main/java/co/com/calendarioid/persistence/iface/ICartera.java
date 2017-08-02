package co.com.calendarioid.persistence.iface;

import java.util.List;

import co.com.calendarioid.persistence.impl.CarteraImpl;
import co.com.calendarioid.persistence.model.Cartera;

/**
 * Created by desarrollo on 04/07/2017.
 */

public interface ICartera {

    public List<Cartera> consultar(Cartera entidad) throws Exception;

    public void insertarActualizar(Cartera entidad) throws Exception;

    public void eliminar(Cartera entidad) throws Exception;
}
