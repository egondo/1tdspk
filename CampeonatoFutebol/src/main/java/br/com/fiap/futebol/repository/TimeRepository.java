package br.com.fiap.futebol.repository;

import br.com.fiap.futebol.model.Time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TimeRepository {

    private Connection con;

    public TimeRepository() throws Exception {
        this.con = new ConnectionFactory().getConnection();
    }

    public TimeRepository(Connection con) {
        this.con = con;
    }

    public void save(Time time) throws Exception {
        String sql = "INSERT INTO time(nome, vitorias, empates, derrotas, gols_pro, gols_contra) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"id"});
        pstmt.setString(1, time.getNome());
        pstmt.setInt(2, time.getVitorias());
        pstmt.setInt(3, time.getEmpates());
        pstmt.setInt(4, time.getDerrotas());
        pstmt.setInt(5, time.getGolsPro());
        pstmt.setInt(6, time.getGolsContra());

        pstmt.executeUpdate();

        //recuperando o id gerado para o Time e colocando no objeto
        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            time.setId(rs.getLong(1));
        }
    }
}
