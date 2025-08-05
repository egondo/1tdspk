package br.com.hotel.model;

public class Quarto {

    private String id;
    private int capacidade;
    private int quantidadeCamas;
    private int numero;


    public Quarto(int capacidade, String id, int quantidadeCamas) {
        this.capacidade = capacidade;
        this.id = id;
        this.quantidadeCamas = quantidadeCamas;
    }

    public Quarto(int capacidade, String id, int quantidadeCamas, int numero) {
        this(capacidade, id, quantidadeCamas);
        this.numero = numero;
    }


    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantidadeCamas() {
        return quantidadeCamas;
    }

    public void setQuantidadeCamas(int quantidadeCamas) {
        this.quantidadeCamas = quantidadeCamas;
    }
}
