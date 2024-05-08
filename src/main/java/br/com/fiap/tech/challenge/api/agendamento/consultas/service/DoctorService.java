package br.com.fiap.tech.challenge.api.agendamento.consultas.service;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.DoctorRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.DoctorPageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.DoctorResponse;
import org.springframework.http.ResponseEntity;

public interface DoctorService {
    void create(DoctorRequest doctorRequest);

    ResponseEntity<DoctorPageResponse> listAll(int page, int size);

    ResponseEntity<DoctorResponse> findById(Long id);

    ResponseEntity<DoctorResponse> update(Long id, DoctorRequest request);

    void delete(Long id);
}
