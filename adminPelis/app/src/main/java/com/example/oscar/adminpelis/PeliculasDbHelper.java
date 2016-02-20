package com.example.oscar.adminpelis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mati on 25/01/16.
 */
public class PeliculasDbHelper extends SQLiteOpenHelper {
    //Sentencia SQL para crear la tabla de Destinos
    String sqlPeliculas = "CREATE TABLE `peliculas` (" +
            "  `id` INTEGER NOT NULL PRIMARY KEY," +
            "  `author` TEXT NOT NULL," +
            "  `name` TEXT NOT NULL," +
            "  `genero` INTEGER NULL" +
            "  ); ";
     String sqlGeneros="CREATE TABLE `generos` (" +
            "  `id` INTEGER NOT NULL PRIMARY KEY," +
            "  `name` TEXT NOT NULL" +
            "  );";

    public PeliculasDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlPeliculas);
        db.execSQL(sqlGeneros);
        inserGenero(db, new Generos("Horror"));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inserPelicula(Pelicula peli){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", peli.getName());
        values.put("author", peli.getAuthor());
        //values.put("genero", peli.getGenero().getId());
        db.insert("peliculas", null, values);

    }

    public void inserGenero(SQLiteDatabase db, Generos gen){
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", gen.getName());
        db.insert("generos", null, values);

    }

    public List<Pelicula> listPeliculas() {
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        String selectQuery = "SELECT  * FROM peliculas";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Pelicula pl = new Pelicula();
                pl.setId(c.getInt(c.getColumnIndex("id")));
                pl.setName(c.getString(c.getColumnIndex("name")));
                pl.setAuthor(c.getString(c.getColumnIndex("author")));
                peliculas.add(pl);
            } while (c.moveToNext());
        }

        return peliculas;
    }

    public Cursor returnGeneros(){
        String selectQuery = "SELECT  * FROM generos";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        return c;
    }

    public List<Generos> listGeneros() {
        List<Generos> generos = new ArrayList<Generos>();
        String selectQuery = "SELECT  * FROM generos";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Generos gn = new Generos();
                gn.setId(c.getInt(c.getColumnIndex("id")));
                gn.setName(c.getString(c.getColumnIndex("name")));
                generos.add(gn);
            } while (c.moveToNext());
        }

        return generos;
    }

    public void deleteItem(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM peliculas WHERE id=" + id);
    }

    public void updateItem(Pelicula peli){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("name",peli.getName());
        valores.put("author",peli.getAuthor());

        //Actualizamos el registro en la base de datos
        db.update("peliculas", valores, "id=" + peli.getId(), null);
    }

}