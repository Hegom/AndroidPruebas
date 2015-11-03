package com.example.hector.apptablet.Adapter;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hector.apptablet.R;

import org.w3c.dom.Text;

/**
 * Created by hector on 26/08/2014.
 */
public class FragmentItemList extends Fragment {

   TextView tvItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_itemlist, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        tvItem = (TextView) getView().findViewById(R.id.tvItemList);

    }

    public void mostrarDetalle(String texto)
    {
        Log.i("fragment", "hola mundo");
        tvItem.setText(texto);
    }
}
