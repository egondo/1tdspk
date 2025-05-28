package br.com.fiap.cassino.model;

public class JogoBestaBaralho {

    public static void main(String[] args) {
        Baralho bar = new Baralho();
        int ptsYan = 0;
        int ptsEdu = 0;

        bar.embaralha();
        for (int i = 0; i < 26; i++) {
            Carta yan = bar.recuperaCarta();
            Carta edu = bar.recuperaCarta();
            if (yan.getValor() > edu.getValor())
                ptsYan++;
            else if (yan.getValor() < edu.getValor())
                ptsEdu++;

            System.out.println("YAN " + yan + " X " + edu + " EDU");
        }
        System.out.println("YAN " + ptsYan);
        System.out.println("Edu " + ptsEdu);

    }
}
