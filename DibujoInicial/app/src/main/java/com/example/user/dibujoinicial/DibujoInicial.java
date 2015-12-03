package com.example.user.dibujoinicial;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class DibujoInicial extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }

    class MiDibujo extends View {
        public MiDibujo(Context c){

            super(c);
        }

        protected void onDraw(Canvas lienzo){


            Paint miPincel= new Paint();
            miPincel.setColor(Color.RED);
            miPincel.setStyle(Paint.Style.STROKE);
            for (int i=0; i<500; i+=1)
                lienzo.drawCircle(500,800,30+i,miPincel);

            Paint miPincel1= new Paint();
            miPincel1.setColor(Color.GREEN);
            miPincel1.setStyle(Paint.Style.STROKE);
            for (int j=0; j<200; j+=10) {
                lienzo.drawCircle(1000 + j, 900, 700, miPincel1);
                System.out.println("holaaa");
            }

            miPincel.setTextSize(60);
            lienzo.drawText("MI CÍRCULO", 400, 900, miPincel);

        }
    }

}
