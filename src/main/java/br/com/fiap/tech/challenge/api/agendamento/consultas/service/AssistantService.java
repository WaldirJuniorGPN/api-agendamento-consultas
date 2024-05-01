package br.com.fiap.tech.challenge.api.agendamento.consultas.service;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.AssistantRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.AssistantResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.AssistantsPageResponse;
import org.springframework.http.ResponseEntity;

public interface AssistantService {

    void create(AssistantRequest request);

    ResponseEntity<AssistantsPageResponse> listAll(int page, int size);

    ResponseEntity<AssistantResponse> update(Long id, AssistantRequest request);

    void delete(Long id);

    ResponseEntity<AssistantResponse> findById(Long id);
}
