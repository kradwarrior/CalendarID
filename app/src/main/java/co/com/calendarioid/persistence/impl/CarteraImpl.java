package co.com.calendarioid.persistence.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.calendarioid.persistence.SQLiteHelperExtends;
import co.com.calendarioid.persistence.iface.ICartera;
import co.com.calendarioid.persistence.model.Cartera;

/**
 * Created by desarrollo on 04/07/2017.
 */

public class CarteraImpl implements ICartera {

    private Context context;
    private SQLiteHelperExtends sqLiteHelperExtends;
    private SQLiteDatabase database;

    public CarteraImpl(Context context){
        this.context = context;
        open();
    }

    public void open() throws SQLiteException {
        sqLiteHelperExtends = new SQLiteHelperExtends(context, null, 1);
        database = sqLiteHelperExtends.getWritableDatabase();
    }

    public void close() throws SQLiteException {
        sqLiteHelperExtends.close();
    }

    public List<Cartera> consultar(Cartera entidad) throws Exception {
        String query = "select * from cartera";
        Cursor cursor = database.rawQuery(query, null);
        List<Cartera> listaCartera = new ArrayList<>();
        Cartera cartera = null;
        while (cursor.moveToNext()) {
            cartera = new Cartera();
            cartera.setId(cursor.getInt(0));
            cartera.setDescripcion(cursor.getString(1));
            listaCartera.add(cartera);
        }
        return listaCartera;
    }

    public void insertarActualizar(Cartera entidad) throws Exception {
        String query;
        if(entidad.getId() == null || entidad.getId() == 0){
            query = "insert into cartera (descripcion,fecha_creacion) values ('"+entidad.getDescripcion()+"','"+new Date()+"')";
        } else {
            query = "update cartera set descripcion = '"+entidad.getDescripcion()+"' where id="+entidad.getId();
        }
        database.execSQL(query);
    }

    public void eliminar(Cartera entidad) throws Exception {
        String query = "delete from cartera where id="+entidad.getId();
        database.execSQL(query);
    }
}
