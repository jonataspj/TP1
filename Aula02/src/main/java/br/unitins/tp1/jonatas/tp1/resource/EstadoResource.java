package br.unitins.tp1.jonatas.tp1.resource;

import br.unitins.tp1.jonatas.tp1.entity.Estado;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/estado")
public class EstadoResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> estados() {
        return Estado.listAll();
    }
}
