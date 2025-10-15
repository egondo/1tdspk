package br.com.fiap.model;

public class Time {

    private String nome;
    private String estadio;
    private String tecnico;
    private int anoFundacao;

    public Time(String nome, String estadio, String tecnico, int anoFundacao) {
        this.nome = nome;
        this.estadio = estadio;
        this.tecnico = tecnico;
        this.anoFundacao = anoFundacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }
}
