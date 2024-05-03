package br.com.fiap.tech.challenge.api.agendamento.consultas.service.impl;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.SpecialtyRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.SpecialtyPageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.SpecialtyResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.exception.SchedulingAppointmentsException;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Specialty;
import br.com.fiap.tech.challenge.api.agendamento.consultas.repository.SpecialtyRepository;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.SpecialtyService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static br.com.fiap.tech.challenge.api.agendamento.consultas.exception.ErrorCode.SPECIALTY_NOT_FOUND;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository repository;

    private final ModelMapper mapper;

    public SpecialtyServiceImpl(SpecialtyRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(SpecialtyRequest request) {
        var specialty = mapper.map(request, Specialty.class);

        repository.save(specialty);
    }

    @Override
    public ResponseEntity<SpecialtyResponse> update(Long id, SpecialtyRequest request) {
        var specialty = repository.findById(id).orElseThrow(() -> new SchedulingAppointmentsException(SPECIALTY_NOT_FOUND));
        mapper.map(request, specialty);
        var specialtyResponse = mapper.map(repository.save(specialty), SpecialtyResponse.class);

        return ResponseEntity.ok(specialtyResponse);
    }

    @Override
    public ResponseEntity<SpecialtyPageResponse> listAll(int page, int size, String sort) {
        var pageable = PageRequest.of(page, size, Sort.by(sort));
        var specialties = repository.findAll(pageable);

        return ResponseEntity.ok(mapper.map(specialties, SpecialtyPageResponse.class));
    }

    @Override
    public void delete(Long id) {
        var specialty = repository.findById(id).orElseThrow(
                () -> new SchedulingAppointmentsException(SPECIALTY_NOT_FOUND)
        );

        repository.delete(specialty);
    }

    @Override
    public ResponseEntity<SpecialtyResponse> findById(Long id) {
        var specialty = repository.findById(id).orElseThrow(
                () -> new SchedulingAppointmentsException(SPECIALTY_NOT_FOUND)
        );
        var specialtyResponse = mapper.map(specialty, SpecialtyResponse.class);

        return ResponseEntity.ok(specialtyResponse);
    }
}
