package com.example.ravin.emultimate;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ravin on 14/05/2018.
 */

public class Usuario implements Serializable{

    private int id;
    private String nombre;
    private String contraseña;
    private int numJuegos;
    private int minutosJugados;
    private String juegoFavorito;
    private List<String> topFive;
    private int numJuegosCompletados;
    private String emuladorFavorito;

    public Usuario(int id, String nom, String contra, int num, int min, String juego, List<String> top, int comple, String emu){
        this.id = id;
        nombre = nom;
        contraseña = contra;
        numJuegos = num;
        minutosJugados = min;
        juegoFavorito = juego;
        topFive = top;
        numJuegosCompletados = comple;
        emuladorFavorito = emu;
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getNumJuegos() {
        return numJuegos;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public String getJuegoFavorito() {
        return juegoFavorito;
    }

    public List<String> getTopFive() {
        return topFive;
    }

    public int getNumJuegosCompletados() {
        return numJuegosCompletados;
    }

    public String getEmuladorFavorito() {
        return emuladorFavorito;
    }

}
