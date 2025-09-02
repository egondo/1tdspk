package br.com.fiap.enquete.app;

import br.com.fiap.enquete.model.Pergunta;
import br.com.fiap.enquete.repository.ConnectionFactory;
import br.com.fiap.enquete.repository.PerguntaRepository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ConsultaMainConnectionFactory {

    public static void main(String[] args) {
        try {
            Connection con = new ConnectionFactory().getConnection();
            PerguntaRepository pr = new PerguntaRepository(con);
            List<Pergunta> perguntas = pr.getByTema("Pessoal");

            for(Pergunta p : perguntas) {
                StringBuilder sb = new StringBuilder();
                sb.append(p.getNumero());
                sb.append(") ");
                sb.append(p.getTexto());
                String resp = JOptionPane.showInputDialog(null, sb.toString());

                //a partir da String resp, crie uma classe que representa a resposta da pessoa
                //nao esqueca de vincular a resposta com a pergunta
                //tentar gravar a resposta no banco de dados.
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
