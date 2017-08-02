package co.com.calendarioid.persistence.controller;

import android.content.Context;

import java.util.List;

import co.com.calendarioid.persistence.iface.ICartera;
import co.com.calendarioid.persistence.impl.CarteraImpl;
import co.com.calendarioid.persistence.model.Cartera;

/**
 * Created by desarrollo on 14/07/2017.
 */

public class CarteraController {

    private Context context;
    private ICartera iCartera;

    public CarteraController(Context context){
        this.context = context;
    }

    public List<Cartera> consultar(Cartera cartera) throws Exception {
        iCartera = new CarteraImpl(context);
        List<Cartera> lista;
        try {
            lista = iCartera.consultar(cartera);
        }finally {
            ((CarteraImpl)iCartera).close();
        }
        return lista;
    }

    public void insertarActualizar(Cartera entidad) throws Exception {
        iCartera = new CarteraImpl(context);
        try {
            iCartera.insertarActualizar(entidad);
        }finally {
            ((CarteraImpl)iCartera).close();
        }
    }

    public void eliminar(Cartera entidad) throws Exception {
        iCartera = new CarteraImpl(context);
        try {
            iCartera.insertarActualizar(entidad);
        }finally {
            ((CarteraImpl)iCartera).close();
        }
    }
}
