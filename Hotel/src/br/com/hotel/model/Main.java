public class Main() {

    public static void main(String[] args) {
        int capacidade  = 1;
        LocalDate ini = LocalDate.of(2025, 10, 1);
        LocalDate fim = LocalDate.of(2025, 10, 5);
        QuartoRepository repositorio = new QuartoRepository();

        List<Quarto> quartos = repositorio.findAvailable(capacidade, ini, fim);
        for(Quarto q in quartos) {
            System.out.println(q.getNumero() + " " + q.getCapacidade());
        }
    }


}