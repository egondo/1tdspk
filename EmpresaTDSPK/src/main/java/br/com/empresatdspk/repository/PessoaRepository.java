package br.com.empresatdspk.repository;

import br.com.empresatdspk.model.Pessoa;

import java.sql.*;

public class PessoaRepository {

    private Connection con;

    public PessoaRepository(Connection con) {
        this.con = con;
    }

    public void save(Pessoa pes) throws SQLException {
        String sql = "INSERT INTO pessoa(nome, telefone, email, nascimento, cpf) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"id"});
        pstmt.setString(1, pes.getNome());
        pstmt.setString(2, pes.getTelefone());
        pstmt.setString(3, pes.getEmail());
        pstmt.setDate(4, Date.valueOf(pes.getNascimento()));
        pstmt.setString(5, pes.getCpf());

        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            pes.setId(rs.getLong(1));
        } else {
            throw new SQLException("Erro na hora de pegar a chave primária");
        }
        pstmt.close();
    }
}
