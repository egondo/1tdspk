package br.com.fiap.baralho;

public class Carta {

    private int valor;
    private String naipe;

    public Carta(int valor, String naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public int getValor() {
        return valor;
    }

    public String getNaipe() {
        return naipe;
    }

    public String toString() {
        String imgNaipe = "";
        switch(naipe) {
            case "copas":
                imgNaipe = "♥"; //ALT+3
                break;
            case "paus":
                imgNaipe = "♣"; //ALT+5
                break;
            case "ouros":
                imgNaipe = "♦"; //ALT+4
                break;
            default:
                imgNaipe = "♠"; //ALT+6
        }

        if (valor == 1)
            return "A" + imgNaipe;
        else if (valor == 11)
            return "J" + imgNaipe;
        else if (valor == 12)
            return "Q" + imgNaipe;
        else if (valor == 13)
            return "K" + imgNaipe;
        else
            return valor + imgNaipe;
    }
}
