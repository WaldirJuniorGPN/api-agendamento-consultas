package br.com.fiap.tech.challenge.api.agendamento.consultas.repository;

import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
