package co.com.calendarioid.fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import co.com.calendarioid.R;
import co.com.calendarioid.persistence.controller.CarteraController;
import co.com.calendarioid.persistence.iface.ICartera;
import co.com.calendarioid.persistence.impl.CarteraImpl;
import co.com.calendarioid.persistence.model.Cartera;
import co.com.calendarioid.persistence.model.Pokemon;
import co.com.calendarioid.services.iface.IPokemonService;
import co.com.calendarioid.services.impl.PokemonServiceImpl;

/**
 * Created by desarrollo on 12/06/2017.
 */

public class FragmentDetalle extends Fragment {

    Button btnCambiar;
    Button btnFormularioCartera;
    FragmentTransaction transaction;
    FragmentListado fragmentListado;
    FragmentListaCartera fragmentListaCartera;

    public FragmentDetalle(){
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        btnFormularioCartera = (Button) view.findViewById(R.id.btnFormularioCartera);
        btnFormularioCartera.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                transaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentListaCartera = new FragmentListaCartera();
                transaction.replace(R.id.contenedor, fragmentListaCartera);
                transaction.commit();
            }
        });

        btnCambiar = (Button) view.findViewById(R.id.button);
        //accion para pasar a fragment detalle
        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                transaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentListado = new FragmentListado();
                transaction.replace(R.id.contenedor, fragmentListado);
                transaction.commit();


/*
                //TAREA asincrona new <ParametroEjecucionTarea, x(OmitirSiNoSeRequiere), ParametroOnPostExecute>
                new AsyncTask<String, Boolean, Pokemon>() {
                    //inicio tarea asincrona
                    @Override
                    protected Pokemon doInBackground(String... params) {
                        IPokemonService iPokemon = new PokemonServiceImpl();
                        Pokemon pokemon = null;
                        try {
                            pokemon = iPokemon.pruebaWebService(null);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        return pokemon;
                    }

                    //Ejecución cuanto termina tarea asincrona
                    @Override
                    protected void onPostExecute(Pokemon parametroFin) {
                        super.onPostExecute(parametroFin);
                    }
                }.execute("ParametroInicioTareaPrueba");
                //Ejecucion tarea
                //tareaAsincrona.execute("ParametroInicioTareaPrueba");

*/
                FragmentDetalle.copyDataBaseInicio(getContext(), getContext().getPackageName(), getResources().getString(R.string.db_name));
                //CONSULTA BD local Sqlite
                try {
                    CarteraController carteraController = new CarteraController(getContext());
                    List<Cartera> listaCartera = carteraController.consultar(new Cartera());
                    System.out.print(listaCartera != null ? listaCartera.size() : null);
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        return view;
    }



    public static boolean copyDataBaseInicio(Context myContext, String nombrePaquete, String nombreBD) {
        try {
            String db_path = myContext.getResources().getString(R.string.ruta_bd);
            InputStream myInput = myContext.getAssets().open(nombreBD);
            String outFileName = String.format(db_path, nombrePaquete) + nombreBD;

            File archivo = new File(String.format(db_path, nombrePaquete));
            if (!archivo.exists()) {
                boolean esCreado = archivo.mkdir();
                if (esCreado) {
                    OutputStream myOutput = new FileOutputStream(outFileName);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = myInput.read(buffer)) > 0) {
                        myOutput.write(buffer, 0, length);
                    }
                    myOutput.flush();
                    myOutput.close();
                    myInput.close();
                } else {
                    return false;
                }
            }
            /*File[] archivos = archivo.listFiles();
            for(File arc: archivos){
                String tam = arc.length()+"";
                Log.i("Tamanio: ",arc.getName()+ " > "+tam);
            }*/
        } catch (IOException e) {
            //TODO manejar excepcion
            return false;
        }

        return true;
    }

    public void mostrarDetalle(String texto) {

        TextView txtDetalle = (TextView)getView().findViewById(R.id.TxtDetalle);
        txtDetalle.setText(texto);
    }
}
