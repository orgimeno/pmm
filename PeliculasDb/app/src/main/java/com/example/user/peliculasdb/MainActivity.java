package com.example.user.peliculasdb;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private EditText name, author;
    private Button enviar;
    private  ListView listTree;
    private PeliculasDbHelper pelisHelper;

    private ArrayList <Pelicula> peliculas = new ArrayList<Pelicula>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        pelisHelper = new PeliculasDbHelper(this, "PeliculasDB", null, 1);
        final SQLiteDatabase pelisDb = pelisHelper.getWritableDatabase();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        showPelis();

        final TabHost tabs=(TabHost)findViewById(R.id.tabHost);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("mitab1");
        spec.setContent(R.id.formPeli);
        spec.setIndicator("nueva pelicula");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab2");
        spec.setContent(R.id.listPelisTab);
        spec.setIndicator("listar peliculas");
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

        //  Activity form
        enviar = (Button)  findViewById(R.id.enviar);
        name = (EditText) findViewById(R.id.nombreInput);
        author = (EditText) findViewById(R.id.autorInput);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pelicula peli = new Pelicula(author.getText().toString(),name.getText().toString());
                pelisHelper.inserPelicula(peli);
                showPelis();
                tabs.setCurrentTab(1);
            }
        });
        pelisDb.close();

        //  Activity List

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public  void showPelis(){
        List<Pelicula> listPeliculas = pelisHelper.listPeliculas();
        String [] peliculasString = new String[listPeliculas.size()];
        int i = 0;

        for (Pelicula p : listPeliculas) {
            String registry = "Author: " + p.getAuthor() + ", Nombre: " + p.getName();
            peliculasString[i] = registry;
            peliculas.add(p);
            i++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, peliculasString);
        listTree = (ListView) findViewById(R.id.listPelis);
        listTree.setAdapter(adapter);
        registerForContextMenu(listTree);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Intent intent;
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        int idItem=peliculas.get(index).getId();
        switch (item.getItemId()) {
            case R.id.opBorrar:
                pelisHelper.deleteItem(idItem);
                showPelis();
                return true;
            case R.id.opUpdate:
                intent = new Intent(MainActivity.this ,update.class);
                Bundle data = new Bundle();
                data.putSerializable("pelicula", peliculas.get(index));
                intent.putExtras(data);
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void changeToUpdate(){

    }


}
