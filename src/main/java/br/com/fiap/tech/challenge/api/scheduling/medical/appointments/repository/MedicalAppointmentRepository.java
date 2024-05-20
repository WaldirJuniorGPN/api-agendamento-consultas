package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.repository;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.MedicalAppointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long> {

    Optional<MedicalAppointment> findByDoctorIdAndDateAndStartHourAndStatusIsNot(Long doctorId, LocalDate date, String hour, String status);

    Page<MedicalAppointment> findByStatus(String status, PageRequest pageable);

    Optional<List<MedicalAppointment>> findByDoctorIdAndStatusIsNotAndDateIsAfter(Long doctorId, String name, LocalDate yesterday);
}
