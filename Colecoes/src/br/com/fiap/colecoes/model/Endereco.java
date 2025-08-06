package br.com.fiap.colecoes.model;

import java.util.Objects;

public class Endereco {

    private String logradouro;
    private String cep;
    private String numero;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(logradouro, endereco.logradouro) && Objects.equals(cep, endereco.cep) && Objects.equals(numero, endereco.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logradouro, cep, numero);
    }
}
