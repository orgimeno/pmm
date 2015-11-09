package com.example.mati.orodriguez;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner miSpinner;
    final static String pizzas[] = {"Margarita", "Napolitana", "4 Quesos"};
    String pizza="";
    Boolean enLocal=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miSpinner = (Spinner) findViewById(R.id.spinner1);
        final Button total= (Button)findViewById(R.id.total);
        final EditText unidades=(EditText)findViewById(R.id.unidades);
        final EditText salida=(EditText)findViewById(R.id.totalValor);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.clearCheck();
        final CheckBox grande = (CheckBox) findViewById(R.id.grande);
        final CheckBox ingred = (CheckBox) findViewById(R.id.ingred);
        final CheckBox queso = (CheckBox) findViewById(R.id.queso);

        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, pizzas);

        miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); /* MIRAR BIEN( es diferente al ListaView) */
        miSpinner.setAdapter(miAdaptador);
        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /*evento distinto al ListView */
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                pizza = pizzas[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                String mensaje = "";
                mensaje = "Selecciona una pizza";
                showToast(mensaje);
            }
        });

        total.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (rg.getCheckedRadioButtonId() == R.id.local) {
                    enLocal = true;
                } else {
                    enLocal = false;
                }
                int ud = Integer.parseInt(unidades.getText().toString());
                int extras=0;
                if (grande.isChecked())
                    extras++;
                if (ingred.isChecked())
                    extras++;
                if (queso.isChecked())
                    extras++;
                Pizza pizzaObj = new Pizza(pizza, enLocal, ud, extras);
                salida.setText(Float.toString(pizzaObj.getTotal()));
                Intent i = new Intent(MainActivity.this, Factura.class);
                i.putExtra("pizzaTotal", pizzaObj.getTotal());
                i.putExtra("pizzaNombre", pizzaObj.getPizza());
                i.putExtra("pizzaExtras", pizzaObj.getExtras());
                i.putExtra("pizzaUnidades", pizzaObj.getUnidades());
                i.putExtra("pizzaBase", pizzaObj.getBase(pizza));
                i.putExtra("local", enLocal);
                startActivity(i);
            }
        });
    }
    protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
