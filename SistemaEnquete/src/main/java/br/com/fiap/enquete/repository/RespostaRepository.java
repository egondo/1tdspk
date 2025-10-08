package br.com.fiap.enquete.repository;

import br.com.fiap.enquete.model.Enquete;
import br.com.fiap.enquete.model.Resposta;
import br.com.fiap.enquete.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RespostaRepository {

    private Connection con;

    public void save(List<Resposta> respostas) throws SQLException {

    }

    public List<Resposta> findAll(Enquete enquete) throws SQLException {
        return null;
    }

    public List<Resposta> findByUsuario(Usuario usuario) throws SQLException {
        return null;
    }


}
