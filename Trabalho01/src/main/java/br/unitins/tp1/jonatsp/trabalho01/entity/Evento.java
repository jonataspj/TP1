package br.unitins.tp1.jonatsp.trabalho01.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class Evento extends PanacheEntity {
    public String nome;
    public String descricao;
    public LocalDateTime data;
    public Long maxParticipantes;
}
