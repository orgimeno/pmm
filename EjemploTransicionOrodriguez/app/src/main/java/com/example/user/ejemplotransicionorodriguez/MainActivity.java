package com.example.user.ejemplotransicionorodriguez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imagen = new ImageView(this);
        setContentView(imagen);
        TransitionDrawable mi_transicion = (TransitionDrawable)
                getResources().getDrawable(R.drawable.transicion);
        imagen.setImageDrawable(mi_transicion);
        mi_transicion.startTransition(2000);
    }
}
