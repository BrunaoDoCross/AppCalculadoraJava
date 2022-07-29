package com.brunofromcross.calculadorajava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

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

    TextView texto;
    String textoAux = "";
    Button b;
    Calculadora calculadora = new Calculadora();

    public void click(View view){

        texto = findViewById(R.id.linhaDeNum);
        b = (Button) view;

        if (!(isNumeric(b.getText().toString()))) {
            calculadora.setNum1(Float.parseFloat(texto.getText().toString().replace(',','.')));
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
            if(!(calculadora.getSinal().equals(""))){
                textoAux = textoAux+b.getText().toString();
                calculadora.setNum2(Float.parseFloat(textoAux));
            }
        }
    }

    public void igual(View view){
        texto = findViewById(R.id.linhaDeNum);
        texto.setText("");
        textoAux = "";
        if(calculadora.getSinal().equals("%")){
            calculadora.resto();
            texto.setText(calculadora.resto().replace('.', ','));
            limparVariaveis();
        }
        if(calculadora.getSinal().equals("-")){
            calculadora.sub();
            texto.setText(calculadora.sub().replace('.', ','));
            limparVariaveis();
        }
        if(calculadora.getSinal().equals("+")){
            calculadora.somar();
            texto.setText(calculadora.somar().replace('.', ','));
            limparVariaveis();
        }
        if(calculadora.getSinal().equals("*")){
            calculadora.mult();
            texto.setText(calculadora.mult().replace('.', ','));
            limparVariaveis();
        }
        if(calculadora.getSinal().equals("/")){
            calculadora.div();
            texto.setText(calculadora.div().replace('.', ','));
            limparVariaveis();
        }
    }

    private void limparVariaveis() {
        Calculadora calculadora = new Calculadora();
        TextView texto;
        String textoAux = "";
        Button b;
    }

    public void limparCalculadoraTela(View view){
        texto = findViewById(R.id.linhaDeNum);
        calculadora = new Calculadora();
        texto.setText("");
        textoAux = "";
    }
}