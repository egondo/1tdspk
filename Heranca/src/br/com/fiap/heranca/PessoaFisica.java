package br.com.fiap.heranca;

import java.time.LocalDate;

public class PessoaFisica extends Pessoa {

    private String cpf;
    private LocalDate nascimento;

    public PessoaFisica() {}

    public PessoaFisica(String nome, String celular, String cpf, LocalDate nascimento) {
        super(nome, celular);
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return super.toString() + " " + nascimento + " " + cpf;
    }
}
