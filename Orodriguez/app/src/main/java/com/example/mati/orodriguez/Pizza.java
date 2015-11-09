package com.example.mati.orodriguez;

/**
 * Created by mati on 9/11/15.
 */
public class Pizza {

    int margarita=12;
    int quesos=15;
    int napolitana=18;
    String pizza;
    float total=0;
    int unidades;
    int extras;

    public Pizza(String n, Boolean l, int u, int e){
        this.pizza=n;
        if(n.compareTo("Margarita")==0)
            this.total+=u*margarita+e;
        else if(n.compareTo("4 Quesos")==0)
            this.total+=u*quesos+e;
        else if(n.compareTo("Napolitana")==0)
            this.total+=u*napolitana+e;
        if (!l)
            this.total+=this.total*0.1;
        this.unidades=u;
        this.extras=e;

    }

    public int getUnidades() {
        return unidades;
    }

    public int getExtras() {
        return extras;
    }

    public int getMargarita() {
        return margarita;
    }

    public int getQuesos() {
        return quesos;
    }

    public int getNapolitana() {
        return napolitana;
    }

    public float getTotal() {
        return total;
    }

    public String getPizza() {
        return pizza;
    }
    public int getBase(String n) {
        int base=0;
        if(n.compareTo("Margarita")==0)
            base=12;
        else if(n.compareTo("4 Quesos")==0)
            base=15;
        else if(n.compareTo("Napolitana")==0)
            base=18;
        return base;
    }
}
