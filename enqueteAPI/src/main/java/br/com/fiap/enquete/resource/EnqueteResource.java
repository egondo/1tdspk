package br.com.fiap.enquete.resource;

import br.com.fiap.enquete.business.EnqueteBusiness;
import br.com.fiap.enquete.model.Enquete;
import br.com.fiap.enquete.model.Item;
import br.com.fiap.enquete.model.Pergunta;
import br.com.fiap.enquete.util.PerguntaTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/enquetes")
public class EnqueteResource {


    @GET
    @Path("/perguntas/{idEnquete}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerguntas(@PathParam("idEnquete") long idEnquete) {
        EnqueteBusiness neg = new EnqueteBusiness();
        Enquete enq = new Enquete();
        enq.setId(idEnquete);
        List<PerguntaTO> lista = null;
        try {
            lista = neg.recuperaPerguntas(enq);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity(e.getMessage()).build();
        }
        return Response.ok(lista).build();
        //return Response.status(200).entity(lista).build();
    }

    @POST
    @Path("/perguntas/{idEnquete}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastraPergunta(PerguntaTO p, @PathParam("idEnquete")long idEnquete) {
        //System.out.println(p.getNumero() + " " + p.getEnunciado());
        //System.out.println(p.getDescricaoItem());
        //System.out.println(p.getTipo());
        Enquete enq = new Enquete();
        enq.setId(idEnquete);

        Pergunta pergunta = new Pergunta();
        pergunta.setTipo(p.getTipo());
        pergunta.setNumero(p.getNumero());
        pergunta.setEnunciado(p.getEnunciado());
        pergunta.setEnquete(enq);

        EnqueteBusiness negocio = new EnqueteBusiness();

        try {
            negocio.cadastraPergunta(pergunta);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(401).entity(e.getMessage()).build();
            //throw new RuntimeException(e);
        }
        return Response.status(201).entity(pergunta).build();
    }

    @POST
    @Path("/perguntas/multiplas/{idEnquete}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastraPerguntaMultipla(List<PerguntaTO> lista, @PathParam("idEnquete")long idEnquete) {
        Enquete enq = new Enquete();
        enq.setId(idEnquete);

        Pergunta pergunta = new Pergunta();
        List<Item> itens = new ArrayList<>();

        for(PerguntaTO p : lista) {
            pergunta.setTipo(p.getTipo());
            pergunta.setNumero(p.getNumero());
            pergunta.setEnunciado(p.getEnunciado());
            pergunta.setEnquete(enq);
            Item item = new Item();
            item.setDescricao(p.getDescricaoItem());
            itens.add(item);
        }

        pergunta.setItens(itens);
        EnqueteBusiness negocio = new EnqueteBusiness();

        try {
            negocio.cadastraPergunta(pergunta);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(401).entity(e.getMessage()).build();
            //throw new RuntimeException(e);
        }
        return Response.status(201).entity(pergunta).build();
    }






    @PUT
    @Path("/perguntas")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alteraPergunta(Pergunta pergunta) {
        EnqueteBusiness neg = new EnqueteBusiness();
        try {
            neg.alteraPergunta(pergunta);
        }
        catch(Exception e) {
            e.printStackTrace();
            return Response.status(404).entity(e.getMessage()).build();
        }
        return Response.status(200).entity(pergunta).build();
    }


    //insomnia ou postman
}
