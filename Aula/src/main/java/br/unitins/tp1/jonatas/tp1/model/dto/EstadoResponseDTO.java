package br.unitins.tp1.jonatas.tp1.model.dto;

import br.unitins.tp1.jonatas.tp1.model.entity.Estado;

public record EstadoResponseDTO(
        Long id,
        String nome,
        String sigla) {

    public static EstadoResponseDTO from(Estado e) {
        return new EstadoResponseDTO(e.getId(), e.getNome(), e.getSigla());
    }
}
