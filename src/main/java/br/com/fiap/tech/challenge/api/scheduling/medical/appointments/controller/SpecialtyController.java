package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.controller;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request.SpecialtyRequest;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.SpecialtyPageResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.SpecialtyResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service.SpecialtyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/especialidade")
public class SpecialtyController {

    private final SpecialtyService service;

    public SpecialtyController(SpecialtyService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void create(@RequestBody @Valid SpecialtyRequest request) {

        service.create(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecialtyResponse> update(@PathVariable Long id, @RequestBody @Valid SpecialtyRequest request) {

        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecialtyResponse> findById(@PathVariable Long id) {

        return service.findById(id);
    }

    @GetMapping
    public ResponseEntity<SpecialtyPageResponse> listAll(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size,
                                                         @RequestParam(defaultValue = "name") String sort) {
        return service.listAll(page, size, sort);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
