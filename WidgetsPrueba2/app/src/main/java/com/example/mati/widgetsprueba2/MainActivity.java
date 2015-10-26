package com.example.mati.widgetsprueba2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


final TextView lblMensaje = (TextView) findViewById(R.id.LblSeleccion);
final RadioGroup rg = (RadioGroup) findViewById(R.id.gruporb);
        rg.clearCheck();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
public void onCheckedChanged(RadioGroup group, int checkedId) {
        lblMensaje.setText("Opcion seleccionada: " + checkedId);

              /* Mejora el texto informativo
                String textoOpcion="";
                if( group.getCheckedRadioButtonId()==R.id.radio1)...... */
        }
        });

        }

}
