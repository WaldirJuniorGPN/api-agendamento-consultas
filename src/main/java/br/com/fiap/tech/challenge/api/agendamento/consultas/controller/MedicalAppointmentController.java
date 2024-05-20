package br.com.fiap.tech.challenge.api.agendamento.consultas.controller;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.MedicalReportRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.MedicalAppointmentRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.MedicalAppointmentPageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.MedicalAppointmentResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.MedicalAppointmentStatus;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.MedicalAppointmentService;
import jakarta.validation.Valid;
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
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/medical-appointments")
public class MedicalAppointmentController {

    private final MedicalAppointmentService medicalAppointmentService;

    public MedicalAppointmentController(MedicalAppointmentService medicalAppointmentService) {
        this.medicalAppointmentService = medicalAppointmentService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void create(@RequestBody @Valid MedicalAppointmentRequest request) {

        medicalAppointmentService.create(request);
    }

    @GetMapping
    public ResponseEntity<MedicalAppointmentPageResponse> listAllMedicalAppointment(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return medicalAppointmentService.listAllMedicalAppointment(page, size);
    }

    @GetMapping("/{status}")
    public ResponseEntity<MedicalAppointmentPageResponse> listAllMedicalAppointmentByStatus(
            @PathVariable MedicalAppointmentStatus status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return medicalAppointmentService.listAllMedicalAppointmentByStatus(status, page, size);
    }

    @PutMapping("/cancel/{id}")
    @ResponseStatus(NO_CONTENT)
    public void cancel(@PathVariable Long id) {

        medicalAppointmentService.cancel(id);
    }

    @PutMapping("/reschedule/{id}")
    public ResponseEntity<MedicalAppointmentResponse> reschedule(@PathVariable Long id, @RequestBody @Valid MedicalAppointmentRequest request) {

        return medicalAppointmentService.reschedule(id, request);
    }

    @PutMapping("/confirm/{id}")
    @ResponseStatus(NO_CONTENT)
    public void confirm(@PathVariable Long id) {

        medicalAppointmentService.confirm(id);
    }

    @PutMapping("/finish/{id}")
    @ResponseStatus(NO_CONTENT)
    public void finish(@PathVariable Long id, @RequestBody @Valid MedicalReportRequest medicalReportRequest) {

        medicalAppointmentService.finish(id, medicalReportRequest);
    }
}
