package com.example.mati.musica;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mati.holaxlomenos.R;

public class Pantalla2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo= (TextView)findViewById(R.id.miMensaje);
        final Button volverBtn= (Button)findViewById(R.id.miVolver);
        Bundle  miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));
        final String completarSaludo=miBundleRecoger.getString("TEXTO");
        volverBtn.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent vueltaIntent= new Intent();
                Bundle vueltaBundle=new Bundle();
                String mensajeDevuelto= "Devuelvo a Principal " + completarSaludo;
                vueltaBundle.putString("DEVUELTO", mensajeDevuelto);
                vueltaIntent.putExtras(vueltaBundle);
                setResult(RESULT_OK, vueltaIntent);
                finish();

            }

        });
        showAlert("No hay más perro que ladre");

    }

    protected void showAlert( CharSequence text) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(text);
        alert.setPositiveButton(android.R.string.ok, null);
        alert.show();
    }
}
