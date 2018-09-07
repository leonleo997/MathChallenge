package co.edu.icesi.yeye.mathchallenge;

import android.widget.Switch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomOperation {

    public final static String[] OPERADORES = {"+", "-", "*", "/"};

    public int operandoUno;
    public int operandoDos;
    public int operador;

    public double respuestaReal;

    public ArrayList<Double> respuestas;

    public RandomOperation() {
        Random r = new Random();
        operandoUno = r.nextInt(100);
        operandoDos = r.nextInt(100);
        operador = r.nextInt(4);

        switch (operador){
            case 0:
                respuestaReal = operandoUno + operandoDos;
                break;

            case 1:
                respuestaReal = operandoUno - operandoDos;
                break;

            case 2:
                respuestaReal = operandoUno * operandoDos;
                break;

            case 3:
                respuestaReal = operandoUno / operandoDos;
                break;
        }

        respuestas=new ArrayList<Double>();

        respuestas.add(respuestaReal);
        respuestas.add(r.nextDouble()+r.nextInt(100));
        respuestas.add(r.nextInt(100)+0.0);
        respuestas.add(r.nextDouble()+r.nextInt(100));

        Collections.shuffle(respuestas);
    }

    public boolean isCorrect(double respuesta) {
        boolean isCorrect;

        if(respuesta==respuestaReal)
            isCorrect=true;
        else
            isCorrect=false;

        return isCorrect;
    }



    public int getOperandoUno() {
        return operandoUno;
    }

    public void setOperandoUno(int operandoUno) {
        this.operandoUno = operandoUno;
    }

    public int getOperandoDos() {
        return operandoDos;
    }

    public void setOperandoDos(int operandoDos) {
        this.operandoDos = operandoDos;
    }

    public String getOperador() {
        String op="";
        switch (operador){
            case 0:
                op="+";
                break;

            case 1:
                op="-";
                break;

            case 2:
                op="*";
                break;

            case 3:
                op="/";
                break;
        }
        return op;
    }

    public void setOperador(int operador) {
        this.operador = operador;
    }

    public ArrayList<Double> getRespuestas() {
        return respuestas;
    }

    public double getRespuestaReal() {
        return respuestaReal;
    }
}
