package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.repository;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.MedicalInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalInsuranceRepository extends JpaRepository<MedicalInsurance, Long> {

   Optional<List<MedicalInsurance>> findMedicalInsurancesByDoctors_id (Long doctorId);
}
