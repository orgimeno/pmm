package com.example.user.peliculasdb;

import java.io.Serializable;

/**
 * Created by mati on 8/02/16.
 */
public class Pelicula implements Serializable {

    private int id;
    private String author;
    private String name;


    private Generos genero;

    public Pelicula(int id, String author, String name, Generos genero) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.genero = genero;
    }

    public Pelicula(int id, String author, String name) {
        this.id = id;
        this.author = author;
        this.name = name;
    }

    public Pelicula(String author, String name, Generos genero) {
        this.author = author;
        this.name = name;
        this.genero = genero;
    }

    public Pelicula(String author, String name) {
        this.author = author;
        this.name = name;
        this.genero = genero;
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

    public Generos getGenero() {
        return genero;
    }

    public void setGenero(Generos genero) {
        this.genero = genero;
    }

}
