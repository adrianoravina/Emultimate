package com.example.ravin.emultimate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ravin on 13/05/2018.
 */

public class AdaptadorFollows extends BaseAdapter {

    Context contexto;
    List<Usuario> listaUsuarios;

    public AdaptadorFollows(Context contexto, List<Usuario> listaUsuarios) {
        this.contexto = contexto;
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public int getCount() {
        return listaUsuarios.size();
    }

    @Override
    public Object getItem(int i) {
        return listaUsuarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaUsuarios.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista=view;
        LayoutInflater inflate = LayoutInflater.from(contexto); //Obtenemos el contexto del item sobre el cual estamos trabajando del ListView
        vista=inflate.inflate(R.layout.itemlistviewFollows, null);

        ImageView ivFoto = vista.findViewById(R.id.ivFoto);
        TextView tvNombre = vista.findViewById(R.id.tvNombre);

        ivFoto.setImageResource(R.drawable.avatar);
        tvNombre.setText(listaUsuarios.get(i).getNombre());

        return vista;
    }

}
