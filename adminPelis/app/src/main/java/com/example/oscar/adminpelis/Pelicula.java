package com.example.oscar.adminpelis;

import java.io.Serializable;

/**
 * Created by mati on 8/02/16.
 */
public class Pelicula implements Serializable {

    private int id;
    private String author;
    private String name;

    private int visto;

    private int genero;

    public Pelicula(int id, String author, String name, int genero, int visto) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.genero = genero;
        this.visto = visto;
    }

    public Pelicula(String author, String name, int genero, int visto) {
        this.author = author;
        this.name = name;
        this.genero = genero;
        this.visto = visto;
    }

    public Pelicula() {

    }

    //GET and SET
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getVisto() {
        return visto;
    }

    public void setVisto(int visto) {
        this.visto = visto;
    }

}
