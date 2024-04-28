package br.com.fiap.tech.challenge.api.agendamento.consultas.service;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.AssistantRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.AssistantsPageResponse;
import org.springframework.http.ResponseEntity;

public interface AssistantService {

    void create(AssistantRequest request);

    ResponseEntity<AssistantsPageResponse> listAll(int page, int size);
}
