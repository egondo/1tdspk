package br.com.fiap.heranca;

public class ContaCorrente extends Conta {

    private double limite;
    private int senha;
    public static double aliquotaCpmf = 0.0038;

    public boolean autentica(int numero, int senha) {
        if (numero == this.getNumero() && senha == this.senha) {
            return true;
        }
        else {
            return false;
        }
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public boolean alteraSenha(int numero, int senhaAtual, int senhaNova) {
        if (this.autentica(numero, senhaAtual)) {
            this.senha = senhaNova;
            return true;
        }
        else
            return false;
    }

    @Override
    public void sacar(double valor) {
        double cpmf = valor * aliquotaCpmf;
        super.sacar(valor + cpmf);
    }
}
