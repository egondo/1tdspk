public class ExemploProcuraString {

    public static void main(String[] args) {
        String texto = "Segue aqui uma lista de frases de efeito de algumas figuras importantes:" +
                "\n\"Penso, logo existo\"" +
                "\n\"Telescopio esta para Astronomia assim como computadores para a Ciencia da Computacao\"" +
                "\n\"Somente posso mostrar a porta, vc que deve atravessa-la\"";

        System.out.println(texto);

        int pos = texto.indexOf('A');
        System.out.println(pos);

        pos = texto.indexOf('X');
        System.out.println(pos);

        pos = texto.indexOf('C');
        System.out.println(pos);

        /*****Procurando todas substrings no texto ***/

        pos = texto.indexOf("o");
        while (pos != -1) {
            System.out.println(pos);
            pos = texto.indexOf("o", pos + 1);
        }

    }
}
