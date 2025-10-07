package br.com.hotel.model;

public class Hotel {

    private long id;

    private String nome;

    private Quarto[] quartos;

    public Hotel(String nome, int simples, int duplos, int triplos) {
        this.nome = nome;
        this.id = 1;

        int totalQuartos = simples + duplos + triplos;
        /*quartos = new Quarto[totalQuartos];

        int auxSimples = 0, auxDuplos = 0, auxTriplos = 0;
        for (int i = 0; i < quartos.length; i++) {
            if (auxSimples < simples) {
                quartos[i] = new Quarto(1, "S" + (auxSimples + 1), 1);
                auxSimples++;
            }
            else if (auxDuplos < duplos) {
                if (Math.random() < 0.5)
                    quartos[i] = new Quarto(2, "D" + (auxDuplos + 1), 1);
                else
                    quartos[i] = new Quarto(2, "D" + (auxDuplos + 1), 2);
                auxDuplos++;
            }
            else if (auxTriplos < triplos) {
                if (Math.random() < 0.5)
                    quartos[i] = new Quarto(3, "T" + (auxTriplos + 1), 2);
                else
                    quartos[i] = new Quarto(3, "T" + (auxTriplos + 1), 3);
                auxTriplos++;
            }
        } */
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Quarto[] getQuartos() {
        return quartos;
    }

    public void setQuartos(Quarto[] quartos) {
        this.quartos = quartos;
    }
}

