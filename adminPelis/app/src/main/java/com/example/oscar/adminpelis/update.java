package com.example.oscar.adminpelis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import java.util.List;

/**
 * Created by Oscar on 20/02/2016.
 */
public class update extends Activity {
    private EditText name, author;
    private Button enviar1;
    private ListView listTree;
    private PeliculasDbHelper pelisHelper;
    private Pelicula peli;
    private Spinner genreSpinner;
    private SimpleCursorAdapter genreSpinnerAdapter;
    private Generos genero;
    private int idGenero;
    private String textGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Bundle dataLoad = getIntent().getExtras();
        final Pelicula pelicula = (Pelicula) dataLoad.getSerializable("pelicula");
        final Intent intent = new Intent(this, MainActivity.class);
        //  Activity form
        pelisHelper = new PeliculasDbHelper(this, "PeliculasDB", null, 1);

        enviar1 = (Button)  findViewById(R.id.enviar1);
        name = (EditText) findViewById(R.id.nombreInput1);
        author = (EditText) findViewById(R.id.autorInput1);

        name.setText(pelicula.getName());
        author.setText(pelicula.getAuthor());

        setSpinner(pelicula);

        enviar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                peli = new Pelicula(pelicula.getId(), author.getText().toString(), name.getText().toString(), idGenero);
                pelisHelper.updateItem(peli);
                startActivity(intent);
            }
        });
    }

    public void setSpinner(Pelicula pelicula){
        final List<Generos> generos = pelisHelper.listGeneros();
        Generos genero = new Generos(69, "fail");
        genreSpinner = (Spinner)findViewById(R.id.GenreSpinnerUpdate);
        genreSpinnerAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_spinner_item,//Layout simple
                pelisHelper.returnGeneros(),//Todos los registros
                new String[]{"name"},//Mostrar solo el nombre
                new int[]{android.R.id.text1},//View para el nombre
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);//Observer para el refresco
        /*
        Seteando Adaptador de GenreSpinner
         */
        genreSpinner.setAdapter(genreSpinnerAdapter);
        for (int i = 0; i<generos.size();i++){
            if(generos.get(i).getId() == pelicula.getGenero())
                genero = new Generos (generos.get(i).getId(), generos.get(i).getName());
        }
        //genreSpinner.setSelection(getIndex(genreSpinner, genero.getName()));
        genreSpinner.setSelection(genero.getId()-1);

        genreSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idGenero = generos.get(position).getId();
                textGenero = generos.get(position).getName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

    }

    private int getIndex(Spinner spinner, String myString){

        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).equals(myString)){
                index = i;
            }else {
                Log.v(myString+"bbbbbbb", spinner.getItemAtPosition(i)+" aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }
        }
        return index;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
