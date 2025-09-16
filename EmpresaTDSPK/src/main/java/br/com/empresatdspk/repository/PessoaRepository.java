package br.com.empresatdspk.repository;

import br.com.empresatdspk.model.Endereco;
import br.com.empresatdspk.model.Pessoa;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {

    private Connection con;

    public PessoaRepository() throws SQLException {
        this.con = new ConnectionFactory().getConnection();
    }
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
        List<Endereco> enderecosLista = pes.getEnderecos();

        for (Endereco end : enderecosLista) {
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
        }
        pstmt.close();
    }

    public List<Pessoa> findAll() throws SQLException {
        String sql = "SELECT p.id, p.nome, p.cpf, p.telefone, p.email, p.nascimento, e.cep, e.logradouro, e.numero, e.municipio, e.id as endereco_id FROM pessoa p LEFT JOIN endereco e ON p.id = e.pessoa_id ORDER BY p.id";

        List<Pessoa> resp = new ArrayList<>();

        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        //evita instanciarmos as mesmas pessoas
        long auxId = -1L;
        Pessoa pes = null;
        LocalDate nascimento = null;
        while (rs.next()) {
            long id = rs.getLong("id");
            if (id != auxId) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");

                if (rs.getDate("nascimento") != null)
                    nascimento = rs.getDate("nascimento").toLocalDate();
                else
                    nascimento = null;
                pes = new Pessoa();
                pes.setId(id);
                pes.setNome(nome);
                pes.setCpf(cpf);
                pes.setTelefone(rs.getString("telefone"));
                pes.setNascimento(nascimento);
                resp.add(pes);
                auxId = id;
            }
            Long idEndereco = rs.getLong("endereco_id");
            if (idEndereco != null) {
                Endereco end = new Endereco();
                end.setId(idEndereco);
                end.setMunicipio(rs.getString("municipio"));
                end.setNumero(rs.getString("numero"));
                end.setCep(rs.getString("cep"));
                end.setLogradouro(rs.getString("logradouro"));
                pes.addEndereco(end);
            }
        }
        return resp;
    }
}
