package br.com.fiap.tech.challenge.api.agendamento.consultas.service.impl;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.AssistantRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.AssistantResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.AssistantsPageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.exception.ErrorCode;
import br.com.fiap.tech.challenge.api.agendamento.consultas.exception.SchedulingAppointmentsException;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Assistant;
import br.com.fiap.tech.challenge.api.agendamento.consultas.repository.AssistantRepository;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.AssistantService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AssistantServiceImpl implements AssistantService {

    private final AssistantRepository repository;

    private final ModelMapper mapper;

    public AssistantServiceImpl(AssistantRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(AssistantRequest request) {
        var assistant = mapper.map(request, Assistant.class);

        repository.save(assistant);
    }

    @Override
    public ResponseEntity<AssistantsPageResponse> listAll(int page, int size) {
        var pageable = PageRequest.of(page, size);
        var assistants = repository.findAll(pageable);

        return ResponseEntity.ok(mapper.map(assistants, AssistantsPageResponse.class));
    }

    @Override
    public ResponseEntity<AssistantResponse> update(Long id, AssistantRequest request) {
        var assistant = repository.findById(id).orElseThrow(
                () -> new SchedulingAppointmentsException(ErrorCode.ASSISTANT_NOT_FOUND)
        );
        mapper.map(request, assistant);
        var assistantResponse = mapper.map(repository.save(assistant), AssistantResponse.class);

        return ResponseEntity.ok(assistantResponse);
    }

    @Override
    public void delete(Long id) {
        var assistant = repository.findById(id).orElseThrow(
                () -> new SchedulingAppointmentsException(ErrorCode.ASSISTANT_NOT_FOUND)
        );

        repository.delete(assistant);
    }

    @Override
    public ResponseEntity<AssistantResponse> findById(Long id) {
        var assistant = repository.findById(id).orElseThrow(
                () -> new SchedulingAppointmentsException(ErrorCode.ASSISTANT_NOT_FOUND)
        );
        var assistantResponse = mapper.map(assistant, AssistantResponse.class);

        return ResponseEntity.ok(assistantResponse);
    }
}
