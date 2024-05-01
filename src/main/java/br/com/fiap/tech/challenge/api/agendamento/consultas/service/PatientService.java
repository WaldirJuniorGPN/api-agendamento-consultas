package br.com.fiap.tech.challenge.api.agendamento.consultas.service;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.PatientRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.PatientPageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.PatientResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface PatientService {

    void create(PatientRequest patientRequest);

    ResponseEntity<PatientPageResponse> listAll(int page, int size);

    ResponseEntity<PatientResponse> update(Long id, @Valid PatientRequest request);

    void delete(Long id);
}
