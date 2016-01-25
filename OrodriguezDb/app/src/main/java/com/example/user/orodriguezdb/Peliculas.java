package com.example.user.orodriguezdb;

import java.io.Serializable;

/**
 * Created by mati on 25/01/16.
 */
public class Peliculas implements Serializable{

    private int id;
    private  String nombre;
    private String autor;

    public Peliculas(int id, String nombre, String autor) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
