package br.com.fiap.techchallenge.apiagendamentoconsultas.repository;

import br.com.fiap.techchallenge.apiagendamentoconsultas.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
