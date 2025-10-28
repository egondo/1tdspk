package br.com.fiap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Documento implements XMLizable {

    private String tipo;
    private LocalDate expedicao;
    private String numero;
    private String nome;

    public LocalDate getExpedicao() {
        return expedicao;
    }

    public void setExpedicao(LocalDate expedicao) {
        this.expedicao = expedicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toXML() {
        return "<doc numero='" + numero + "'>" +
                "<tipo>" + tipo + "</tipo>" +
                "<data>" + expedicao + "</data>" +
                "<nome>" + nome + "</nome></doc>";
    }

    public static void main(String[] args) {
        Documento d1 = new Documento();
        d1.setTipo("RG");
        d1.setNumero("2343244-9");
        d1.setNome("Mauricio Vilela");
        d1.setExpedicao(LocalDate.of(2002, 3, 25));

        Documento d2 = new Documento();
        d2.setTipo("Passaporte");
        d2.setNumero("92384230-29");
        d2.setNome("Karina Fernandes");
        d2.setExpedicao(LocalDate.of(2020, 8, 15));


        List<XMLizable> lista = new ArrayList<>();
        lista.add(d1);
        lista.add(d2);

        for(XMLizable obj : lista) {
            System.out.println(obj.toXML());
        }

        

    }
}
