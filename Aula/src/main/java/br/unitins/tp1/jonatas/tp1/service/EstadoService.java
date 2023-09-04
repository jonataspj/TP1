package br.unitins.tp1.jonatas.tp1.service;

import br.unitins.tp1.jonatas.tp1.model.dto.EstadoDTO;
import br.unitins.tp1.jonatas.tp1.model.dto.EstadoResponseDTO;

import java.util.List;

public interface EstadoService {
    EstadoResponseDTO insert(EstadoDTO dto);

    EstadoResponseDTO update(EstadoDTO dto, Long id);

    boolean delete(Long id);

    EstadoResponseDTO findById(Long id);

    List<EstadoResponseDTO> findByNome(String nome);

    List<EstadoResponseDTO> findAll();
}
