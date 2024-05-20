package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service.impl;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request.MedicalReportRequest;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request.MedicalAppointmentRequest;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.MedicalAppointmentPageResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.MedicalAppointmentResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.ScheduleResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.exception.SchedulingAppointmentsException;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.Doctor;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.Patient;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.MedicalAppointment;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.MedicalAppointmentStatus;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.repository.MedicalAppointmentRepository;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service.DoctorService;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service.PatientService;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service.MedicalAppointmentService;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service.ScheduleService;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.exception.ErrorCode;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static java.time.LocalDate.now;
import static java.time.LocalTime.parse;
import static java.util.Objects.nonNull;

@Service
public class MedicalAppointmentServiceImpl implements MedicalAppointmentService {

    public static final int CHANGE_DEADLINE = 2;
    public static final LocalDate YESTERDAY = LocalDate.now().minusDays(1);
    private final MedicalAppointmentRepository medicalAppointmentRepository;

    private final DoctorService doctorService;

    private final PatientService patientService;

    private final ScheduleService scheduleService;

    private final ModelMapper mapper;

    public MedicalAppointmentServiceImpl(MedicalAppointmentRepository medicalAppointmentRepository, DoctorService doctorService, PatientService patientService, ScheduleService scheduleService, ModelMapper mapper) {
        this.medicalAppointmentRepository = medicalAppointmentRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.scheduleService = scheduleService;
        this.mapper = mapper;
    }

    @Override
    public void create(MedicalAppointmentRequest request) {
        if (parse(request.getStartHour()).isBefore(LocalTime.now())) {
            throw new SchedulingAppointmentsException(ErrorCode.INVALID_SCHEDULE_HOUR);
        }
        validateRequest(request);

        var medicalAppointment = new MedicalAppointment();
        medicalAppointment.setDate(request.getDate());
        medicalAppointment.setStatus(MedicalAppointmentStatus.SCHEDULED);
        medicalAppointment.setStartHour(request.getStartHour());
        medicalAppointment.setDoctor(new Doctor(request.getDoctorId()));
        medicalAppointment.setPatient(new Patient(request.getPatientId()));

        medicalAppointmentRepository.save(medicalAppointment);
        sendNotification();
    }

    @Override
    public ResponseEntity<MedicalAppointmentPageResponse> listAllMedicalAppointmentByStatus(
            MedicalAppointmentStatus status,
            int page,
            int size) {

        var pageable = PageRequest.of(page, size);
        var medicalAppointments = medicalAppointmentRepository.findByStatus(status.name(), pageable);

        return ResponseEntity.ok(mapper.map(medicalAppointments, MedicalAppointmentPageResponse.class));
    }

    @Override
    public void cancel(Long id) {
        var medicalAppointment = medicalAppointmentRepository.findById(id)
                .orElseThrow(() -> new SchedulingAppointmentsException(ErrorCode.INVALID_SCHEDULE_DAY));

        if (medicalAppointment.getDate().isBefore(now().plusDays(CHANGE_DEADLINE))) {
            throw new SchedulingAppointmentsException(ErrorCode.NOT_POSSIBLE_TO_CANCEL_APPOINTMENT);
        }

        medicalAppointment.setStatus(MedicalAppointmentStatus.CANCELED);
        medicalAppointmentRepository.save(medicalAppointment);
        sendNotification();
        payment();
    }

    @Override
    public ResponseEntity<MedicalAppointmentResponse> reschedule(Long id, MedicalAppointmentRequest request) {
        var medicalAppointment = medicalAppointmentRepository.findById(id)
                .orElseThrow(() -> new SchedulingAppointmentsException(ErrorCode.MEDICAL_APPOINTMENT_NOT_FOUND));

        if (request.getDate().isBefore(now().plusDays(CHANGE_DEADLINE))) {
            throw new SchedulingAppointmentsException(ErrorCode.NOT_POSSIBLE_TO_RESCHEDULE_APPOINTMENT);
        }
        
        validateRequest(request);

        mapper.map(request, medicalAppointment);
        medicalAppointment.setStatus(MedicalAppointmentStatus.SCHEDULED);
        medicalAppointmentRepository.save(medicalAppointment);

        sendNotification();

        return ResponseEntity.ok(mapper.map(medicalAppointment, MedicalAppointmentResponse.class));
    }

    @Override
    public void confirm(Long id) {
        var medicalAppointment = medicalAppointmentRepository.findById(id)
                .orElseThrow(() -> new SchedulingAppointmentsException(ErrorCode.MEDICAL_APPOINTMENT_NOT_FOUND));

        medicalAppointment.setStatus(MedicalAppointmentStatus.CONFIRMED);

        medicalAppointmentRepository.save(medicalAppointment);
        payment();
    }

