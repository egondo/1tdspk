package br.com.fiap.baralho.app;

import br.com.fiap.baralho.Baralho;
import br.com.fiap.baralho.Baralho2Macos;
import br.com.fiap.baralho.BaralhoTruco;
import br.com.fiap.baralho.Carta;

public class TesteBaralho {

    public static void main(String[] args) {
        Baralho truco = new Baralho2Macos();
        Carta c = truco.recuperaCarta();
        while (c != null) {
            System.out.println(c);
            c = truco.recuperaCarta();
        }
    }
}
