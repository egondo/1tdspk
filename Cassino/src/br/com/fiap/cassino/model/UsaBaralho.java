package br.com.fiap.cassino.model;

public class UsaBaralho {
    public static void main(String[] args) {
        Baralho b = new Baralho();
        b.embaralha();

        Carta c = b.recuperaCarta();
        while (c != null) {
            System.out.println(c);
            c = b.recuperaCarta();
        }
    }
}
