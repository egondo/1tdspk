package br.com.fiap.heranca;

public class Pessoa {

    private String nome;
    private String celular;

    public Pessoa() {}

    public Pessoa(String nome, String celular) {
        this.nome = nome;
        this.celular = celular;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
