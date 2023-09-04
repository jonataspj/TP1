package br.unitins.tp1.jonatsp.trabalho.model.repository;

import br.unitins.tp1.jonatsp.trabalho.model.entity.Evento;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@ApplicationScoped
public class EventoRepository implements PanacheRepository<Evento> {

    public Evento create(Evento evento) {
        Evento e = new Evento();
        e.setNome(evento.getNome());
        e.setDescricao(evento.getDescricao());
        e.setData(evento.getData());
        e.setMaxParticipantes(evento.getMaxParticipantes());
        persist(e);
        return e;
    }

    /**
     * Atualiza um evento, o campo id informa qual evento alterar, os campos que forem null não serão alterados
     *
     * @param evento O evento que vai ser atualizado
     * @return A nova versão do evento
     */
    public Evento update(Evento evento) {
        if (evento.getId() == null) {
            throw new NotFoundException();
        }
        Evento e = findById(evento.getId());
        if (evento.getNome() != null) e.setNome(evento.getNome());
        if (evento.getDescricao() != null) e.setDescricao(evento.getDescricao());
        if (evento.getData() != null) e.setData(evento.getData());
        if (evento.getMaxParticipantes() != null) e.setMaxParticipantes(evento.getMaxParticipantes());
        persist(e);
        return e;
    }

    /**
     * @return Lista com eventos para o dia de hoje
     */
    public List<Evento> getTodayEvents() {
        LocalDateTime max = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        LocalDateTime min = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        return find("data between ?1 and ?2", min, max).list();
    }
}
