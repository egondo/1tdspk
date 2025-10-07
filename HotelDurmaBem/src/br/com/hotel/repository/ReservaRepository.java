package br.com.hotel.repository;

import br.com.hotel.model.Reserva;

import java.sql.Connection;

public class ReservaRepository {

    private Connection con;

    public ReservaRepository() throws Exception {
        this.con = new ConnectionFactory().getConnection();
    }

    public ReservaRepository(Connection con) {
        this.con = con;
    }

    public void save(Reserva reserva) throws Exception {
        String sql = "INSERT INTO reserva(checkin, checkou, id_uarto, id_pessoa, status) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.preparedStatement(sql);
        pstmt.set





    }
}
