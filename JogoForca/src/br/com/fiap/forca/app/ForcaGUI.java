package br.com.fiap.forca.app;

import br.com.fiap.forca.model.Forca;

import javax.swing.*;

public class ForcaGUI {

    public static void main(String[] args) {
        Forca f = new Forca();
        while (!f.acertou() && !f.enforcou()) {
            String s = f.getPalavraFechada();

            String msg = s + "\nErros: " + f.getErros() + "\nLetra:";
            String resp = JOptionPane.showInputDialog(msg);
            f.chuta(resp.charAt(0));
        }

        if (f.acertou()) {
            JOptionPane.showMessageDialog(null,
                    "Parabéns, vc acerto: " + f.getPalavraAberta());
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Vc foi enforcado: " + f.getPalavraAberta());
        }
    }
}
