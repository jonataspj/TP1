package br.unitins.tp1.jonatas.tp1.resource;

import br.unitins.tp1.jonatas.tp1.entity.Estado;
import br.unitins.tp1.jonatas.tp1.repository.EstadoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/estado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoResource {
    @Inject
    EstadoRepository repository;

    @POST
    @Path("create")
    @Transactional
    public Estado insert(Estado estado) {
        Estado e = new Estado();
        e.setNome(estado.getNome());
        e.setSigla(estado.getSigla());
        repository.persist(e);
        return e;
    }

    @GET
    public List<Estado> list() {
        return repository.findAll().list();
    }

    @GET
    @Path("search/nome/{nome}")
    public List<Estado> searchByName(@PathParam("nome") String nome) {
        return repository.findByNome(nome);
    }

    @GET
    @Path("search/id/{id}")
    public Estado searchById(@PathParam("id") Long id) {
        return repository.findById(id);
    }

    @DELETE
    @Path("delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return repository.deleteById(id) ? Response.accepted().build() : Response.status(404).build();
    }
}
