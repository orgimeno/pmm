package institutoserpis.org.proysumaresta;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class Resultado extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle bundle = getIntent().getExtras();
        Object bundleObject = bundle.get("resultado");
        String resultado = bundleObject.toString();

        final TextView textViewResultado = (TextView) findViewById(R.id.resultado);

        textViewResultado.setText(resultado);
    }
}
