package br.com.fiap.enquete.test;

import br.com.fiap.enquete.business.EnqueteBusiness;
import br.com.fiap.enquete.model.Enquete;
import br.com.fiap.enquete.util.PerguntaTO;

import java.util.List;

public class TestePerguntaTO {

    public static void main(String[] args) {
        EnqueteBusiness negocio = new EnqueteBusiness();
        Enquete enq = new Enquete();
        enq.setId(8);

        try {
            List<PerguntaTO> lista = negocio.recuperaPerguntas(enq);
            for(PerguntaTO p : lista) {
                System.out.println(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
