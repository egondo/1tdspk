package br.com.empresatdspk.repository;

import br.com.empresatdspk.model.Funcionario;
import br.com.empresatdspk.model.Pessoa;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {

    private Connection con;

    public FuncionarioRepository() throws SQLException {
        this.con = new ConnectionFactory().getConnection();
    }

    public FuncionarioRepository(Connection con) {
        this.con = con;
    }

    public List<Funcionario> findAll() throws SQLException {
        String sql = "SELECT f.id as id_f, f.departamento, f.cargo, f.salario, f.turno, f.admissao, f.pessoa_id, p.nome, p.email, p.cpf, p.telefone, p.nascimento FROM FUNCIONARIO f join PESSOA p ON f.pessoa_id = p.id ORDER BY p.nome";

        List<Funcionario> resp = new ArrayList<>();

        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            long idFuncionario = rs.getLong("id_f");
            String depto = rs.getString("departamento");
            String cargo = rs.getString("cargo");
            double salario = rs.getDouble("salario");
            String turno = rs.getString("turno");
            LocalDate admissao = rs.getDate("admissao").toLocalDate();
            long idPessoa = rs.getLong("pessoa_id");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String cpf = rs.getString("cpf");
            String telefone = rs.getString("telefone");

            //LocalDate nascimento = rs.getDate("nascimento").toLocalDate();
            LocalDate nascimento = null;
            Date aux = rs.getDate("nascimento");
            if (aux != null)
                nascimento = aux.toLocalDate();

            Pessoa pes = new Pessoa();
            pes.setId(idPessoa);
            pes.setNome(nome);
            pes.setEmail(email);
            pes.setCpf(cpf);
            pes.setTelefone(telefone);
            pes.setNascimento(nascimento);

            Funcionario func = new Funcionario();
            func.setId(idFuncionario);
            func.setAdmissao(admissao);
            func.setCargo(cargo);
            func.setSalario(salario);
            func.setTurno(turno);
            func.setDepartamento(depto);
            func.setPessoa(pes);

            resp.add(func);
        }
        return resp;
    }
}
