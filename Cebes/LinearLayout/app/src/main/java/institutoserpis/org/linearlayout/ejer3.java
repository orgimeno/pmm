package institutoserpis.org.linearlayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class ejer3 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer3);

        final ToggleButton toggleButtonRed = (ToggleButton) findViewById(R.id.toggleButtonRed);
        final ToggleButton toggleButtonGreen = (ToggleButton) findViewById(R.id.toggleButtonGreen);
        final ToggleButton toggleButtonBlue = (ToggleButton) findViewById(R.id.toggleButtonBlue);
        final Button buttonAnterior = (Button) findViewById(R.id.buttonAnterior);
        final TextView textView = (TextView) findViewById(R.id.textViewColor);

        toggleButtonRed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView.setBackgroundColor(Color.RED);
                } else {
                    textView.setBackgroundColor(Color.BLACK);
                }
            }
        });

        toggleButtonGreen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView.setBackgroundColor(Color.GREEN);
                } else {
                    textView.setBackgroundColor(Color.BLACK);
                }
            }
        });

        toggleButtonBlue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView.setBackgroundColor(Color.BLUE);
                } else {
                    textView.setBackgroundColor(Color.BLACK);
                }
            }
        });

        buttonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent(ejer3.this, ejer2.class);
                startActivity(i);
            }
        });
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
