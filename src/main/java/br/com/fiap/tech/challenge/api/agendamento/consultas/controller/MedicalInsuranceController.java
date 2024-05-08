package br.com.fiap.tech.challenge.api.agendamento.consultas.controller;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.MedicalInsuranceRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.MedicalInsurancePageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.MedicalInsuranceResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.MedicalInsuranceService;
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

@RestController
@RequestMapping("/medical-insurances")
public class MedicalInsuranceController {

    private final MedicalInsuranceService medicalInsuranceService;

    public MedicalInsuranceController(MedicalInsuranceService medicalInsuranceService) {
        this.medicalInsuranceService = medicalInsuranceService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void create(@RequestBody @Valid MedicalInsuranceRequest request) {

        medicalInsuranceService.create(request);
    }

    @GetMapping
    public ResponseEntity<MedicalInsurancePageResponse> listAll(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size) {

        return medicalInsuranceService.listAll(page, size);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalInsuranceResponse> update(@PathVariable Long id,
                                                           @RequestBody MedicalInsuranceRequest request) {

        return medicalInsuranceService.update(id, request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalInsuranceResponse> findById(@PathVariable Long id) {

        return medicalInsuranceService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        medicalInsuranceService.delete(id);
    }
}
