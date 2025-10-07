package br.com.hotel.repository;

import br.com.hotel.model.Reserva;
import br.com.hotel.model.Status;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

public class ReservaRepository {

    private Connection con;

    public ReservaRepository() throws Exception {
        this.con = new ConnectionFactory().getConnection();
    }

    public ReservaRepository(Connection con) {
        this.con = con;
    }

    public void save(Reserva reserva) throws Exception {
        String sql = "INSERT INTO reserva(checkin, checkout, id_quarto, id_pessoa, status) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setDate(1, Date.valueOf(reserva.getCheckin()));
        pstmt.setDate(2, Date.valueOf(reserva.getCheckout()));
        pstmt.setLong(3, reserva.getQuarto().getId());
        pstmt.setLong(4, reserva.getHospede().getId());
        pstmt.setString(5, Status.ABERTA.toString());

        pstmt.executeUpdate();
        pstmt.close();
    }

}
