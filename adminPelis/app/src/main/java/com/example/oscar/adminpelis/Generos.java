package com.example.oscar.adminpelis;

import java.io.Serializable;

/**
 * Created by mati on 20/02/16.
 */
public class Generos implements Serializable{

    private int id;
    private String name;

    public Generos(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public Generos(){

    }

    public Generos(String name){
        this.name = name;
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
