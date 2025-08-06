package br.com.fiap.colecoes.model;

import javax.swing.*;
import java.time.LocalDate;

public class Teste {

    public static void main(String[] args) {

        String nome = JOptionPane.showInputDialog("Nome: ");

        Pessoa pes = new Pessoa(nome);

        String celular = JOptionPane.showInputDialog("Celular: ");
        pes.setCelular(celular);

        String nascimento = JOptionPane.showInputDialog("Nascimento (aaaa-mm-dd): ");
        pes.setNascimento(LocalDate.parse(nascimento));


        JOptionPane.showMessageDialog(null, pes);


        Endereco end = new Endereco();
        end.setLogradouro("Av Paulista");
        end.setNumero("1106");
        end.setCep("01209-000");

        pes.addEndereco(end);


        end = new Endereco();
        end.setLogradouro("Av Lins de Vasconcelos");
        end.setNumero("1222");
        end.setCep("05829-000");

        pes.addEndereco(end);

        end = new Endereco();
        end.setLogradouro("Av Lins de Vasconcelos");
        end.setNumero("1222");
        end.setCep("05829-000");

        pes.addEndereco(end);


        int i = 0;
        while(pes.getEndereco(i) != null) {
            JOptionPane.showMessageDialog(null, pes.getEndereco(i));
            i++;
        }
    }

}
