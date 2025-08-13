package br.com.fiap.heranca;

import java.time.LocalDate;

public class TestaPessoa {

    public static void imprime(Object obj) {
        String s = obj.toString();
        System.out.println(s);
    }

    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("FIAP");
        p.setCelular("(11) 94853-9039");

        LocalDate hoje = LocalDate.now();
        Pessoa q = new PessoaFisica("Joao", "(11) 88570-9977", "322.938.8980-00", hoje);
        imprime(p);
        imprime(q);
    }
}
