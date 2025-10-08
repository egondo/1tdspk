package br.com.fiap.enquete.repository;

import br.com.fiap.enquete.model.Enquete;
import br.com.fiap.enquete.model.Pergunta;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PerguntaRepository {

    private Connection con;

    public void save(Pergunta pergunta) throws SQLException {

    }

    public List<Pergunta> findByEnquete(Enquete enquete) throws SQLException {
        return null;
    }


}
