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
                lblMensaje.setText("Opcion seleccionada: " + group.getCheckedRadioButtonId() + "id: " + R.id.radio1);

                // Mejora el texto informativo
                String textoOpcion = "";
                if (group.getCheckedRadioButtonId() == R.id.radio1)
                    textoOpcion = "Ha seleccionado la opción 1";
                else
                    textoOpcion = "Ha seleccionado la opción 2";
                lblMensaje.setText(textoOpcion);
            }
        });

    }

}
