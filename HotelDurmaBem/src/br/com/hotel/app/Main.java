package br.com.hotel.app;

import br.com.hotel.model.CentralReserva;
import br.com.hotel.model.Pessoa;
import br.com.hotel.model.Quarto;
import br.com.hotel.model.Reserva;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static int menu(Scanner tec) {
        System.out.println("HOTEL DURMA BEM");
        System.out.println("1) Reserva");
        System.out.println("2) Consultar Reserva");
        System.out.println("3) Sair");
        System.out.print("Opcao: ");
        return tec.nextInt();
    }

    public static void main(String[] args) {

        CentralReserva central = new CentralReserva();
        Scanner tec = new Scanner(System.in);
        int opcao = menu(tec);
        while(opcao != 3) {
            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = tec.next() + tec.nextLine();
                System.out.print("Telefone: ");
                String telefone = tec.nextLine();
                System.out.print("Qtd de hóspedes: ");
                String qtdHospedes = tec.nextLine();

                System.out.print("Checkin (aaaa-mm-dd)");
                LocalDate checkin = LocalDate.parse(tec.nextLine());

                System.out.print("Checkout (aaaa-mm-dd)");
                LocalDate checkout = LocalDate.parse(tec.nextLine());

                Quarto[] quartos = central.verificaDisponibilidade(checkin, checkout, Integer.parseInt(qtdHospedes));
                System.out.println("Escolha um dos quartos abaixo: ");
                for (int i = 0; i < quartos.length; i++) {
                    System.out.print(quartos[i].getId() + " " + quartos[i].getQuantidadeCamas() + "\t");
                }
                System.out.print("Informe o quarto: ");
                String idQuarto = tec.nextLine();

                Pessoa hospede = new Pessoa(1, nome, telefone, null);
                central.efetuaReserva(checkin, checkout, hospede, idQuarto);
                System.out.println("Reserva efetuada com sucesso");

            } else if (opcao == 2) {
                Reserva[] reservas = central.getReservas();
                for (Reserva r : reservas) {
                    if (r != null) {
                        System.out.println(r);
                    }
                }
            } else {
                System.out.println("Volte sempre ao nosso sistema!");
            }
            opcao = menu(tec);
        }
    }
}
