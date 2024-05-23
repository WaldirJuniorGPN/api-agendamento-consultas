package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request.PatientRequest;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.PatientPageResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.PatientResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface PatientService {

    void create(PatientRequest patientRequest);

    ResponseEntity<PatientPageResponse> listAll(int page, int size);

    ResponseEntity<PatientResponse> update(Long id, @Valid PatientRequest request);

    void delete(Long id);

    ResponseEntity<PatientResponse> findById(Long id);
}
