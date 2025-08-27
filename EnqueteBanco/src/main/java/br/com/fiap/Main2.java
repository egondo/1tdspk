package br.com.fiap;

import br.com.fiap.enquete.model.Pergunta;
import br.com.fiap.enquete.repository.PerguntaRepository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main2
{
    public static void main( String[] args ) {
        String jdbc = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        try {
            Connection con = DriverManager.getConnection(jdbc, "pf0313", "professor#23");
            PerguntaRepository pr = new PerguntaRepository(con);

            String numero = JOptionPane.showInputDialog("Numero da pergunta: ");
            String tema = JOptionPane.showInputDialog("Tema da pergunta: ");

            boolean resp = pr.deleteByNumeroTema(Integer.parseInt(numero), tema);
            if (resp) {
                System.out.println("REgistro apagado com sucesso");
            }
            else {
                System.out.println("Nenhuma pergunta encontrada!");
            }

            Pergunta p1 = new Pergunta(1, "Pessoal", "Qual o seu nome?");
            Pergunta p2 = new Pergunta(2, "Pessoal", "Informe o seu email?");
            Pergunta p3 = new Pergunta(3, "Pessoal", "Data de nascimento?");
            Pergunta p4 = new Pergunta(4, "Pessoal", "Nome da mãe?");

            Pergunta p5 = new Pergunta(1, "Escolar", "O que vc esta estudando?");
            Pergunta p6 = new Pergunta(2, "Escolar", "Esta gostando do curso?");

            /*
            pr.save(p1, con);
            pr.save(p2, con);
            pr.save(p3, con);
            pr.save(p4, con);
            pr.save(p5, con);
            pr.save(p6, con);
            */


            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
