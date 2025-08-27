package br.com.fiap.enquete.repository;

import br.com.fiap.enquete.model.Pergunta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PerguntaRepository {

    private Connection con;

    public PerguntaRepository(Connection con) {
        this.con = con;
    }

    public PerguntaRepository() {}


    public void save(Pergunta pergunta) throws SQLException {
        String sql = "INSERT INTO pergunta(numero, texto, tema) VALUES(?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, pergunta.getNumero());
        pstmt.setString(2, pergunta.getTexto());
        pstmt.setString(3, pergunta.getTema());
        pstmt.executeUpdate();
        pstmt.close();
    }

    public boolean deleteByNumeroTema(int numero, String tema) throws SQLException {
        String sql = "DELETE FROM pergunta WHERE numero = ? AND tema = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, numero);
        pstmt.setString(2, tema);
        int qtd = pstmt.executeUpdate();
        if (qtd > 0)
            return true;
        else
            return false;
    }


    @Deprecated
    public void save(Pergunta pergunta, Connection con) throws SQLException {
        String sql = "INSERT INTO pergunta(numero, texto, tema) VALUES(" + pergunta.getNumero() + ", '" + pergunta.getTexto() + "', '" + pergunta.getTema() + "')";
        //insert into pergunta(numero, texto, tema) values(1, 'Qual o seu nome?', 'Pessoal')
        Statement stmt = con.createStatement();
        //stmt.execute(sql); prefiram o executeUpdate ao inves de execute
        stmt.executeUpdate(sql);
        stmt.close();
    }

    @Deprecated
    public List<Pergunta> getByTema(String tema, Connection con) throws SQLException {
        String sql = "SELECT id, numero, texto, tema FROM pergunta WHERE tema = '" + tema +"' ORDER BY numero";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Pergunta> resp = new ArrayList<>();
        while (rs.next()) {
            Pergunta p = new Pergunta();
            p.setId(rs.getLong("id"));
            p.setNumero(rs.getInt("numero"));
            p.setTexto(rs.getString(3));
            p.setTema(rs.getString(4));
            resp.add(p);
        }
        stmt.close();
        return resp;
    }

    @Deprecated
    public boolean deleteByNumeroTema(int numero, String tema, Connection con) throws SQLException {
        String sql = "DELETE FROM pergunta WHERE numero = " + numero + " AND tema = '" + tema + "'";
        Statement stmt = con.createStatement();
        int registros = stmt.executeUpdate(sql);
        if (registros > 0)
            return true;
        else
            return false;
    }


}
