package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service.impl;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request.SpecialtyRequest;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.SpecialtyPageResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.SpecialtyResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.exception.SchedulingAppointmentsException;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.Specialty;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.repository.SpecialtyRepository;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service.SpecialtyService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.fiap.tech.challenge.api.scheduling.medical.appointments.exception.ErrorCode.SPECIALTY_NOT_FOUND;

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

    @Override
    public List<SpecialtyResponse> findByDoctorId(Long doctorId) {

        return repository.findSpecialtiesByDoctors_id(doctorId)
            .orElseThrow(
                () -> new SchedulingAppointmentsException(SPECIALTY_NOT_FOUND)
            )
            .stream().map(specialty ->
                mapper.map(specialty, SpecialtyResponse.class)
            ).toList();
    }
}
