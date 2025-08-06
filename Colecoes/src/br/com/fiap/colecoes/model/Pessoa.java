package br.com.fiap.colecoes.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private long id;

    private String nome;
    private String celular;
    private LocalDate nascimento;

    private List<Endereco> enderecos;

    public Pessoa(String nome) {
        this.nome = nome;
        this.enderecos = new ArrayList<>();
    }

    public long getId() {
        return id;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public void addEndereco(Endereco e) {
        if (!this.enderecos.contains(e))
            this.enderecos.add(e);
    }

    public Endereco getEndereco(int indice) {
        if (indice >= 0 && indice < this.enderecos.size())
            return this.enderecos.get(indice);

        return null;
    }


    public String toString() {
        return "Nome: " + nome  + "\nCelular: " + celular + "\nNascimento: " + nascimento;
    }



}
