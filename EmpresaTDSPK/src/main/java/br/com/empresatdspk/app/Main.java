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
        p.setCpf("928.829.817-99");
        p.setEmail("tomjobin@gmail.com");
        p.setNascimento(LocalDate.of(2005, 8, 2));
        p.setTelefone("(11) 82482-7132");
        p.setNome("Antonio Calos Jobim");

        Endereco end = new Endereco();
        end.setCep("01082-001");
        end.setLogradouro("Av Paulista");
        end.setNumero("1106");
        end.setMunicipio("São Paulo");
        p.addEndereco(end);

        end = new Endereco();
        end.setCep("01283-001");
        end.setMunicipio("São Paulo");
        end.setLogradouro("Av Lins de Vasconcelos");
        end.setNumero("1222");
        p.addEndereco(end);

        end = new Endereco();
        end.setCep("01209-000");
        end.setMunicipio("São Paulo");
        end.setLogradouro("Av Ipiranga com a São João");
        end.setNumero("590");
        p.addEndereco(end);

        Connection con = new ConnectionFactory().getConnection();

        PessoaRepository pr = new PessoaRepository(con);
        pr.save(p);

        System.out.printf("ID PESSOA " + p.getId());
    }
}
