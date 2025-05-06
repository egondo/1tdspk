import br.com.fiap.Binario;
import br.com.fiap.Decimal;

public class Main {
    public static void main(String[] args) {
        Binario bin = new Binario(100);
        long valor = bin.getDecimal();
        System.out.println(valor);

        Decimal dec = new Decimal(34875);
        valor = dec.getBinario();
        System.out.println(valor);
    }
}