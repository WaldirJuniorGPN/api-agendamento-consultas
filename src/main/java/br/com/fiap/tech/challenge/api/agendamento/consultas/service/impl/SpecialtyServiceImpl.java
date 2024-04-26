package br.com.fiap.tech.challenge.api.agendamento.consultas.service.impl;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.SpecialtyRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.SpecialtyPageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Specialty;
import br.com.fiap.tech.challenge.api.agendamento.consultas.repository.SpecialtyRepository;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.SpecialtyService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository repository;

    private final ModelMapper mapper;

    public SpecialtyServiceImpl(SpecialtyRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<?> create(SpecialtyRequest request) {
        var specialty = mapper.map(request, Specialty.class);
        repository.save(specialty);

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<?> update(Long id, SpecialtyRequest request) {
        var specialty = repository.findById(id).orElseThrow(() -> new RuntimeException("Especialização não encontrada"));
        mapper.map(request, specialty);

        return ResponseEntity.ok(repository.save(specialty));
    }

    @Override
    public ResponseEntity<?> listAll(int page, int size, String sort) {
        var pageable = PageRequest.of(page, size, Sort.by(sort));
        var specialties = repository.findAll(pageable);

        return ResponseEntity.ok(mapper.map(specialties, SpecialtyPageResponse.class));
    }
}
