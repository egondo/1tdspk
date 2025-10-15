package br.com.fiap.resource;

import br.com.fiap.model.Time;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/campeonato")
public class CampeonatoResource {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTime() {
        Time time = new Time("Palmeiras", "Allianz Park", "Abel Ferreira", 1901);
        return Response.ok(time).build();
    }


}
