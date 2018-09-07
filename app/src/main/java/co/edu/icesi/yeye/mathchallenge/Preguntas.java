package co.edu.icesi.yeye.mathchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Preguntas extends AppCompatActivity {

    public static final int TOTAL_PREGUNTAS = 5;

    private int acumulado;
    private int preguntaActual;

    private TextView tv_nombrePregunta;

    private EditText et_operandoUno;
    private EditText et_operador;
    private EditText et_operandoDos;

    private RadioGroup radio_answers;
    private RadioButton radio_answerUno;
    private RadioButton radio_answerDos;
    private RadioButton radio_answerTres;
    private RadioButton radio_answerCuatro;

    private Button btn_siguiente;

    private RandomOperation preguntaRandom;

    private long ti;
    private long tf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        tv_nombrePregunta = findViewById(R.id.tv_preguntaActual);

        et_operandoUno = findViewById(R.id.et_operandoUno);
        et_operador = findViewById(R.id.et_operador);
        et_operandoDos = findViewById(R.id.et_operandoDos);

        btn_siguiente = findViewById(R.id.btn_siguiente);


        acumulado = 0;
        preguntaActual = 1;


        tv_nombrePregunta.setText("PREGUNTA " + preguntaActual);

        preguntaRandom = new RandomOperation();

        et_operandoUno.setText(preguntaRandom.getOperandoUno() + "");
        et_operador.setText(preguntaRandom.getOperador() + "");
        et_operandoDos.setText(preguntaRandom.getOperandoDos() + "");


        inicializarRadioButtons(preguntaRandom);

        iniciar();
        btn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int selectedButtonId = radio_answers.getCheckedRadioButtonId();
                RadioButton resp = findViewById(selectedButtonId);


                Log.e("asdas", resp.getText() + "------"
                        + preguntaRandom.getRespuestaReal());
                if (Double.parseDouble(resp.getText().toString())==preguntaRandom.getRespuestaReal()) {
                    Toast.makeText(Preguntas.this, "BIEN", Toast.LENGTH_SHORT);
                    acumulado++;
                } else
                    Toast.makeText(Preguntas.this, "MAL", Toast.LENGTH_SHORT);

                if (preguntaActual == 5) {
                    Intent intent = new Intent(Preguntas.this, Resumen.class);
                    Log.e("asdas", acumulado+"");
                    terminar();

                    intent.putExtra("Acertadas", acumulado);
                    intent.putExtra("Tiempo", tf-ti);

                    finish();

                    startActivity(intent);

                } else
                    refrescar();
            }
        });


    }

    public void refrescar() {


        preguntaActual++;


        tv_nombrePregunta.setText("PREGUNTA " + preguntaActual);

        preguntaRandom = new RandomOperation();

        et_operandoUno.setText(preguntaRandom.getOperandoUno() + "");
        et_operador.setText(preguntaRandom.getOperador() + "");
        et_operandoDos.setText(preguntaRandom.getOperandoDos() + "");


        inicializarRadioButtons(preguntaRandom);
    }

    private void inicializarRadioButtons(RandomOperation preguntaRandom) {
        radio_answers = findViewById(R.id.radio_answers);

        radio_answerUno = findViewById(R.id.radio_uno);
        radio_answerDos = findViewById(R.id.radio_dos);
        radio_answerTres = findViewById(R.id.radio_tres);
        radio_answerCuatro = findViewById(R.id.radio_cuatro);

        ArrayList<Double> respuestas = preguntaRandom.getRespuestas();

        DecimalFormat formato2 = new DecimalFormat("#.##");

        radio_answerUno.setText(formato2.format(respuestas.get(0)) + "");
        radio_answerDos.setText(formato2.format(respuestas.get(1)) + "");
        radio_answerTres.setText(formato2.format(respuestas.get(2)) + "");
        radio_answerCuatro.setText(formato2.format(respuestas.get(3)) + "");


    }

    public void iniciar(){
        ti=System.currentTimeMillis()/1000;

    }

    public void terminar(){
        tf=System.currentTimeMillis()/1000;

    }
}
