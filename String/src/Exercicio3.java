public class Exercicio3 {

    public String substitui(String frase, char letra) {
        //return frase.replace(letra, '*');
        String saida = "";
        int i = 0;
        while (i < frase.length()) {
            char c = frase.charAt(i);
            if (c == letra) {
                saida = saida + '*';
            }
            else {
                saida = saida + c;
            }
            i++;
        }
        return saida;
    }

    public static void main(String[] args) {
        Exercicio3 ex = new Exercicio3();
        String saida = ex.substitui("Jabuticaba", 'a');
        System.out.println(saida);
    }
}
