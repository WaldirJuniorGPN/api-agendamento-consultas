package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.repository;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Optional<List<Schedule>> findByDoctorId(Long doctorId);

    Optional<List<Schedule>> findByDoctorIdAndWorkingDays(Long doctorId, String workingDays);
}
