package br.com.fiap.tech.challenge.api.agendamento.consultas.repository;

import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {}
