package br.com.empresatdspk.repository;

import br.com.empresatdspk.model.Endereco;
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

        sql = "INSERT INTO endereco(pessoa_id, logradouro, cep, numero, municipio) VALUES(?, ?, ?, ?, ?)";
        Endereco end = pes.getEndereco();
        if (end == null) {
            throw new SQLException("Endereço da Pessoa está nulo");
        }
        pstmt = con.prepareStatement(sql);
        pstmt.setLong(1, pes.getId());
        pstmt.setString(2, end.getLogradouro());
        pstmt.setString(3, end.getCep());
        pstmt.setString(4, end.getNumero());
        pstmt.setString(5, end.getMunicipio());

        pstmt.executeUpdate();

        pstmt.close();
    }
}
