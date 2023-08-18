package br.unitins.tp1.jonatsp.trabalho01.resource;


import br.unitins.tp1.jonatsp.trabalho01.entity.Evento;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Path("/eventos")
public class Eventos {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Evento> listar(@QueryParam("page") int page, @QueryParam("page_size") int pageSize) {
        if (pageSize < 25) pageSize = 25;
        else if (pageSize > 100) pageSize = 100;
        return Evento.findAll().page(page, pageSize).list();
    }

    @GET
    @Path("/hoje")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Evento> hoje() {
        LocalDateTime max = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        LocalDateTime min = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        return Evento.find("data between ?1 and ?2", min, max).list();
    }

}