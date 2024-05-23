package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request.ScheduleRequest;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.SchedulePageResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.ScheduleResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.Schedule;
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
