package com.example.user.peliculasdb;

import java.io.Serializable;

/**
 * Created by mati on 20/02/16.
 */
public class Generos implements Serializable{

    private int id;
    private String name;

    public Generos(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Generos(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
