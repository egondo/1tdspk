package br.com.fiap.enquete.model;

public class Pergunta {

    private long id;
    private int numero;
    private String texto;
    private String tema;

    public Pergunta() {}

    public Pergunta(int numero, String tema, String texto) {
        this.numero = numero;
        this.tema = tema;
        this.texto = texto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
