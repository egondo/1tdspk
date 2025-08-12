package br.com.fiap.heranca;

import java.time.LocalDate;

public class Poupanca extends Conta {

    //herdamos todos os atributos da poupanca
    private int diaAniversario;

    public boolean rendimento(double taxa) {
        LocalDate hoje = LocalDate.now();
        int dia = hoje.getDayOfMonth();
        if (dia == diaAniversario) {
            this.saldo = this.saldo + this.saldo * (taxa / 100.0); //a)
            //veja que o atributo saldo tem visibilidade protegida na superclasse
            //podemos resolver de 2 modos:
            //a) alterar a visibilidade do atributo saldo para protected
            //b) como o atributo saldo possui métodos acessores completos (get/set),
            //usamos eles na atualizacao do saldo

            //alternativa b
            //double aux = this.getSaldo();
            //aux = aux + aux * (taxa / 100.0);
            //this.setSaldo(aux);
            return true;
        }
        return false;
    }

    public int getDiaAniversario() {
        return diaAniversario;
    }

    public void setDiaAniversario(int diaAniversario) {
        if (diaAniversario == 31)
            this.diaAniversario = 1;
        else
            this.diaAniversario = diaAniversario;
    }
}
