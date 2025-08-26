package br.com.fiap.enquete.app;

import br.com.fiap.enquete.model.Pergunta;
import br.com.fiap.enquete.repository.PerguntaRepository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ConsultaMain {

    public static void main(String[] args) {
        String jdbc = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        try {
            Connection con = DriverManager.getConnection(jdbc, "pf0313", "professor#23");

            PerguntaRepository pr = new PerguntaRepository();
            List<Pergunta> perguntas = pr.getByTema("Pessoal", con);

            for(Pergunta p : perguntas) {
                StringBuilder sb = new StringBuilder();
                sb.append(p.getNumero());
                sb.append(") ");
                sb.append(p.getTexto());
                JOptionPane.showInputDialog(null, sb.toString());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
