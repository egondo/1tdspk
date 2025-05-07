package br.com.fiap.cofasi.model;

public class Aplicacao {

    public static void main(String[] args) {

        Cliente c = new Cliente("Edu", "(11) 88382092");

        Pet cachorro = new Pet("Dog", c, "Cachorro");

        //c = null;

        System.out.println(c);

        Pessoa p = new Pessoa();
        //Esse erro acontece porque o atributo nome não foi inicializado.
        //p.setNome("Joao Augusto Ferreira");
        
        //System.out.println(p.getNome().toUpperCase());
        String nome = p.getNome();
        System.out.println(nome.toUpperCase());
    }
}
