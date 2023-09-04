package br.unitins.tp1.jonatsp.trabalho.resource;


import br.unitins.tp1.jonatsp.trabalho.model.entity.Evento;
import br.unitins.tp1.jonatsp.trabalho.model.repository.EventoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/eventos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA})

public class EventoResource {
    @Inject
    private EventoRepository repository;

    /**
     * Lista todos eventos disponíveis
     * @param page     numero da página
     * @param pageSize quantidade de itens por página
     * @return Lista de eventos
     */
    @GET
    public List<Evento> list(@DefaultValue("0") @QueryParam("page") int page,
                               @DefaultValue("25") @QueryParam("page_size") int pageSize) {

        return repository.findAll().page(page, pageSize).list();
    }

    @GET
    @Path("/today")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Evento> today() {
        return repository.getTodayEvents();
    }

    @POST
    @Path("/create")
    @Transactional
    public Evento create(Evento evento) {
        return repository.create(evento);
    }


    @PUT
    @Path("/update")
    @Transactional
    public Evento update(Evento evento) {
        return repository.update(evento);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        if (repository.deleteById(id)) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}