package br.unitins.tp1.jonatas.tp1.resource;

import br.unitins.tp1.jonatas.tp1.model.dto.EstadoDTO;
import br.unitins.tp1.jonatas.tp1.model.dto.EstadoResponseDTO;
import br.unitins.tp1.jonatas.tp1.service.EstadoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/estado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoResource {
    @Inject
    EstadoService service;

    @POST
    @Path("create")
    public EstadoResponseDTO insert(EstadoDTO dto) {
        return service.insert(dto);
    }

    @PUT
    @Path("update/{id}")
    public EstadoResponseDTO update(EstadoDTO dto, @PathParam("id") Long id) {
        return service.update(dto, id);
    }

    @GET
    public List<EstadoResponseDTO> list() {
        return service.findAll();
    }

    @GET
    @Path("search/nome/{nome}")
    public List<EstadoResponseDTO> searchByName(@PathParam("nome") String nome) {
        return service.findByNome(nome);
    }

    @GET
    @Path("search/id/{id}")
    public EstadoResponseDTO searchById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @DELETE
    @Path("delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        return service.delete(id) ? Response.accepted().build() : Response.status(404).build();
    }
}
