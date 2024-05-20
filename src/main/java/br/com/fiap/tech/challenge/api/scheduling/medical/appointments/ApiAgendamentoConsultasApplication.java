package br.com.fiap.tech.challenge.api.scheduling.medical.appointments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.com.fiap.tech.challenge.api.agendamento.consultas.repository")
public class ApiAgendamentoConsultasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAgendamentoConsultasApplication.class, args);
	}

}
