package br.unitins.tp1.jonatas.tp1.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/somar")
public class SomarResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test(@QueryParam("a") long a, @QueryParam("b") long b) {
        return String.valueOf(a + b);
    }
}
