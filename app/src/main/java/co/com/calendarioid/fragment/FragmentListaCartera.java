package co.com.calendarioid.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.calendarioid.R;
import co.com.calendarioid.persistence.controller.CarteraController;
import co.com.calendarioid.persistence.iface.ICartera;
import co.com.calendarioid.persistence.impl.CarteraImpl;
import co.com.calendarioid.persistence.model.Cartera;


public class FragmentListaCartera extends Fragment {

    ListView lvCartera;
    List<Cartera> listaCartera;
    Button btnNuevo;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private FragmentDetalleCartera fragmentDetalleCartera;

    public FragmentListaCartera() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_cartera, container, false);

        listaCartera = getListaCartera();
        lvCartera = (ListView) view.findViewById(R.id.lvCartera);
        btnNuevo = (Button) view.findViewById(R.id.btnNuevo);
        lvCartera.setAdapter(new AdaptadorCarteras(this));

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Seleccionar una fila
        lvCartera.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {

                Cartera cartera = (Cartera) adapterView.getItemAtPosition(posicion);
                Bundle args = new Bundle();
                args.putInt("idCartera", cartera.getId());
                args.putString("descripcionCartera", cartera.getDescripcion());

                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentDetalleCartera = new FragmentDetalleCartera();
                fragmentDetalleCartera.setArguments(args);
                fragmentTransaction.replace(R.id.contenedor, fragmentDetalleCartera);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btnNuevo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Bundle args = new Bundle();
                args.putInt("idCartera", 0);
                args.putString("descripcionCartera", null);

                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentDetalleCartera = new FragmentDetalleCartera();
                fragmentDetalleCartera.setArguments(args);
                fragmentTransaction.replace(R.id.contenedor, fragmentDetalleCartera);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    class AdaptadorCarteras extends ArrayAdapter<Cartera> {

        Activity context;

        AdaptadorCarteras(Fragment context) {
            super(context.getActivity(), R.layout.listitem_cartera, listaCartera);
            this.context = context.getActivity();
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_cartera, null);
            TextView lblDe = (TextView)item.findViewById(R.id.lvlIdItem);
            lblDe.setText(listaCartera.get(position).getId()+"");
            TextView lblAsunto = (TextView)item.findViewById(R.id.lvlDescripcionItem);
            lblAsunto.setText(listaCartera.get(position).getDescripcion());

            return(item);
        }
    }

    private List<Cartera> getListaCartera(){
        List<Cartera> listaCartera = new ArrayList<>();
        try {
            //CarteraController carteraController = new CarteraController(getContext());
            //listaCartera = carteraController.consultar(new Cartera());

            ICartera iCartera = new CarteraImpl(getContext());
            listaCartera = iCartera.consultar(new Cartera());
        } catch (Exception e){
            e.printStackTrace();
        }
        return listaCartera;
    }
}
