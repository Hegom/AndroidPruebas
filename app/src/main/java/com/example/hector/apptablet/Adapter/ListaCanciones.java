package com.example.hector.apptablet.Adapter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hector.apptablet.Model.ItemLista;
import com.example.hector.apptablet.R;

import java.util.ArrayList;

public class ListaCanciones extends Activity {

        ListView mListView;
        ArrayList<ItemLista> listaCaciones;
    ListAdapter.mAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_canciones);
        mFindView();
        crearCanciones();
       adapter = new ListAdapter.mAdapter(listaCaciones, this);


        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("tag","click en el item " + i + listaCaciones.get(i).getNombre());
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lista_canciones, menu);
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

    private void mFindView() {
        mListView = (ListView) findViewById(R.id.lvId);
    }
    private void crearCanciones(){
        listaCaciones = new ArrayList<ItemLista>();

        listaCaciones.add(new ItemLista(0,"She Wolf", "Tiesto", "Electonica", 5, "4:14", "todavia no hay letra", R.drawable.tiesto));
        listaCaciones.add(new ItemLista(1,"RockStar", "Nickelback", "Rock", 3, "4:14", "todavia no hay letra", R.drawable.nick));
        listaCaciones.add(new ItemLista(2,"Pump it!", "The Black Eyed Peas", "Electro-Pop", 4, "3:46", "todavia no hay letra", R.drawable.bep));
        listaCaciones.add(new ItemLista(3,"Lose Yourself", "Eminem", "Rap", 3, "5:12", "todavia no hay letra", R.drawable.eminem));
        listaCaciones.add(new ItemLista(4,"Bring Me to Life", "Evanescence", "Metal Alternativo", 3, "4:13", "todavia no hay letra", R.drawable.eva));
        listaCaciones.add(new ItemLista(5,"Phoenix", "Fall Out Boy", "Rock Alternativo", 5, "4:23", "todavia no hay letra", R.drawable.falloutboy));
        listaCaciones.add(new ItemLista(6,"21 Guns", "GreeDay", "Rock Alternativo", 3, "5:27", "todavia no hay letra", R.drawable.green));
        listaCaciones.add(new ItemLista(7,"Bleed it Out", "Linkin Park", "Rock Alternativo", 4, "2:49", "todavia no hay letra", R.drawable.linkinpark));
        listaCaciones.add(new ItemLista(8,"Du Rieachst so Gut", "Rammstein", "Hard Metal", 4, "4:02", "todavia no hay letra", R.drawable.rammstein));
        listaCaciones.add(new ItemLista(9,"Secound Chance", "ShineDown", "Rock", 3, "3:44", "todavia no hay letra", R.drawable.shine));
        listaCaciones.add(new ItemLista(10,"Never Too Late", "TDG", "Rock", 3, "3:32", "todavia no hay letra", R.drawable.tdg));

    }
}
