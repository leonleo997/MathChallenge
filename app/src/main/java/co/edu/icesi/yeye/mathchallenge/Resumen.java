package co.edu.icesi.yeye.mathchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Resumen extends AppCompatActivity {

    private EditText resultado;
    private EditText tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        resultado=findViewById(R.id.respuesta);
        resultado.setText(getIntent().getExtras().get("Acertadas")+"");

        tiempo=findViewById(R.id.tiempo);
        tiempo.setText(getIntent().getExtras().get("Tiempo")+"");


    }
}
