package br.com.fiap.enquete.model;

import java.util.ArrayList;
import java.util.List;

public class Pergunta {

    private long id;
    private String enunciado;
    private int numero;
    private TipoPergunta tipo;
    private Enquete enquete;

    private List<Item> itens = new ArrayList<>();

    public void addItem(Item item) {
        this.itens.add(item);
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Enquete getEnquete() {
        return enquete;
    }

    public void setEnquete(Enquete enquete) {
        this.enquete = enquete;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoPergunta getTipo() {
        return tipo;
    }

    public void setTipo(TipoPergunta tipo) {
        this.tipo = tipo;
    }
}
