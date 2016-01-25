package com.example.user.orodriguezdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by mati on 25/01/16.
 */
public class PeliculasDbHelper extends SQLiteOpenHelper{
    //Sentencia SQL para crear la tabla de Destinos
    String sqlCreate = "CREATE TABLE IF NOT EXISTS `peliculas` (" +
            "  `id` INTEGER NOT NULL PRIMARY KEY," +
            "  `autor` TEXT NOT NULL," +
            "  `nombre` TEXT NOT NULL" +
            "  );";


    public PeliculasDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}