package br.com.fiap.tech.challenge.api.agendamento.consultas.repository;

import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

    Optional<List<Specialty>> findSpecialtiesByDoctors_id(Long doctorId);

}
