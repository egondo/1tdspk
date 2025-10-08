package br.com.fiap.enquete.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    //criar método que recupera a conexao
    public Connection getConexao() throws SQLException {
        String jdbc = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        String user = "pf0313";
        String pwd = "professor#23";
        return DriverManager.getConnection(jdbc, user, pwd);
    }
}
