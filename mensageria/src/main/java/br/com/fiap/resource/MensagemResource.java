package br.com.fiap.resource;

import br.com.fiap.model.Mensagem;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/mensagem")
public class MensagemResource {

    private List<Mensagem> lista = List.of(
            new Mensagem("CKP3", "API", "INFO", "1tdspk"),
            new Mensagem("Sprint4", "Uso de APIs", "WARNING", "Luis Silva"),
            new Mensagem("CHKP2", "Atraso na correcao", "FATAL", "Edu Gondo")
    );


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMensagens() {
        return Response.ok(lista).build();
    }


}
