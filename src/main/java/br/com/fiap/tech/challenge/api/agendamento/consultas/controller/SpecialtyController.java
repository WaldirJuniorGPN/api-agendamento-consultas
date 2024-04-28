package br.com.fiap.tech.challenge.api.agendamento.consultas.controller;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.SpecialtyRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.SpecialtyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/especialidade")
public class SpecialtyController {

    private final SpecialtyService service;

    public SpecialtyController(SpecialtyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SpecialtyRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid SpecialtyRequest request) {
        return service.update(id, request);
    }

    @GetMapping
    public ResponseEntity<?> listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(defaultValue = "name") String sort) {
        return service.listAll(page, size, sort);
    }

}
