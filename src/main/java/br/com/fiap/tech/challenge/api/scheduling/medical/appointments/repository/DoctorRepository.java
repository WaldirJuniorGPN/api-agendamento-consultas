package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.repository;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
