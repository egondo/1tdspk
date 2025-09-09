package br.com.empresatdspk.app;

import br.com.empresatdspk.model.Endereco;
import br.com.empresatdspk.model.Pessoa;
import br.com.empresatdspk.repository.ConnectionFactory;
import br.com.empresatdspk.repository.PessoaRepository;

import java.sql.Connection;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws Exception {
        Pessoa p = new Pessoa();
        p.setCpf("927.261.099-67");
        p.setEmail("andreia_maria@gmail.com");
        p.setNascimento(LocalDate.of(2005, 8, 2));
        p.setTelefone("(11) 72710-9099");
        p.setNome("Andreia Maria Carvalho");

        Endereco end = new Endereco();
        end.setCep("01082-001");
        end.setLogradouro("Av Paulista");
        end.setNumero("1106");
        end.setMunicipio("São Paulo");
        p.setEndereco(end);

        Connection con = new ConnectionFactory().getConnection();

        PessoaRepository pr = new PessoaRepository(con);
        pr.save(p);

        System.out.printf("ID PESSOA " + p.getId());
    }
}
