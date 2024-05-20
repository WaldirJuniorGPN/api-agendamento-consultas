package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request.MedicalAppointmentRequest;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request.MedicalReportRequest;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.MedicalAppointmentPageResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.MedicalAppointmentResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.MedicalAppointmentStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MedicalAppointmentService {

    void create(MedicalAppointmentRequest request);

    ResponseEntity<MedicalAppointmentPageResponse> listAllMedicalAppointmentByStatus(
            MedicalAppointmentStatus status,
            int page,
            int size);

    void cancel(Long id);

    ResponseEntity<MedicalAppointmentResponse> reschedule(Long id, MedicalAppointmentRequest request);

    void confirm(Long id);

    void finish(Long id, MedicalReportRequest medicalReportRequest);

    ResponseEntity<MedicalAppointmentPageResponse> listAllMedicalAppointment(int page, int size);

    ResponseEntity<List<MedicalAppointmentResponse>> findByDoctorAndStatusIsNot(Long doctorId, MedicalAppointmentStatus medicalAppointmentStatus);
}
