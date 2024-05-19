package br.com.fiap.tech.challenge.api.agendamento.consultas.controller;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.ScheduleRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.SchedulePageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.ScheduleResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.ScheduleService;
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

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void create(@RequestBody @Valid ScheduleRequest scheduleRequest) {

        scheduleService.create(scheduleRequest);
    }

    @GetMapping
    public ResponseEntity<SchedulePageResponse> listAll(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size) {

        return scheduleService.listAll(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponse> findById(@PathVariable Long id) {

        return scheduleService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponse> update(@PathVariable Long id, @RequestBody @Valid ScheduleRequest scheduleRequest) {

        return scheduleService.update(id, scheduleRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        scheduleService.delete(id);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<ScheduleResponse>> listByDoctor(@PathVariable Long doctorId) {

        return scheduleService.listByDoctor(doctorId);
    }
}
