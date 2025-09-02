package br.com.fiap.enquete.repository;

import br.com.fiap.enquete.model.Resposta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class RespostaRepository {

    private Connection con = null;

    public RespostaRepository(Connection con) {
        this.con = con;
    }

    public void save(Resposta resposta) throws SQLException {
        String sql = "INSERT INTO resposta(valor, data, pessoa, pergunta_id) VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, resposta.getValor());

        if (resposta.getData() != null)
            pstmt.setTimestamp(2, Timestamp.valueOf(resposta.getData()));
        else
            pstmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));


        pstmt.setString(3, resposta.getPessoa());
        pstmt.setLong(4, resposta.getPergunta().getId());

        pstmt.executeUpdate();
        pstmt.close();
    }
}
