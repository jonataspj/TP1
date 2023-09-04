package br.unitins.tp1.jonatas.tp1.model.repository;


import br.unitins.tp1.jonatas.tp1.model.entity.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado> {
    public List<Estado> findByNome(String nome) {
        return find("LOWER(nome) LIKE LOWER(?1)", "%" + nome + "%").list();
    }
}
