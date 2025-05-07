public class ExemploAcessoString {

    public static void main(String[] args) {
        String s = "FIAP PAULISTA";

        int pos = 0;

        while(pos < s.length()) {
            char c = s.charAt(pos);
            System.out.println(c);
            pos++;
        }
    }
}
