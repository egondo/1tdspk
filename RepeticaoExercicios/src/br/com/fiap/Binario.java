package br.com.fiap;

public class Binario {

    private long numero;

    public Binario(long numero) {
        this.numero = numero;
    }

    public long getNumero() {
        return numero;
    }

    public long getDecimal() {
        long aux = numero;
        long soma = 0;
        long pot2 = 1;
        while (aux != 0) {
            long resto = aux % 10;
            soma = soma + resto * pot2;
            pot2 = pot2 * 2;
            aux = aux / 10;
        }
        return soma;
    }
}
