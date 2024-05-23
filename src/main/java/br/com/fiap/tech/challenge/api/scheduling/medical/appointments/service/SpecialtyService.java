package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request.SpecialtyRequest;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.SpecialtyPageResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.SpecialtyResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SpecialtyService {

    void create(@Valid SpecialtyRequest request);

    ResponseEntity<SpecialtyResponse> update(Long id, @Valid SpecialtyRequest request);

    ResponseEntity<SpecialtyPageResponse> listAll(int page, int size, String sort);

    void delete(Long id);

    ResponseEntity<SpecialtyResponse> findById(Long id);

    List<SpecialtyResponse> findByDoctorId(Long id);
}
