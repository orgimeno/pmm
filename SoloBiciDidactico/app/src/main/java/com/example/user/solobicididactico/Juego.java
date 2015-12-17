package com.example.user.solobicididactico;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Juego extends Activity {
    @Override
    private Button bJuego;
    // BICI //
    private Grafico bici;
    private int giroBici;			//Incremento en la dirección de la bici
    private float aceleracionBici;	//Aumento de velocidad en la bici
    private static final int PASO_GIRO_BICI = 5;
    private static final float PASO_ACELERACION_BICI = 0.5f;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);


        //Botón y escuchador para la pantalla "Juego"
        //Al hacer click en este botón llamamos al método lanzarJuego()
        bJuego = (Button) findViewById(R.id.Boton01);
        bJuego.setOnClickListener(new OnClickListener(){
            public void onClick(View view) {
                lanzarJuego();
            }
        });

        //Método que activa la pantalla Juego
        public void lanzarJuego(){
            Intent i = new Intent(this, Juego.class);
            startActivity(i);
        }

    }
}