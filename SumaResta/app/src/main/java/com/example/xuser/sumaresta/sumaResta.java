package com.example.xuser.sumaresta;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class sumaResta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma_resta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final Button resolver= (Button)findViewById(R.id.resolver);
        final TextView salidaSuma= (TextView)findViewById(R.id.salidaSuma);
        final EditText op1=(EditText)findViewById(R.id.op1);
        final EditText op2=(EditText)findViewById(R.id.op2);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.clearCheck();
        resolver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (rg.getCheckedRadioButtonId() == R.id.suma) {
                    String total = op1.getText().toString();
                    showToast(total);
                }
            }
        });


    }

    protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
