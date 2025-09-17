package br.com.fiap.futebol.repository;

import br.com.fiap.futebol.model.Partida;
import br.com.fiap.futebol.model.Time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class PartidaRepository {

    private Connection con;

    public PartidaRepository() throws Exception {
        this.con = new ConnectionFactory().getConnection();
    }

    public PartidaRepository(Connection con) {
        this.con = con;
    }

    public void save(Partida partida) throws Exception {
        String sql = "INSERT INTO partida(gols_casa, gols_visitante, time_casa, time_visitante, local, data_hora) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"id"});
        pstmt.setInt(1, partida.getGolsCasa());
        pstmt.setInt(2, partida.getGolsVisitante());

        //gravando a chave primaria do time na chave estrangeira da partida
        pstmt.setLong(3, partida.getCasa().getId());
        pstmt.setLong(4, partida.getVisitante().getId());

        pstmt.setString(5, partida.getLocal());
        pstmt.setTimestamp(6, Timestamp.valueOf(partida.getDataHora()));
        pstmt.executeUpdate();

        //recuperando o id gerado para o Time e colocando no objeto
        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            partida.setId(rs.getLong(1));
        }
    }
}
