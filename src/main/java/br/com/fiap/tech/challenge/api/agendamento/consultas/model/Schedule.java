package br.com.fiap.tech.challenge.api.agendamento.consultas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.time.LocalTime;

@Entity
@Table(name = "schedules")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Schedule extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -8831890923115702264L;

    @Column(name = "working_days")
    private String workingDays;

    @Column(name = "start_working_hours")
    private LocalTime startWorkingHours;

    @Column(name = "end_working_hours")
    private LocalTime endWorkingHours;

    @Column(name = "start_lunch_hours")
    private LocalTime startLunchHours;

    @Column(name = "end_lunch_hours")
    private LocalTime endLunchHours;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

}
