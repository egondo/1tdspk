package br.com.fiap.enquete.model;

public enum TipoPergunta {
    ABERTA(0), UNICA(1), MULTIPLA(2);

    private int valor;

    private TipoPergunta(int valor) {
        this.valor = valor;
    }
}
