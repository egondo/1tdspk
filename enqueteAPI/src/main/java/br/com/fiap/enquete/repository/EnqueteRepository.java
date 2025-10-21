package br.com.fiap.enquete.repository;

import br.com.fiap.enquete.model.Enquete;

import java.sql.*;

public class EnqueteRepository {

    private Connection con;

    public EnqueteRepository(Connection con) {
        this.con = con;
    }

    public void save(Enquete enquete) throws SQLException {
        String sql = "INSERT INTO k_enquete(nome, criador, data) VALUES(?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"id"});

        pstmt.setString(1, enquete.getNome());
        pstmt.setString(2, enquete.getCriador());
        pstmt.setDate(3, Date.valueOf(enquete.getData()));
        pstmt.execute();

        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            long id = rs.getLong(1);
            System.out.println("ID Enquete " + id);
            enquete.setId(id);
        }
        pstmt.close();
    }

}
