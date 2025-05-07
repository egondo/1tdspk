import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String s = "\"Ciência da Computação está tão relacionada aos " +
                "computadores quanto a Astronomia aos telescópios\"";
        System.out.println(s);
        System.out.println("Aluno\tNota");
        System.out.println("Pedro\t8.5");
        System.out.println("Renato\t7.6");
        System.out.println("Andre\t5.7");

        System.out.println("O caracter \\ representa o escape no Java");

        Scanner tec = new Scanner(System.in);
        System.out.print("Informe a saudacao: ");
        String saudacao = tec.nextLine();
        if (saudacao.equals("Bom dia!"))
            System.out.println("Igual 1");
        else
            System.out.println("Diferente 1");

        //aqui vai dar diferente. Pq eles são objeto diferentes
        if (saudacao == "Bom dia!")
            System.out.println("Igual 2");
        else
            System.out.println("Diferente 2");

        //Exemplo do == dando verdadeiro
        String t = saudacao;
        if (t == saudacao)
            System.out.println("Igual 3");
        else
            System.out.println("Diferente 3");


    }
}