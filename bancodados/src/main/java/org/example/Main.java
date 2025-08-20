package org.example;

import java.sql.*;
import java.time.LocalDate;

public class Main 
{
    public static void main( String[] args ) {

        String sql = "SELECT id, nome, telefone, email, responsavel, nascimento FROM T_PACIENTE";
        String jdbc = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";

        try {
            Connection con = DriverManager.getConnection(jdbc, "pf0313", "professor#23");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String tel = rs.getString("telefone");
                String email = rs.getString("email");
                String resp = rs.getString("responsavel");
                LocalDate nascimento = rs.getDate("nascimento").toLocalDate();

                System.out.println(nome + " " + nascimento);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
