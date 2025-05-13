public class Exercicio5 {

    public int contaOcorrencia(String frase, String palavra) {
        int pos = 0, conta = 0;
        int resp = frase.indexOf(palavra, pos);
        while (resp != -1) {
            //System.out.println("Encontrei a palavra em " + resp);
            conta++;
            resp = frase.indexOf(palavra, resp + 1);
        }
        //System.out.println(palavra + " not found " + frase);
        return conta;
    }

    public static void main(String[] args) {
        String f = "ANA E MARIANA GOSTAM DE BANANA";
        String p = "ANA";

        Exercicio5 ex = new Exercicio5();
        int resp = ex.contaOcorrencia(f, p);
        System.out.println(p + " aparece " + resp + " vezes em " + f);
    }
}
