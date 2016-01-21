package com.example.user.testbbdd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Abrimos la base de datos en modo escritura
        ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this, "DBClientes", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        SQLiteDatabase bd = cliBDh.getWritableDatabase();

        //En caso de abrir de forma correcta la base de datos
        if (bd!=null) {
        		//Ejemplo de utilización del método insert()
        		//Creamos el registro que queremos insertar utilizando un objeto ContentValues
        		ContentValues nuevoRegistro = new ContentValues();
        		nuevoRegistro.put("nombre","oscaryny");
        		nuevoRegistro.put("telefono", "101010");
        		//Insertamos el registro en la base de datos
        		//El primer parámetro es el nombre de la tabla donde insertaremos.
        		//El segundo parámetro solo sirve en caso de introducir un registro vacio
        		//El tercer paráemtro es el objeto ContentValues que contiene el registro a insertar
        		bd.insert("Clientes", null, nuevoRegistro);

        		//Ejemplo de utilización del método update()
        		//Establecemos los campos-valores que vamos a actualizar
        		ContentValues valores = new ContentValues();
        		valores.put("telefono", "101010XX");
        		//Actualizamos el registro en la base de datos
        		//El tercer argumento es la condición del UPDATE tal como lo haríamos en la cláusula
        		//WHERE en una sentencia SQL normal.
        		//El cuarto argumento son partes variables de la sentencia SQL que aportamos en un
        		//vector de valores aparte
        		String[] args = new String[]{"cli1", "cli2"};
        		bd.update("Clientes", valores, "nombre=? OR nombre=?", args);

        		//Ejemplo de utilización del método delete()
        		//Eliminamos el registro del cliente 'cli2'
        		String[] args2 = new String[]{"cli2"};
        		bd.delete("Clientes", "nombre=?", args2);

        		//Ejemplo Select
        		String[] args3 = new String[]{"oscaryny"};
        		//Cursor c = bd.rawQuery("SELECT nombre,telefono FROM Clientes WHERE nombre=? ", args3);
				Cursor c = bd.rawQuery("SELECT nombre,telefono FROM Clientes ",null);
				//bd.execSQL("Drop database DBClientes");
        		//Ejemplo Select2
        		String[] campos = new String[] {"nombre", "telefono"};
        		String[] args4 = new String[] {"cli1"};


        		//Cursor c = bd.query("Clientes", campos, "nombre=?", args4, null, null, null);
        		//Nos aseguramos de que exista al menos un registro
        		if (c.moveToFirst()) {
        			//Recorremos el cursor hasta que no haya más registros
        			do {
        				String nombreCli = c.getString(0);
        				String telefonoCli = c.getString(1);
						String datosCliente=nombreCli + "  : "+telefonoCli;
						Toast.makeText(this, datosCliente, Toast.LENGTH_SHORT).show();
					} while (c.moveToNext());
        		}


            //Cerramos la base de datos
            bd.close();
        } //del if
    }

}