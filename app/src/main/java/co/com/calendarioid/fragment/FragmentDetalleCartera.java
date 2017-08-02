package co.com.calendarioid.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.com.calendarioid.R;
import co.com.calendarioid.persistence.controller.CarteraController;
import co.com.calendarioid.persistence.iface.ICartera;
import co.com.calendarioid.persistence.impl.CarteraImpl;
import co.com.calendarioid.persistence.model.Cartera;

public class FragmentDetalleCartera extends Fragment {

    EditText txtId;
    EditText txtDescripcion;
    Button btnGuardar;
    Button btnVolver;
    Button btnEliminar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private FragmentListaCartera fragmentListaCartera;
    private ICartera iCartera;
    private Cartera cartera;

    public FragmentDetalleCartera() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_cartera, container, false);

        txtId = (EditText) view.findViewById(R.id.txtIdCartera);
        txtDescripcion = (EditText) view.findViewById(R.id.txtDescripcionCartera);
        btnGuardar = (Button) view.findViewById(R.id.btnGuardar);
        btnEliminar = (Button) view.findViewById(R.id.btnEliminar);
        btnVolver = (Button) view.findViewById(R.id.btnVolver);
        return view;
    }
    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments() != null && getArguments().size() > 0){
            txtId.setText(getArguments().getInt("idCartera")+"");
            txtDescripcion.setText(getArguments().getString("descripcionCartera"));
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                try {
                    Cartera cartera = new Cartera(new Integer(txtId.getText().toString()), txtDescripcion.getText().toString(), null);
                    iCartera = new CarteraImpl(getContext());
                    iCartera.insertarActualizar(cartera);

                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentListaCartera = new FragmentListaCartera();
                    fragmentTransaction.replace(R.id.contenedor, fragmentListaCartera);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                    InputMethodManager inputMethodManager =  (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);

                    Toast.makeText(getActivity(), "Se guardo correctamente", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                try {
                    Cartera cartera = new Cartera(new Integer(txtId.getText().toString()), null, null);
                    iCartera = new CarteraImpl(getContext());
                    iCartera.eliminar(cartera);

                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentListaCartera = new FragmentListaCartera();
                    fragmentTransaction.replace(R.id.contenedor, fragmentListaCartera);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    Toast.makeText(getActivity(), "Se elimino correctamente", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentListaCartera = new FragmentListaCartera();
                fragmentTransaction.replace(R.id.contenedor, fragmentListaCartera);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }


}
