package br.com.fiap.tech.challenge.api.agendamento.consultas.service;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.ScheduleRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.SchedulePageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.ScheduleResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Schedule;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScheduleService {
    Schedule create(ScheduleRequest schedule);

    ResponseEntity<SchedulePageResponse> listAll(int page, int size);

    ResponseEntity<ScheduleResponse> findById(Long id);

    ResponseEntity<ScheduleResponse> update(Long id, ScheduleRequest scheduleRequest);

    void delete(Long id);

    ResponseEntity<List<ScheduleResponse>> listByDoctor(Long doctorId);
}
