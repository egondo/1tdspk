package br.com.fiap.enquete.model;

public class Usuario {

    private long id;
    private String nome;
    private String telefone;
    private int situacao;

    public long getId() {
        return id;
    }

    public boolean isAtivo() {
        if (situacao == 1)
            return true;
        else
            return false;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
