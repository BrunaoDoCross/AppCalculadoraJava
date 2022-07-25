package com.brunofromcross.calculadorajava;

public class Calculadora {
    private String conta;
    private Float num1;
    private Float num2;
    private String sinal = "";

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Float getNum1() {
        return num1;
    }

    public void setNum1(Float num1) {
        this.num1 = num1;
    }

    public Float getNum2() {
        return num2;
    }

    public void setNum2(Float num2) {
        this.num2 = num2;
    }

    public String getSinal() {
        return sinal;
    }

    public void setSinal(String sinal) {
        this.sinal = sinal;
    }

    public String mult(){
        return ""+(num1*num2);
    }

    public String somar(){
        return ""+(num1+num2);
    }

    public String div(){
        return ""+(num1/num2);
    }

    public String sub(){
        return ""+(num1-num2);
    }

    public String resto(){
        return ""+(num1%num2);
    }

}
