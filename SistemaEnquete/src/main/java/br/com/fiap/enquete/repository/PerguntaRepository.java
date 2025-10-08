package br.com.fiap.enquete.repository;

import br.com.fiap.enquete.model.Enquete;
import br.com.fiap.enquete.model.Item;
import br.com.fiap.enquete.model.Pergunta;
import br.com.fiap.enquete.model.TipoPergunta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class PerguntaRepository {

    private Connection con;

    public PerguntaRepository(Connection con) {
        this.con = con;
    }

    public void save(Pergunta pergunta) throws SQLException {
        String sqlP = "INSERT INTO k_pergunta(enunciado, numero, tipo, enquete_id) VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sqlP);
        pstmt.setString(1, pergunta.getEnunciado());
        pstmt.setInt(2, pergunta.getNumero());
        pstmt.setString(3, pergunta.getTipo().name());
        pstmt.setLong(4, pergunta.getEnquete().getId());

        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        long idPergunta = 0;
        if (rs.next())
            idPergunta = rs.getLong(1);

        System.out.println("ID PERGUNTA " + idPergunta);


        if (pergunta.getTipo() != TipoPergunta.ABERTA) {
            //tenho itens a serem gravados no banco
            String sqlI = "INSERT INTO k_item(descricao, pergunta_id) VALUES(?, ?)";
            pstmt = con.prepareStatement(sqlI);
            for (Item i : pergunta.getItens()) {
                pstmt.setString(1, i.getDescricao());
                pstmt.setLong(2, idPergunta);
                pstmt.executeUpdate();
            }
        }
        pstmt.close();
    }

    public List<Pergunta> findByEnquete(Enquete enquete) throws SQLException {
        return null;
    }


    public Pergunta findByEnqueteEnunciado(Enquete enquete, String enunciado) throws SQLException {
        String sql = "SELECT id, enunciado, numero, tipo, enquete_id FROM k_pergunta WHERE enquete_id = ? AND lower(enunciado) = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setLong(1, enquete.getId());
        pstmt.setString(2, enunciado.toLowerCase());
        ResultSet rs = pstmt.executeQuery();

        Pergunta resp = null;
        if (rs.next()) {
            resp = new Pergunta();
            resp.setId(rs.getLong("id"));
            resp.setEnunciado(rs.getString("enunciado"));
            resp.setNumero(rs.getInt("numero"));
            resp.setEnquete(enquete);
            //quando o atributo é um enum, fazemos a criacao dessa forma.
            resp.setTipo(TipoPergunta.valueOf(rs.getString("tipo")));
        }
        return resp;
    }
}
