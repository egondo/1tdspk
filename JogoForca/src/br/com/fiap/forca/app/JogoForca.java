package br.com.fiap.forca.app;

import br.com.fiap.forca.model.Forca;

import java.util.Scanner;

public class JogoForca {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        Forca f = new Forca();
        while (!f.acertou() && !f.enforcou()) {
            String s = f.getPalavraFechada();
            System.out.println(s);
            System.out.println("Erros: " + f.getErros());
            System.out.print("Letra");
            char letra = tec.nextLine().charAt(0); //pegando o 1 caracter da string
            f.chuta(letra);
        }

        if (f.acertou())
            System.out.println("Parabéns!");
        else
            System.out.println("Vc foi enforcado");

        System.out.println(f.getPalavraAberta());
    }
}
