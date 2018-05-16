package com.example.ravin.emultimate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
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

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "http://localhost:8080/Users/ravin/Desktop/emusocialdatos.json";
    EditText etUsuario, etPassword;
    CardView cvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        cvLogin = findViewById(R.id.cvLogin);
    }

    public void login(View v){

        RequestQueue request = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArrayPrincipal = new JSONArray(response.toString());
                    System.out.println("------------------------------------");

                    for(int i = 0; i < jsonArrayPrincipal.length();i++){

                        JSONObject unidad = jsonArrayPrincipal.getJSONObject(i);

                        String usuario = unidad.get("usuario").toString();
                        String pass = unidad.get("password").toString();

                        if(usuario.equalsIgnoreCase(etUsuario.getText().toString()) && pass.equalsIgnoreCase(etPassword.getText().toString())){

                            Intent intent = new Intent(getApplicationContext(), PerfilActivity.class);
                            intent.putExtra("usuario", usuario);
                            intent.putExtra("password", pass);
                            startActivity(intent);
                        }
                    }

                    Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrectas", Toast.LENGTH_LONG).show();


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
