package br.com.fiap.tech.challenge.api.agendamento.consultas.repository;

import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
