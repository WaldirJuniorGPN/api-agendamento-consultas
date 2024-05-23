package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.time.LocalDate;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name = "medical_appointments")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MedicalAppointment extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -1895496737021014598L;

    private LocalDate date;

    @Column(name = "start_hour")
    private String startHour;

    @Enumerated(STRING)
    private MedicalAppointmentStatus status;

    @Column(name = "medical_report")
    private String medicalReport;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;
}
