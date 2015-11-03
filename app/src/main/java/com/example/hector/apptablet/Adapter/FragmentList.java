package com.example.hector.apptablet.Adapter;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hector.apptablet.Interface.CancionListener;
import com.example.hector.apptablet.Model.ItemLista;
import com.example.hector.apptablet.R;

import java.util.ArrayList;

/**
 * Created by hector on 26/08/2014.
 */
public class FragmentList extends Fragment {

    ListView mListView;
    ArrayList<ItemLista> listaCaciones;
    ListAdapter.mAdapter adapter;

    CancionListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_list, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mFindView();
        crearCanciones();
        adapter = new ListAdapter.mAdapter(listaCaciones, getActivity());


        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("tag", "click en el item " + i + listaCaciones.get(i).getNombre());
            }
        });
    }

    private void mFindView() {
        mListView = (ListView) getView().findViewById(R.id.lvFragmentList);
    }

    private void crearCanciones() {
        listaCaciones = new ArrayList<ItemLista>();

        listaCaciones.add(new ItemLista(0, "She Wolf", "Tiesto", "Electonica", 5, "4:14", "todavia no hay letra", R.drawable.tiesto));
        listaCaciones.add(new ItemLista(1, "RockStar", "Nickelback", "Rock", 3, "4:14", "todavia no hay letra", R.drawable.nick));
        listaCaciones.add(new ItemLista(2, "Pump it!", "The Black Eyed Peas", "Electro-Pop", 4, "3:46", "todavia no hay letra", R.drawable.bep));
        listaCaciones.add(new ItemLista(3, "Lose Yourself", "Eminem", "Rap", 3, "5:12", "todavia no hay letra", R.drawable.eminem));
        listaCaciones.add(new ItemLista(4, "Bring Me to Life", "Evanescence", "Metal Alternativo", 3, "4:13", "todavia no hay letra", R.drawable.eva));
        listaCaciones.add(new ItemLista(5, "Phoenix", "Fall Out Boy", "Rock Alternativo", 5, "4:23", "todavia no hay letra", R.drawable.falloutboy));
        listaCaciones.add(new ItemLista(6, "21 Guns", "GreeDay", "Rock Alternativo", 3, "5:27", "todavia no hay letra", R.drawable.green));
        listaCaciones.add(new ItemLista(7, "Bleed it Out", "Linkin Park", "Rock Alternativo", 4, "2:49", "todavia no hay letra", R.drawable.linkinpark));
        listaCaciones.add(new ItemLista(8, "Du Rieachst so Gut", "Rammstein", "Hard Metal", 4, "4:02", "todavia no hay letra", R.drawable.rammstein));
        listaCaciones.add(new ItemLista(9, "Secound Chance", "ShineDown", "Rock", 3, "3:44", "todavia no hay letra", R.drawable.shine));
        listaCaciones.add(new ItemLista(10, "Never Too Late", "TDG", "Rock", 3, "3:32", "todavia no hay letra", R.drawable.tdg));

    }
}
