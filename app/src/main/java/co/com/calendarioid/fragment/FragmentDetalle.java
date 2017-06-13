package co.com.calendarioid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import co.com.calendarioid.R;

/**
 * Created by desarrollo on 12/06/2017.
 */

public class FragmentDetalle extends Fragment {

    Button btnCambiar;
    FragmentTransaction transaction;
    FragmentListado fragmentListado;

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

        btnCambiar = (Button) view.findViewById(R.id.button);
        //accion para pasar a fragment detalle
        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentListado = new FragmentListado();
                transaction.replace(R.id.contenedor, fragmentListado);
                transaction.commit();
            }
        });
        return view;
    }

    public void mostrarDetalle(String texto) {
        TextView txtDetalle = (TextView)getView().findViewById(R.id.TxtDetalle);
        txtDetalle.setText(texto);
    }
}
