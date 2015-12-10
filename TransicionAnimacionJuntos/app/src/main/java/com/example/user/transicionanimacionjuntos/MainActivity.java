package com.example.user.transicionanimacionjuntos;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends Activity {
    AnimationDrawable animacion;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imagenTransition = new ImageView(this);
        setContentView(imagenTransition);
        TransitionDrawable mi_transicion = (TransitionDrawable)
                getResources().getDrawable(R.drawable.transicion);
        imagenTransition.setImageDrawable(mi_transicion);
        mi_transicion.startTransition(2000);
        animacion = (AnimationDrawable) getResources().getDrawable(R.anim.animacion);
        //Creamos una vista que contendrá una imagen
        ImageView imagen = new ImageView(this);
        //Le ponemos color de fondo
        imagen.setBackgroundColor(Color.WHITE);
        //Cargamos en lugar de una imagen, una animación.
        imagen.setImageDrawable(animacion);
        setContentView(imagen);
    }

    public boolean onTouchEvent(MotionEvent evento) {
        //Al realizar una pulsación en pantalla
        if (evento.getAction() == MotionEvent.ACTION_DOWN) {
            //Ponemos en marcha la animación
            animacion.start();
            return true;
        }
        return super.onTouchEvent(evento);
    }
}
