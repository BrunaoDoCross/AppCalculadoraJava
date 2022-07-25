package com.brunofromcross.calculadorajava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    Calculadora calculadora;
    TextView texto;
    Button b;

    public void click(View view){
        texto = findViewById(R.id.linhaDeNum);
        calculadora = new Calculadora();
        b = (Button) view;
        if (!(isNumeric(b.getText().toString()))) {
            calculadora.setNum1(Float.parseFloat(texto.getText().toString()));
            if (b.getText().toString().equals("+")) {
                calculadora.setSinal("+");
                texto.setText(texto.getText()+"+");
            } else if (b.getText().toString().equals("-")) {
                calculadora.setSinal("-");
                texto.setText(texto.getText()+"-");
            } else if (b.getText().toString().equals("/")) {
                calculadora.setSinal("/");
                texto.setText(texto.getText()+"/");
            } else if (b.getText().toString().equals("*")) {
                calculadora.setSinal("*");
                texto.setText(texto.getText()+"*");
            } else {
                calculadora.setSinal("%");
                texto.setText(texto.getText()+"%");
            }
        }
        else{
            texto.setText(texto.getText()+b.getText().toString());
        }
    }

    public void igual(View view){
        calculadora.setSinal("=");
    }

}