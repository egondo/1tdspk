package br.com.fiap.heranca;

public class UsaConta {

    public static void main(String[] args) {
        Conta c = new Conta();
        c.setAgencia(1234);
        c.setNumero(82944);
        c.setSaldo(1000.00);

        //Os métodos: toString, equals, hashCode, wait, etc são herdados da classe Object

        System.out.println(c.getClass());
    }
}
