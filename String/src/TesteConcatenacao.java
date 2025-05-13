public class TesteConcatenacao {

    //Irei apresentar a classe responsável por concatenar Strings
    //principalmente quando a concatenacao é executada várias vezes

    public static void main(String[] args) {
        long ini = System.currentTimeMillis();
        String s = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 300_000; i++) {
            //s = s + "carrocinha";
            sb.append("Estamos terminando o primeiro semestre de 2025");
        }
        long fim = System.currentTimeMillis();
        System.out.println("Tempo gasto " + (fim-ini) + "em ms");
    }
}
