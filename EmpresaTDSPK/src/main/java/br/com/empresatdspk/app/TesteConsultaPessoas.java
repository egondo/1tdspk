package br.com.empresatdspk.app;

import br.com.empresatdspk.model.Endereco;
import br.com.empresatdspk.model.Pessoa;
import br.com.empresatdspk.repository.PessoaRepository;

import java.sql.SQLException;
import java.util.List;

public class TesteConsultaPessoas {

    public static void main(String[] args) {
        try {
            PessoaRepository pr = new PessoaRepository();
            List<Pessoa> lista = pr.findAll();
            for(Pessoa p : lista) {
                System.out.println(p.getNome() + " " + p.getTelefone());
                List<Endereco> enderecos = p.getEnderecos();
                for(Endereco end : enderecos) {
                    System.out.println("\t" + end.getLogradouro() + " " + end.getNumero());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
