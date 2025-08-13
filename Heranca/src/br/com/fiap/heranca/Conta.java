package br.com.fiap.heranca;

public class Conta {

    private int agencia;
    private int numero;
    private Pessoa titular;
    protected double saldo;

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

    public void depositar(double valor) {
        this.saldo = this.saldo + valor;
    }

    public void sacar(double valor) {
        if (this.saldo > valor) {
            this.saldo = this.saldo - valor;
        }
        else {
            //isso é errado
            System.out.println("Impossivel sacar, saldo insuficiente!");
        }
    }


}
