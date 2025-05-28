package br.com.fiap.cassino.model;

import java.util.Random;

public class Baralho {

    private Carta[] monte;
    private int topo = 0;

    public Baralho() {
        this.monte = new Carta[52];
        int k = 0;
        for (int valor = 1; valor <= 13; valor++) {
            this.monte[k++] = new Carta(valor, "paus");
            this.monte[k++] = new Carta(valor, "copas");
            this.monte[k++] = new Carta(valor, "espadas");
            this.monte[k++] = new Carta(valor, "ouros");
        }
    }

    public void embaralha() {
        Random rand = new Random();
        for(int k = 0; k < 200; k++) {
            int i = rand.nextInt(52);
            int j = rand.nextInt(52);
            Carta aux = this.monte[i];
            this.monte[i] = this.monte[j];
            this.monte[j] = aux;
        }
    }

    public Carta recuperaCarta() {
        if (topo > 51)
            return null;
        return this.monte[topo++];
    }

    public Carta[] distribui(int n) {
        Carta[] resp = new Carta[n];
        Carta c = this.recuperaCarta();
        int i = 0;
        while (c != null && i < n) {
            resp[i++] = c;
            c = this.recuperaCarta();
        }
        return resp;
    }
}
