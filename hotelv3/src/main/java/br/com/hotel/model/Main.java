package br.com.hotel.model;

import br.com.hotel.repository.QuartoRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        int capacidade  = 1;
        LocalDate ini = LocalDate.of(2025, 10, 1);
        LocalDate fim = LocalDate.of(2025, 10, 5);
        QuartoRepository repositorio = new QuartoRepository();

        List<Quarto> quartos = repositorio.findAvailable(capacidade, ini, fim);
        for(Quarto q : quartos) {
            System.out.println(q.getNumero() + " " + q.getCapacidade());
        }
    }


}