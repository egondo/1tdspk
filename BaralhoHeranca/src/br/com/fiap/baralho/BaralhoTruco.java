package br.com.fiap.baralho;

import java.util.ArrayList;

public class BaralhoTruco extends Baralho {


    public BaralhoTruco() {
        super(); //chamando o contrutor do Baralho
        //acessar o atributo monte e retirar as cartas
        //com valor 8, 9 e 10
        int i = 0;
        while (i < this.monte.size()) {
            Carta c = this.monte.get(i);
            if (c.getValor() >= 8 && c.getValor() <= 10) {
                this.monte.remove(i);
            }
            else
                i++;
        }
    }

    public BaralhoTruco(boolean novo) {
        this.monte = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            if (i < 8 || i > 10) {
                monte.add(new Carta(i, "paus"));
                monte.add(new Carta(i, "espadas"));
                monte.add(new Carta(i, "ouros"));
                monte.add(new Carta(i, "copas"));
            }
        }
    }
}
