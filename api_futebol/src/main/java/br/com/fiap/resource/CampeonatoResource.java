package br.com.fiap.resource;

import br.com.fiap.model.Time;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/campeonato")
public class CampeonatoResource {


    public Response getTime() {
        Time time = new Time("Palmeiras", "Allianz Park", "Abel Ferreira", 1901);



        return Response.ok().build();
    }


}
