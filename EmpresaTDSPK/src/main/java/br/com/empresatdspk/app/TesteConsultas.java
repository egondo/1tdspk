package br.com.empresatdspk.app;

import br.com.empresatdspk.model.Funcionario;
import br.com.empresatdspk.repository.FuncionarioRepository;

import java.sql.SQLException;
import java.util.List;

public class TesteConsultas {

    public static void main(String[] args) {
        try {
            FuncionarioRepository fr = new FuncionarioRepository();
            List<Funcionario> trabalhadores = fr.findAll();
            for(Funcionario f : trabalhadores) {
                System.out.println(f.getPessoa().getNome() + " " + f.getSalario());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
