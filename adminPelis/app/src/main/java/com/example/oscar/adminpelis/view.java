package com.example.oscar.adminpelis;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class view extends AppCompatActivity {

    private TextView name, author, generoText, vistaText;
    private Button volver;
    private PeliculasDbHelper pelisHelper;
    private Pelicula peli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Bundle dataLoad = getIntent().getExtras();
        final Pelicula pelicula = (Pelicula) dataLoad.getSerializable("pelicula");
        final Intent intent = new Intent(this, MainActivity.class);
        //  Activity form
        pelisHelper = new PeliculasDbHelper(this, "PeliculasDB", null, 1);

        volver = (Button)  findViewById(R.id.volver);
        name = (TextView) findViewById(R.id.vistaNombre);
        author = (TextView) findViewById(R.id.vistaAutor);
        generoText = (TextView) findViewById(R.id.vistaGenero);
        vistaText = (TextView) findViewById(R.id.vistaVisto);

        name.setText(pelicula.getName());
        author.setText(pelicula.getAuthor());

        if(pelicula.getVisto() == 1){
            vistaText.setText(" Sí");
        }else {
            vistaText.setText(" No");
        }

        generoText.setText(pelisHelper.findGenero(pelicula.getGenero()).getName());

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

}
