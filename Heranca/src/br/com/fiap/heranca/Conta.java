package br.com.fiap.heranca;

public class Conta {

    private int agencia;
    private int numero;
    private Pessoa titular;
    private double saldo;

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }
}
