package br.com.hotel.model;

import java.time.LocalDate;
import java.util.Random;

public class CentralReserva {

    private Hotel hotel;
    private Reserva[] reservas;
    private int posUltimaReserva;

    public CentralReserva() {
        this.hotel = new Hotel("Durma Bem", 10, 8, 5);
        this.reservas = new Reserva[1_000];
        this.posUltimaReserva = -1;
    }

    public Quarto[] verificaDisponibilidade(LocalDate checkin, LocalDate checkout, int numeroPessoas) {
        //Pegar todos os quartos do hotel, filtrá-los pela capacidade x numeroPessoas. Depois verifico
        //no vetor de reservas quais os quartos filtrados estão disponíveis para aquele intervalo de datas.

        Quarto[] quartos = hotel.getQuartos();
        Quarto[] resposta  = new Quarto[3];
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int j = random.nextInt(quartos.length);
            resposta[i] = quartos[j];
        }
        return resposta;
    }

    public void efetuaReserva(LocalDate checkin, LocalDate checkout, Pessoa hospede, String idQuarto) {
        Quarto[] quartos = hotel.getQuartos();
        int i = 0;
        while (i < quartos.length && !quartos[i].getId().equals(idQuarto)) {
            i++;
        }
        Reserva reserva = new Reserva(hospede, quartos[i], checkin, checkout);

        posUltimaReserva++;
        reservas[posUltimaReserva] = reserva;
    }

    public Reserva[] getReservas() {
        return reservas;
    }
}
