package com.example.ravin.emultimate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ravin on 15/05/2018.
 */

public class AdaptadorStats extends BaseAdapter {

    Context contexto;
    List<Usuario> listaUsuarios;

    public AdaptadorStats(Context contexto, List<Usuario> listaUsuarios) {
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
        vista=inflate.inflate(R.layout.itemlistviewstats, null);

        TextView tvNumJuegos = vista.findViewById(R.id.tvNumJuegos);
        TextView tvTiempoJugando = vista.findViewById(R.id.tvTiempoJugando);
        TextView tvJuegoMasJugado = vista.findViewById(R.id.tvJuegoMasJugado);
        TextView tvTopFive = vista.findViewById(R.id.tvTopFive);
        TextView tvCompletados = vista.findViewById(R.id.tvJuegosCompletados);
        TextView tvEmuFavorito = vista.findViewById(R.id.tvEmuladorFavorito);

        tvNumJuegos.setText(listaUsuarios.get(i).getNumJuegos());
        tvTiempoJugando.setText(listaUsuarios.get(i).getMinutosJugados());
        tvJuegoMasJugado.setText(listaUsuarios.get(i).getJuegoFavorito());
        tvTopFive.setText(listaUsuarios.get(i).getTopFive().toString());
        tvCompletados.setText(listaUsuarios.get(i).getNumJuegosCompletados());
        tvEmuFavorito.setText(listaUsuarios.get(i).getEmuladorFavorito());

        return vista;
    }
}
