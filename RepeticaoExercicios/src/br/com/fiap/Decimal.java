package br.com.fiap;

public class Decimal {

    private long numero;

    public Decimal(long numero) {
        this.numero = numero;
    }

    public long getBinario() {
        long aux = numero;
        long soma = 0;
        long pot10 = 1;
        while (aux != 0) {
            long resto = aux % 2;
            aux = aux / 2;
            soma = soma + resto * pot10;
            pot10 = pot10 * 10;
        }
        return soma;
    }

    public String getHexadecimal() {
        return "";
    }
}
