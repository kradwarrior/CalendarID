package co.com.calendarioid.activitis;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import co.com.calendarioid.R;
import co.com.calendarioid.fragment.FragmentDetalle;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    FragmentDetalle fragmentDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //paso a fragment listado
        transaction = getSupportFragmentManager().beginTransaction();
        fragmentDetalle = new FragmentDetalle();
        transaction.replace(R.id.contenedor, fragmentDetalle);
        transaction.commit();
    }
}
