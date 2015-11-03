package ListAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hector.apptablet.Model.ItemLista;
import com.example.hector.apptablet.R;


import java.util.ArrayList;

/**
 * Created by hector on 23/08/2014.
 */
public class mAdapter extends BaseAdapter {

    private ArrayList<ItemLista> listaItems;
    private Context context;
    private viewHolder mviewHolder;

    public mAdapter(ArrayList<ItemLista> listaItems, Context context) {
        this.listaItems = listaItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaItems.size();
    }

    @Override
    public ItemLista getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ItemLista cancion = listaItems.get(i);
        final int z = i;


        if (convertView == null) {

            mviewHolder = new viewHolder();

            LayoutInflater mInflaer = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflaer.inflate(R.layout.activity_visor_imagen, null);

            mviewHolder.imagen = (ImageView) convertView.findViewById(R.id.ivIcono);
            mviewHolder.tvNombre = (TextView) convertView.findViewById(R.id.tvNombreCancion);
            mviewHolder.tvAutor = (TextView) convertView.findViewById(R.id.tvAutor);
            mviewHolder.tvGenero = (TextView) convertView.findViewById(R.id.tvGenero);
            mviewHolder.tvDuracion = (TextView) convertView.findViewById(R.id.tvDuracion);
            mviewHolder.tvValoracion = (TextView) convertView.findViewById(R.id.tvValoracion);
            mviewHolder.delete = (ImageView) convertView.findViewById(R.id.ivIconoSmall);

            convertView.setTag(mviewHolder);

        } else {
            mviewHolder = (viewHolder) convertView.getTag();
        }

        mviewHolder.imagen.setImageResource(cancion.getImage());
        mviewHolder.tvNombre.setText(cancion.getNombre());
        mviewHolder.tvAutor.setText(cancion.getAutor());
        mviewHolder.tvGenero.setText(cancion.getGenero());
        mviewHolder.tvDuracion.setText(cancion.getDuracion());
        mviewHolder.tvValoracion.setText(String.valueOf(cancion.getValoracion()));

        mviewHolder.delete.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                listaItems.remove(z);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    static class viewHolder {

        ImageView imagen;
        TextView tvNombre;
        TextView tvAutor;
        TextView tvGenero;
        TextView tvDuracion;
        TextView tvValoracion;
        ImageView delete;
    }
}
