package com.example.user.bitmapdrawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private BitmapDrawable miImgen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public class EjemploView extends View {
        public EjemploView(Context contexto){
            super(contexto);
            Resources res = contexto.getResources();
            miImgen = (BitmapDrawable) res.getDrawable(R.drawable)
        }
    }
}
