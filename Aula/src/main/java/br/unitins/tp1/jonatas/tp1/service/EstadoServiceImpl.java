package br.unitins.tp1.jonatas.tp1.service;

import br.unitins.tp1.jonatas.tp1.model.dto.EstadoDTO;
import br.unitins.tp1.jonatas.tp1.model.dto.EstadoResponseDTO;
import br.unitins.tp1.jonatas.tp1.model.entity.Estado;
import br.unitins.tp1.jonatas.tp1.model.repository.EstadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class EstadoServiceImpl implements EstadoService {
    @Inject
    EstadoRepository repository;

    @Override
    @Transactional
    public EstadoResponseDTO insert(EstadoDTO dto) {
        Estado e = new Estado();
        e.setNome(dto.getNome());
        e.setSigla(dto.getSigla());
        e.setDataCadastro(LocalDate.now());
        repository.persist(e);
        return EstadoResponseDTO.from(e);
    }

    @Override
    @Transactional
    public EstadoResponseDTO update(EstadoDTO dto, Long id) {
        Estado e = repository.findById(id);
        if (e != null) {
            if (dto.getNome() != null) e.setNome(dto.getNome());
            if (dto.getSigla() != null) e.setSigla(dto.getSigla());
            repository.persist(e);
            return EstadoResponseDTO.from(e);
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public EstadoResponseDTO findById(Long id) {
        return EstadoResponseDTO.from(repository.findById(id));
    }

    @Override
    public List<EstadoResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream().map(EstadoResponseDTO::from).toList();
    }

    @Override
    public List<EstadoResponseDTO> findAll() {
        return repository.streamAll().map(EstadoResponseDTO::from).toList();
    }
}
