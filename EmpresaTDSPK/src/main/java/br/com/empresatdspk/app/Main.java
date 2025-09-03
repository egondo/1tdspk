package br.com.empresatdspk.app;

import br.com.empresatdspk.model.Pessoa;
import br.com.empresatdspk.repository.ConnectionFactory;
import br.com.empresatdspk.repository.PessoaRepository;

import java.sql.Connection;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws Exception {
        Pessoa p = new Pessoa();
        p.setCpf("3423423");
        p.setEmail("joao@fiap.com.br");
        p.setNascimento(LocalDate.now());
        p.setTelefone("(11) 83423423354");

        Connection con = new ConnectionFactory().getConnection();

        PessoaRepository pr = new PessoaRepository(con);
        pr.save(p);

        System.out.printf("ID PESSOA " + p.getId());
    }
}
