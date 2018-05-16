package com.example.ravin.emultimate;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PerfilActivity extends AppCompatActivity {

    Usuario usuario;
    String nombreUsuarioConectado;

    private static final String URL = "http://localhost:8080/Users/ravin/Desktop/emusocialdatos.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nombreUsuarioConectado = getIntent().getExtras().getString("usuario");

        cargarUsuario();

        List<String> listaStats = new ArrayList<>();

        listaStats.add(usuario.getNumJuegos()+"");
        listaStats.add(""+usuario.getMinutosJugados());
        listaStats.add(usuario.getJuegoFavorito());
        listaStats.add(usuario.getTopFive().toString());
        listaStats.add(usuario.getNumJuegosCompletados()+"");
        listaStats.add(usuario.getEmuladorFavorito());

        Bundle args = new Bundle();
        args.putSerializable("user",(Usuario)usuario);

        FragmentoEstadisticas fragmentInicial= new FragmentoEstadisticas();
        fragmentInicial.setArguments(args);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();


        transaction.replace(R.id.LinearLayoutContenedorFragmentStats, fragmentInicial);
        transaction.commit();

    }

    public void mostrarEstadisticas(View v){


    }

    public void mostrarSeguidores(View v){

    }

    public void mostrarSiguiendo(View v){

    }

    public void cargarUsuario(){

        RequestQueue request = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArrayPrincipal = new JSONArray(response.toString());
                    System.out.println("------------------------------------");



                    for(int i = 0; i < jsonArrayPrincipal.length();i++){

                        JSONObject unidad = jsonArrayPrincipal.getJSONObject(i);

                        String nombre = unidad.getString("usuario");

                        if(nombre.equalsIgnoreCase(nombreUsuarioConectado)){

                            String contra = unidad.getString("password");
                            int numJuegos = unidad.getJSONObject("stats").getInt("JuegosTotal");
                            int tiempoJugando = unidad.getJSONObject("stats").getInt("TiempoJugando");
                            String topJuego = unidad.getJSONObject("stats").getString("TopJuego");

                            List<String> topFive = new ArrayList<>();
                            for(int j = 0; j < unidad.getJSONObject("stats").getJSONArray("TopFive").length(); i++) {

                                topFive.add(unidad.getJSONObject("stats").getJSONArray("TopFive").getString(i));

                            }

                            int juegosCompletados = unidad.getJSONObject("stats").getInt("JuegosCompletadosTotal");
                            String emuFavorito = unidad.getJSONObject("stats").getString("EmuladorFavorito");

                            usuario = new Usuario(i,nombre,contra,numJuegos,tiempoJugando,topJuego, topFive, juegosCompletados, emuFavorito);
                        }



                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        request.add(jsonObjectRequest);
    }
}
