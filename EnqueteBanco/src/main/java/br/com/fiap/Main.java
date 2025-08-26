package br.com.fiap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main
{
    public static void main( String[] args ) {
        String jdbc = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        try {
            Connection con = DriverManager.getConnection(jdbc, "pf0313", "professor#23");
            System.out.println(con.getClientInfo());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
