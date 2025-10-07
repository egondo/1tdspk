package br.com.hotel.model;

public class Quarto {

    private long id;
    private int capacidade;
    private int quantidadeCamas;
    private String numero;

    public Quarto(){}

    public Quarto(int capacidade, long id, int quantidadeCamas) {
        this.capacidade = capacidade;
        this.id = id;
        this.quantidadeCamas = quantidadeCamas;
    }

    public Quarto(int capacidade, long id, int quantidadeCamas, String numero) {
        this(capacidade, id, quantidadeCamas);
        this.numero = numero;
    }


    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantidadeCamas() {
        return quantidadeCamas;
    }

    public void setQuantidadeCamas(int quantidadeCamas) {
        this.quantidadeCamas = quantidadeCamas;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
