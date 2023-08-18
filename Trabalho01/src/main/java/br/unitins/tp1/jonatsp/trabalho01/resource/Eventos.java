package br.unitins.tp1.jonatsp.trabalho01.resource;


import br.unitins.tp1.jonatsp.trabalho01.entity.Evento;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;
import java.util.List;

@Path("/eventos")
public class Eventos {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Evento> listar() {
        return Evento.listAll();
    }

    @GET
    @Path("/hoje")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PanacheEntityBase> hoje() {
        return Evento
                .listAll()
                .stream()
                .filter(evento -> ((Evento) evento).data.toLocalDate().isEqual(LocalDate.now()))
                .toList();
    }
}