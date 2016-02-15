package com.example.user.peliculasdb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class update extends Activity {
    private EditText name, author;
    private Button enviar1;
    private ListView listTree;
    private PeliculasDbHelper pelisHelper;
    private Pelicula peli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Bundle dataLoad = getIntent().getExtras();
        final Pelicula pelicula = (Pelicula) dataLoad.getSerializable("pelicula");
        final Intent intent = new Intent(this, MainActivity.class);
        //  Activity form
        enviar1 = (Button)  findViewById(R.id.enviar1);
        name = (EditText) findViewById(R.id.nombreInput1);
        author = (EditText) findViewById(R.id.autorInput1);

        name.setText(pelicula.getName());
        author.setText(pelicula.getAuthor());
        pelisHelper = new PeliculasDbHelper(this, "PeliculasDB", null, 1);
        enviar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                peli = new Pelicula(pelicula.getId(), author.getText().toString(), name.getText().toString());
                pelisHelper.updateItem(peli);
                startActivity(intent);
            }
        });
        /*enviar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(update.this, name.getText() + "", Toast.LENGTH_SHORT).show();
                peli = new Pelicula(pelicula.getId(), author.getText().toString(), name.getText().toString());
                Toast.makeText(update.this, peli.getId() + "", Toast.LENGTH_SHORT).show();
                pelisHelper.updateItem();
            }
        });*/
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
