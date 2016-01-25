package institutoserpis.org.proysumaresta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonCalcular = (Button) findViewById(R.id.buttonCalcular);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        final EditText textOperando1 = (EditText) findViewById(R.id.editText1);
        final EditText textOperando2 = (EditText) findViewById(R.id.editText2);
        final TextView textViewResultado = (TextView) findViewById(R.id.textViewResultado);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadio = radioGroup.getCheckedRadioButtonId();

                float op1 = 0;
                float op2 = 0;
                float resultado = 0;

                try {
                    op1 = Float.parseFloat(textOperando1.getText().toString());
                    op2 = Float.parseFloat(textOperando2.getText().toString());

                    if (selectedRadio == -1) {
                        showToast("Debe seleccionar un operador");
                    } else {
                        switch (selectedRadio) {
                            case R.id.radioButtonSuma:
                                resultado = op1 + op2;
                                //textViewResultado.setText(Float.toString(resultado));
                                break;
                            case R.id.radioButtonResta:
                                resultado = op1 - op2;
                                //textViewResultado.setText(Float.toString(resultado));
                                break;
                            case R.id.radioButtonMultiplicar:
                                resultado = op1 * op2;
                                //textViewResultado.setText(Float.toString(resultado));
                                break;
                            case R.id.radioButtonDividir:
                                resultado = op1 / op2;
                                //textViewResultado.setText(Float.toString(resultado));
                                break;
                        }

                        Intent i = new Intent(MainActivity.this, Resultado.class);
                        i.putExtra("resultado", resultado);
                        startActivity(i);
                    }
                } catch (Exception e){
                    showToast("El operando 1 y/ó 2 no son válidos");
                }
            }
        });

    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
