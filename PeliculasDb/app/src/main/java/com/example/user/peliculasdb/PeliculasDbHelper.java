package com.example.user.peliculasdb;

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
    String sqlCreate = "CREATE TABLE `peliculas` (" +
            "  `id` INTEGER NOT NULL PRIMARY KEY," +
            "  `author` TEXT NOT NULL," +
            "  `name` TEXT NOT NULL" +
            "  `genero` INTEGER NOT NULL" +
            "  ); " +
            "CREATE TABLE `generos` (" +
            "  `id` INTEGER NOT NULL PRIMARY KEY," +
            "  `name` TEXT NOT NULL," +
            "  );";

    String sqlInsert = "Insert into generos set(name) values ('horror')";

    //TODO more tables



    public PeliculasDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
        db.execSQL(sqlInsert);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inserPelicula(Pelicula peli){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nombre", peli.getName());
        values.put("autor", peli.getAuthor());
        values.put("genero", peli.getGenero());
        db.insert("peliculas", null, values);

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
                pl.setName(c.getString(c.getColumnIndex("nombre")));
                pl.setAuthor(c.getString(c.getColumnIndex("autor")));
                peliculas.add(pl);
            } while (c.moveToNext());
        }

        return peliculas;
    }
    public List<Generos> listGeneros() {
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        String selectQuery = "SELECT  * FROM peliculas";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Pelicula pl = new Pelicula();
                pl.setId(c.getInt(c.getColumnIndex("id")));
                pl.setName(c.getString(c.getColumnIndex("nombre")));
                pl.setAuthor(c.getString(c.getColumnIndex("autor")));
                peliculas.add(pl);
            } while (c.moveToNext());
        }

        return peliculas;
    }

    public void deleteItem(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM peliculas WHERE id=" + id);
    }

    public void updateItem(Pelicula peli){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre",peli.getName());
        valores.put("autor",peli.getAuthor());

        //Actualizamos el registro en la base de datos
        db.update("peliculas", valores, "id=" + peli.getId(), null);
    }

}