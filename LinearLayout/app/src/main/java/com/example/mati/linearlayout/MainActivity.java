package com.example.mati.linearlayout;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button seleccionar= (Button)findViewById(R.id.buttonSelect);
        final Button borrar= (Button)findViewById(R.id.buttonDelete);
        final TextView texto = (TextView)findViewById(R.id.textView);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.clearCheck();
        seleccionar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (rg.getCheckedRadioButtonId() == R.id.radioButtonBlue)
                    texto.setBackgroundColor(Color.BLUE);
                else if (rg.getCheckedRadioButtonId() == R.id.radioButtonGreen)
                    texto.setBackgroundColor(Color.GREEN);
                else if (rg.getCheckedRadioButtonId() == R.id.radioButtonRed)
                    texto.setBackgroundColor(Color.RED);
                else
                    texto.setBackgroundColor(Color.BLACK);
            }
        });
        borrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showToast("cjgfr");
            }
        });
    }

    protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
