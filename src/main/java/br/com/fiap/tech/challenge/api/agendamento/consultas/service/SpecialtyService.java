package br.com.fiap.tech.challenge.api.agendamento.consultas.service;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.SpecialtyRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface SpecialtyService {

    ResponseEntity<?> create(@Valid SpecialtyRequest request);

    ResponseEntity<?> update(Long id, @Valid SpecialtyRequest request);

    ResponseEntity<?> listAll(int page, int size, String sort);
}
