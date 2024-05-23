package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.repository;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.MedicalAppointment;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.MedicalAppointmentStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long> {

    Optional<MedicalAppointment> findByDoctorIdAndDateAndStartHourAndStatusIsNot(Long doctorId, LocalDate date, String hour, MedicalAppointmentStatus status);

    Page<MedicalAppointment> findByStatus(MedicalAppointmentStatus status, PageRequest pageable);

    Optional<List<MedicalAppointment>> findByDoctorIdAndStatusIsNotAndDateIsAfter(Long doctorId, MedicalAppointmentStatus name, LocalDate yesterday);
}
