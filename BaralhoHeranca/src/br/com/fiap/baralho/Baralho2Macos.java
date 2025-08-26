package br.com.fiap.baralho;

import java.lang.annotation.Inherited;
import java.util.Random;

public class Baralho2Macos extends Baralho {
    private Baralho vermelho;
    private Baralho preto;
    private Random random;

    public Baralho2Macos() {
        this.vermelho = new Baralho();
        this.preto = new Baralho();
        random = new Random();
    }

    @Override
    public void embaralha() {
        this.vermelho.embaralha();
        this.preto.embaralha();
    }

    @Override
    public Carta recuperaCarta() {
        Carta resp = null;
        if (random.nextBoolean()) {
            resp = vermelho.recuperaCarta();
            if (resp == null)
                resp = preto.recuperaCarta();
        }
        else {
            resp = preto.recuperaCarta();
            if (resp == null)
                resp = vermelho.recuperaCarta();
        }
        return resp;
    }






}
