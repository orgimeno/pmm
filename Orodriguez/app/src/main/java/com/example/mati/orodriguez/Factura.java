package com.example.mati.orodriguez;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class Factura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        final EditText nombrePizza= (EditText) findViewById(R.id.nombreText);
        final EditText base = (EditText) findViewById(R.id.baseText);
        final EditText extras = (EditText) findViewById(R.id.extrasText);
        final EditText unidades = (EditText) findViewById(R.id.unidadesText);
        final EditText envio = (EditText) findViewById(R.id.envioText);
        final EditText cfin = (EditText) findViewById(R.id.costeText);

        Bundle bundle = getIntent().getExtras();
        Object bundleObject = bundle.get("pizzaNombre");
        Object bundleObject1 = bundle.get("pizzaTotal");
        Object bundleObject2 = bundle.get("pizzaBase");
        Object bundleObject3 = bundle.get("pizzaUnidades");
        Object bundleObject4 = bundle.get("pizzaExtras");
        Object bundleObject5 = bundle.get("local");
        String n = bundleObject.toString();
        String total = bundleObject1.toString();
        String baseP = bundleObject2.toString();
        String unidadesV = bundleObject3.toString();
        String extrasV = bundleObject4.toString();
        String localV = bundleObject5.toString();
        ImageView imagen = (ImageView) findViewById(R.id.iamgeFactura);
        if(n.compareTo("Margarita")==0)
            imagen.setImageResource(R.drawable.pizza1);
        else if(n.compareTo("4 Quesos")==0)
            imagen.setImageResource(R.drawable.pizza2);
        else if(n.compareTo("Napolitana")==0)
            imagen.setImageResource(R.drawable.pizza3);
        if(localV=="True")
            envio.setText("En local");
        else
            envio.setText("A Domicilio");
        nombrePizza.setText(n);
        cfin.setText(total);
        base.setText(baseP);
        extras.setText(extrasV);
        unidades.setText(unidadesV);

    }

    protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


}
