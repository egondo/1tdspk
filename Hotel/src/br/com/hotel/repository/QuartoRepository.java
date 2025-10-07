package br.com.hotel.repository;


import br.com.hotel.model.Quarto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QuartoRepository {

    private Connection con;

    public QuartoRepository() throws Exception {
        this.con = new ConnectionFactory().getConnection();
    }

    public List<Quarto> findAvailable(int capacidade, LocalDate inicio, LocalDate fim) throws Exception {
        String sql = "SELECT id, numero, capacidade, quantidade_cama FROM quarto q WHERE q.capacidade >= ? AND NOT id IN (SELECT id_quarto FROM reserva WHERE (? BETWEEN checkin AND checkout) OR (? BETWEEN checkin AND checkout) OR (checkin BETWEEN ? AND ?) OR (checkout BETWEEN ? AND ?)) ORDER BY q.capacidade

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, capacidade);
        pstmt.setDate(2, Date.valueOf(inicio));
        pstmt.setDate(3, Date.valueOf(fim));

        pstmt.setDate(4, Date.valueOf(inicio));
        pstmt.setDate(5, Date.valueOf(fim));

        pstmt.setDate(6, Date.valueOf(inicio));
        pstmt.setDate(7, Date.valueOf(fim));

        ResultSet rs = pstmt.executeQuery();
        List<Quarto> resposta = new ArrayList<>();
        while (rs.next()) {
            Quarto q = new Quarto();
            q.setId(rs.getLong("id"));
            q.setCapacidade(rs.getInt("capacidade"));
            q.setQuantidadeCamas(rs.getInt("quantidade_camas"));
            q.setNumero(rs.getString("numero"));
            resposta.add(q);
        }
        pstmt.close();
        return resposta;
    }
}
