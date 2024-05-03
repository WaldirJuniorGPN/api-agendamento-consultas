package br.com.fiap.tech.challenge.api.agendamento.consultas.service;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.SpecialtyRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.SpecialtyPageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.SpecialtyResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface SpecialtyService {

    void create(@Valid SpecialtyRequest request);

    ResponseEntity<SpecialtyResponse> update(Long id, @Valid SpecialtyRequest request);

    ResponseEntity<SpecialtyPageResponse> listAll(int page, int size, String sort);

    void delete(Long id);

    ResponseEntity<SpecialtyResponse> findById(Long id);
}
