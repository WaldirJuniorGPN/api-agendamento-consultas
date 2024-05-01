package br.com.fiap.tech.challenge.api.agendamento.consultas.controller;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.PatientRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.PatientPageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.PatientResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private final PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public void create(@RequestBody @Valid PatientRequest patientRequest) {
        patientService.create(patientRequest);
    }

    @GetMapping
    public ResponseEntity<PatientPageResponse> listAll(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {
        return patientService.listAll(page, size);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> update(@PathVariable Long id, @RequestBody @Valid PatientRequest request) {
        return patientService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        patientService.delete(id);
    }
}
