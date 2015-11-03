package com.example.hector.apptablet.Adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hector.apptablet.Interface.CancionListener;
import com.example.hector.apptablet.Model.ItemLista;
import com.example.hector.apptablet.R;

public class ActivityListaCacionesLetra extends Activity implements CancionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_canciones_letra);

        FragmentList frgListado = (FragmentList) getFragmentManager().findFragmentById(R.id.fragmentoDetalle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.fragment_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCancionSeleccionada(ItemLista cancion) {

    }
}
