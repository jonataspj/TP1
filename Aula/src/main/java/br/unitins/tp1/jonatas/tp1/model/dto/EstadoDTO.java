package br.unitins.tp1.jonatas.tp1.model.dto;

import java.util.Objects;

public class EstadoDTO {
    private final String nome;
    private final String sigla;

    public EstadoDTO(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoDTO estadoDTO = (EstadoDTO) o;
        return Objects.equals(getNome(), estadoDTO.getNome()) && Objects.equals(getSigla(), estadoDTO.getSigla());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getSigla());
    }
}
