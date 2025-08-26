package br.com.fiap.baralho;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho {

    protected List<Carta> monte;
    private int topo = 0;

    public Baralho() {
        this.monte = new ArrayList<>();
        int k = 0;
        Carta c = null;
        for (int valor = 1; valor <= 13; valor++) {
            c = new Carta(valor, "paus");
            this.monte.add(c);

            this.monte.add(new Carta(valor, "copas"));

            c = new Carta(valor, "espadas");
            this.monte.add(c);

            this.monte.add(new Carta(valor, "ouros"));
        }
    }

    public void embaralha() {
        Random rand = new Random();
        for(int k = 0; k < 200; k++) {
            int i = rand.nextInt(52);
            int j = rand.nextInt(52);
            Carta aux = this.monte.get(i);
            this.monte.set(i, this.monte.get(j));
            this.monte.set(j, aux);
        }
    }

    public Carta recuperaCarta() {
        if (topo >= this.monte.size())
            return null;
        return this.monte.get(topo++);
    }

    public List<Carta> distribui(int n) {
        List<Carta> resp = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            Carta c = this.recuperaCarta();
            if (c == null) {
                break;
            }
            resp.add(c);
        }
        return resp;
    }
}
