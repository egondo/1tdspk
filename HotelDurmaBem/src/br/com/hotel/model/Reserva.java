package br.com.hotel.model;

import java.time.LocalDate;

public class Reserva {

    private long id;

    private LocalDate checkin;
    private LocalDate checkout;
    private Quarto quarto;

    @Override
    public String toString() {
        return "Reserva{" +
                "hospede=" + hospede.getNome() +
                ", checkin=" + checkin +
                ", checkout=" + checkout +
                ", quarto=" + quarto.getId() +
                '}';
    }

    private Pessoa hospede;

    private Status status = Status.ABERTA;

    public Reserva(Pessoa hospede, Quarto quarto, LocalDate checkin, LocalDate checkout) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public Pessoa getHospede() {
        return hospede;
    }

    public void setHospede(Pessoa hospede) {
        this.hospede = hospede;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
