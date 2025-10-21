package br.com.fiap.enquete.util;

import br.com.fiap.enquete.model.TipoPergunta;

//Classe que representa informações transientes (o conjunto das informaçoes nao forma um objeto do modelo). É uma classe de transferência de informações (Transfer Object).

public class PerguntaTO {

    private long id;
    private String enunciado;
    private int numero;
    private TipoPergunta tipo;
    private long idItem;
    private String descricaoItem;

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
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

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
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

    @Override
    public String toString() {
        return "PerguntaTO{" +
                "descricaoItem='" + descricaoItem + '\'' +
                ", id=" + id +
                ", enunciado='" + enunciado + '\'' +
                ", numero=" + numero +
                ", tipo=" + tipo +
                ", idItem=" + idItem +
                '}';
    }
}