    @Override
    public void finish(Long id, MedicalReportRequest medicalReportRequest) {
        var medicalAppointment = medicalAppointmentRepository.findById(id)
                .orElseThrow(() -> new SchedulingAppointmentsException(ErrorCode.MEDICAL_APPOINTMENT_NOT_FOUND));

        medicalAppointment.setMedicalReport(medicalReportRequest.getMedicalReport());
        medicalAppointment.setStatus(MedicalAppointmentStatus.FINISHED);

        medicalAppointmentRepository.save(medicalAppointment);
    }

    @Override
    public ResponseEntity<MedicalAppointmentPageResponse> listAllMedicalAppointment(int page, int size) {
        var pageable = PageRequest.of(page, size);
        var medicalAppointments = medicalAppointmentRepository.findAll(pageable);

        return ResponseEntity.ok(mapper.map(medicalAppointments, MedicalAppointmentPageResponse.class));
    }

    @Override
    public ResponseEntity<List<MedicalAppointmentResponse>> findByDoctorAndStatusIsNot(Long doctorId, MedicalAppointmentStatus medicalAppointmentStatus) {

        return ResponseEntity.ok(medicalAppointmentRepository.findByDoctorIdAndStatusIsNotAndDateIsAfter(doctorId, medicalAppointmentStatus.name(), YESTERDAY)
                .orElseThrow(() -> new SchedulingAppointmentsException(ErrorCode.MEDICAL_APPOINTMENT_NOT_FOUND))
                .stream().map(medicalAppointment -> mapper.map(medicalAppointment, MedicalAppointmentResponse.class)).toList());
    }


    private void validateRequest(MedicalAppointmentRequest request) {
        validateDay(request);
        validateDoctor(request);
        validatePatient(request);

        validateMedicalAppointmentExists(request);

        var scheduleResponses = scheduleService.listByDoctor(request.getDoctorId()).getBody().stream()
                .filter(scheduleResponse -> scheduleResponse.getWorkingDays().contains(request.getDate().getDayOfWeek().name())).toList();

        validateHourMedicalAppointment(request, scheduleResponses);
    }

    private void validateHourMedicalAppointment(MedicalAppointmentRequest request, List<ScheduleResponse> scheduleResponses) {

        scheduleResponses.forEach(scheduleResponse -> {
            if(parse(request.getStartHour()).isBefore(parse(scheduleResponse.getStartWorkingHours()))) {

                throw new SchedulingAppointmentsException(ErrorCode.INVALID_SCHEDULE_HOUR);
            }

            if (nonNull(scheduleResponse.getStartLunchHours()) && nonNull(scheduleResponse.getEndLunchHours())
                    && parse(request.getStartHour()).isAfter(parse(scheduleResponse.getStartLunchHours()))
                    && parse(request.getStartHour()).isBefore(parse(scheduleResponse.getEndLunchHours()))) {

                throw new SchedulingAppointmentsException(ErrorCode.INVALID_SCHEDULE_HOUR);
            }


            if (parse(request.getStartHour()).isAfter(parse(scheduleResponse.getEndWorkingHours()))) {

                throw new SchedulingAppointmentsException(ErrorCode.INVALID_SCHEDULE_HOUR);
            }

        });
    }

    private void validateMedicalAppointmentExists(MedicalAppointmentRequest request) {
        medicalAppointmentRepository.findByDoctorIdAndDateAndStartHourAndStatusIsNot(
                request.getDoctorId(), request.getDate(), request.getStartHour(), MedicalAppointmentStatus.CANCELED.name()).ifPresent(schedule -> {
            throw new SchedulingAppointmentsException(ErrorCode.SCHEDULE_MEDICAL_APPOINTMENT_ALREADY_EXISTS);
        });
    }

    private void validatePatient(MedicalAppointmentRequest request) {
        patientService.findById(request.getPatientId()).getBody();
    }

    private void validateDoctor(MedicalAppointmentRequest request) {
        doctorService.findById(request.getDoctorId()).getBody();
    }

    private static void validateDay(MedicalAppointmentRequest request) {
        if (now().isAfter(request.getDate())) {
            throw new SchedulingAppointmentsException(ErrorCode.INVALID_SCHEDULE_DAY);
        }
    }


    private void sendNotification() {
        System.out.println("Notificação enviada com sucesso!");
    }

    private void payment() {
        System.out.println("Pagamento realizado com sucesso!");
    }
}
