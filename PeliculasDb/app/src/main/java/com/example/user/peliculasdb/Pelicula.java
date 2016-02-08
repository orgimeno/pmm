package com.example.user.peliculasdb;

/**
 * Created by mati on 8/02/16.
 */
public class Pelicula {

    private int id;
    private String author;
    private String name;

    public Pelicula(int id, String author, String name) {
        this.id = id;
        this.author = author;
        this.name = name;
    }

    public Pelicula(String author, String name) {
        this.author = author;
        this.name = name;
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
}
