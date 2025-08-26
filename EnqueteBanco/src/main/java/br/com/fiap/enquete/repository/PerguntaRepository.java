package br.com.fiap.enquete.repository;

import br.com.fiap.enquete.model.Pergunta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PerguntaRepository {
    
    public void save(Pergunta pergunta, Connection con) throws SQLException {
        String sql = "INSERT INTO pergunta(numero, texto, tema) VALUES(" + pergunta.getNumero() + ", '" + pergunta.getTexto() + "', '" + pergunta.getTema() + "')";
        //insert into pergunta(numero, texto, tema) values(1, 'Qual o seu nome?', 'Pessoal')
        Statement stmt = con.createStatement();
        stmt.execute(sql);
        stmt.close();
    }

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


}
