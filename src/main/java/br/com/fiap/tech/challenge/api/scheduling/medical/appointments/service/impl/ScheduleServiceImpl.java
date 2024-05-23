package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service.impl;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request.ScheduleRequest;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.SchedulePageResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.ScheduleResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.exception.ErrorCode;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.exception.SchedulingAppointmentsException;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.Doctor;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.Schedule;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.repository.ScheduleRepository;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service.ScheduleService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    public static final int MAX_NUMBER_OF_WORKING_DAYS = 7;

    private final ScheduleRepository repository;
    private final ModelMapper mapper;

    public ScheduleServiceImpl(ScheduleRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Schedule create(ScheduleRequest request) {
        validateScheduleRequest(request);

        var schedule = mapper.map(request, Schedule.class);
        schedule.setDoctor(new Doctor(request.getDoctorId()));

        return repository.save(schedule);
    }

    @Override
    public ResponseEntity<SchedulePageResponse> listAll(int page, int size) {
        var pageRequest = PageRequest.of(page, size);
        var schedulePage = repository.findAll(pageRequest);

        return ResponseEntity.ok(mapper.map(schedulePage, SchedulePageResponse.class));
    }

    @Override
    public ResponseEntity<ScheduleResponse> findById(Long id) {
        var schedule = repository.findById(id).orElseThrow(
            () -> new SchedulingAppointmentsException(ErrorCode.SCHEDULE_NOT_FOUND));

        return ResponseEntity.ok(mapper.map(schedule, ScheduleResponse.class));
    }

    @Override
    public ResponseEntity<ScheduleResponse> update(Long id, ScheduleRequest scheduleRequest) {

        var schedule = repository.findById(id).orElseThrow(
            () -> new SchedulingAppointmentsException(ErrorCode.SCHEDULE_NOT_FOUND));

        var schedules = repository.findByDoctorIdAndWorkingDays(
                scheduleRequest.getDoctorId(), scheduleRequest.getWorkingDays().name()).orElse(List.of());

        if (!schedules.isEmpty() && !schedule.getWorkingDays().equals(scheduleRequest.getWorkingDays().name())) {
            validateDoctorScheduleDay(scheduleRequest, schedules);
        }

        mapper.map(scheduleRequest, schedule);
        schedule.setDoctor(new Doctor(scheduleRequest.getDoctorId()));
        repository.save(schedule);

        return ResponseEntity.ok(mapper.map(schedule, ScheduleResponse.class));
    }

    @Override
    public void delete(Long id) {
        var schedule = repository.findById(id).orElseThrow(
            () -> new SchedulingAppointmentsException(ErrorCode.SCHEDULE_NOT_FOUND));

        repository.delete(schedule);
    }

    @Override
    public ResponseEntity<List<ScheduleResponse>> listByDoctor(Long doctorId) {
        var schedules = repository.findByDoctorId(doctorId).orElse(List.of());
        List<ScheduleResponse> scheduleResponse = schedules.stream().map(schedule -> mapper.map(schedule, ScheduleResponse.class)).toList();

        return ResponseEntity.ok(scheduleResponse);
    }

    private void validateScheduleRequest(ScheduleRequest request) {
        var schedules = repository.findByDoctorId(request.getDoctorId()).orElse(List.of());
        validateMaxDoctorSchedule(schedules);
        validateDoctorScheduleDay(request, schedules);
    }

    private static void validateDoctorScheduleDay(ScheduleRequest request, List<Schedule> schedules) {
        schedules.stream().filter(schedule ->
                schedule.getWorkingDays().equals(request.getWorkingDays().name())).findAny().ifPresent(schedule -> {
            throw new SchedulingAppointmentsException(ErrorCode.SCHEDULE_FOUND_FOR_DOCTOR);
        });
    }

    private static void validateMaxDoctorSchedule(List<Schedule> schedules) {
        if (schedules.size() >= MAX_NUMBER_OF_WORKING_DAYS) {
            throw new SchedulingAppointmentsException(ErrorCode.MAX_DOCTOR_SCHEDULE_CREATED);
        }
    }
}
