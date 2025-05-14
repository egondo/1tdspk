package br.com.fiap.forca.model;

public class Forca {

    private String palavra;
    private int maxErros;
    private int erros;
    private String letrasChutadas;

    public Forca() {
        this.palavra = "Sri Lanka";
        this.maxErros = 6;
        this.letrasChutadas = "";
        this.chuta(' ');
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
        String aux = this.getPalavraFechada();
        if (aux.indexOf('_') != -1)
            return false;
        else
            return true;
    }

    public String getPalavraFechada() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.palavra.length(); i++) {
            char letra = this.palavra.charAt(i);
            if (this.letrasChutadas.indexOf(letra) == -1)
                sb.append("_ ");
            else {
                sb.append(letra);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
