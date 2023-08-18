package br.unitins.tp1.jonatas.tp1.resource;

import br.unitins.tp1.jonatas.tp1.entity.MyEntity;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyEntity hello() {
        return new MyEntity("Olá");
    }


}
