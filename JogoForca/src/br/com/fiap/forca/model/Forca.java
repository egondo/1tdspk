package br.com.fiap.forca.model;

public class Forca {

    private String palavra;
    private int maxErros;
    private int erros;
    private String letrasChutadas;

    public Forca() {
        this.palavra = "Paraguai";
        this.maxErros = 6;
        this.erros = 0;
    }

    public boolean enforcou() {
        if (this.erros >= this.maxErros)
            return true;
        else
            return false;
        //return this.erros >= this.maxErros;
    }

    public String getPalavraAberta() {
        return this.palavra;
    }

    public int getErros() {
        return this.erros;
    }

    public void chuta(char letra) {
        letrasChutadas = letrasChutadas + letra;
        if (palavra.indexOf(letra) == -1) {
            this.erros++;
        }
    }

    public boolean acertou() {
        //TODO
    }

    public String getPalavraFechada() {
        //TODO
    }
}
