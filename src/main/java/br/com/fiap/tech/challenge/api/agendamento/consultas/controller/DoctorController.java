package br.com.fiap.tech.challenge.api.agendamento.consultas.controller;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.DoctorRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.DoctorPageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.DoctorResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid DoctorRequest doctorRequest) {
        doctorService.create(doctorRequest);
    }

    @GetMapping
    public ResponseEntity<DoctorPageResponse> listAll(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        return doctorService.listAll(page, size);
    }

    @GetMapping("{id}")
    public ResponseEntity<DoctorResponse> findById(@PathVariable Long id) {

        return doctorService.findById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<DoctorResponse> update(@PathVariable Long id, @RequestBody @Valid DoctorRequest request) {

        return doctorService.update(id, request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        doctorService.delete(id);
    }

}
