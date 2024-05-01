package br.com.fiap.tech.challenge.api.agendamento.consultas.controller;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.AssistantRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.AssistantsPageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.AssistantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/assistants")
public class AssistantController {

    private final AssistantService assistantService;

    public AssistantController(AssistantService assistantService) {
        this.assistantService = assistantService;
    }

    @ResponseStatus(value = CREATED)
    @PostMapping
    public void create(@RequestBody AssistantRequest request) {

        assistantService.create(request);

    }

    @GetMapping
    public ResponseEntity<AssistantsPageResponse> listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        return assistantService.listAll(page, size);
    }

}
