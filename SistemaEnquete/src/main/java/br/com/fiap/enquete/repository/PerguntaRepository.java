package br.com.fiap.enquete.repository;

import br.com.fiap.enquete.model.*;
import br.com.fiap.enquete.util.PerguntaTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PerguntaRepository {

    private Connection con;

    public PerguntaRepository(Connection con) {
        this.con = con;
    }

    public PerguntaRepository() throws SQLException {
        this.con = new ConexaoFactory().getConexao();
    }

    public void save(Pergunta pergunta) throws SQLException {
        String sqlP = "INSERT INTO k_pergunta(enunciado, numero, tipo, enquete_id) VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sqlP, new String[]{"id"});
        pstmt.setString(1, pergunta.getEnunciado());
        pstmt.setInt(2, pergunta.getNumero());
        pstmt.setString(3, pergunta.getTipo().name());
        pstmt.setLong(4, pergunta.getEnquete().getId());

        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        long idPergunta = 0;
        if (rs.next()) {
            System.out.println("Nao retornou nada");
            idPergunta = rs.getLong(1);
        }
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

    private PerguntaTO parsePerguntaTO(ResultSet rs) throws SQLException {
        PerguntaTO obj = new PerguntaTO();
        obj.setId(rs.getLong("id"));
        obj.setEnunciado(rs.getString("enunciado"));
        obj.setTipo(TipoPergunta.valueOf(rs.getString("tipo")));
        obj.setNumero(rs.getInt("numero"));
        obj.setIdItem(rs.getLong("item_id"));
        obj.setDescricaoItem(rs.getString("descricao"));
        return obj;
    }

    public List<PerguntaTO> findByEnquete(Enquete enquete) throws SQLException {

        String sql = "select p.id, p.enunciado, p.numero, p.tipo, i.id as item_id, i.descricao from k_pergunta p left join k_item i on p.id = i.pergunta_id where p.enquete_id = ? order by p.numero, i.id";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setLong(1, enquete.getId());

        ResultSet rs = pstmt.executeQuery();
        List<PerguntaTO> resp = new ArrayList<>();
        while (rs.next()) {
            resp.add(parsePerguntaTO(rs));
        }
        pstmt.close();
        return resp;
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
