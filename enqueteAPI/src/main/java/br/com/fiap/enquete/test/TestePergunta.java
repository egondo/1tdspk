package br.com.fiap.enquete.test;

import br.com.fiap.enquete.business.EnqueteBusiness;
import br.com.fiap.enquete.model.Enquete;
import br.com.fiap.enquete.model.Item;
import br.com.fiap.enquete.model.Pergunta;
import br.com.fiap.enquete.model.TipoPergunta;

public class TestePergunta {

    public static void main(String[] args) throws Exception {

        Enquete enq = new Enquete();
        enq.setId(8);
        Pergunta p = new Pergunta();
        p.setNumero(1);
        p.setEnunciado("Onde vc estuda?");
        p.setTipo(TipoPergunta.ABERTA);
        p.setEnquete(enq);

        EnqueteBusiness negocio = new EnqueteBusiness();
        negocio.cadastraPergunta(p);

        p = new Pergunta();
        p.setNumero(3);
        p.setEnunciado("Qual(is) pós graduações vc gostaria de fazer?");
        p.setTipo(TipoPergunta.MULTIPLA);
        p.setEnquete(enq);

        Item i = new Item();
        i.setDescricao("Data Science");
        p.addItem(i);

        i = new Item();
        i.setDescricao("Arquiteto de soluções Enterprise");
        p.addItem(i);

        i = new Item();
        i.setDescricao("Front-End avançado");
        p.addItem(i);

        i = new Item();
        i.setDescricao("Mobile Developer Advanced");
        p.addItem(i);

        negocio.cadastraPergunta(p);
        System.out.println("Perguntas cadastradas com sucesso!");

    }

    public static void main2(String[] args) throws Exception {

        Enquete enq = new Enquete();
        enq.setId(8);
        Pergunta p = new Pergunta();
        p.setNumero(2);
        p.setEnunciado("Qual a sua escolaridade completa 3?");
        p.setTipo(TipoPergunta.UNICA);
        p.setEnquete(enq);

        Item i = new Item();
        i.setDescricao("Superior incompleto");
        p.addItem(i);

        i = new Item();
        i.setDescricao("Superior completo");
        p.addItem(i);

        i = new Item();
        i.setDescricao("Pós graduado");
        p.addItem(i);

        i = new Item();
        i.setDescricao("Mestrado");
        p.addItem(i);

        i = new Item();
        i.setDescricao("Doutorado");
        p.addItem(i);


        EnqueteBusiness negocio = new EnqueteBusiness();
        negocio.cadastraPergunta(p);

    }
}
