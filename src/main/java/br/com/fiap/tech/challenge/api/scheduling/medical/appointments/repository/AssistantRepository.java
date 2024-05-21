package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.repository;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.Assistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistantRepository extends JpaRepository<Assistant, Long> {
}
