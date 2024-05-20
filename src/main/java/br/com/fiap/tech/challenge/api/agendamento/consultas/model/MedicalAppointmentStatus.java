package br.com.fiap.tech.challenge.api.agendamento.consultas.model;

import lombok.Getter;

@Getter
public enum MedicalAppointmentStatus {

    SCHEDULED("AGENDADO"),
    CONFIRMED("CONFIRMADO"),
    CANCELED("CANCELADO"),
    FINISHED("FINALIZADO");
    
    private final String description;

    MedicalAppointmentStatus(String description) {
        this.description = description;
    }

}
