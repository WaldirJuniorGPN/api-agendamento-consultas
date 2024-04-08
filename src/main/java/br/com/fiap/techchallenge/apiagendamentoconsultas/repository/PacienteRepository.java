package br.com.fiap.techchallenge.apiagendamentoconsultas.repository;

import br.com.fiap.techchallenge.apiagendamentoconsultas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
