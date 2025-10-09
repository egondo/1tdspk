package br.com.fiap.enquete.test;

import br.com.fiap.enquete.business.EnqueteBusiness;
import br.com.fiap.enquete.model.Enquete;

public class TesteEnquete {

    public static void main(String[] args) {
        Enquete enq = new Enquete();
        enq.setNome("lazer");
        enq.setCriador("FIAP");
        try {
            EnqueteBusiness negocio = new EnqueteBusiness();
            negocio.cadastraEnquete(enq);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
