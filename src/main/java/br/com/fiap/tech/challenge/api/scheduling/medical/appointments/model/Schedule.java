package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.time.LocalTime;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name = "schedules")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Schedule extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -8831890923115702264L;

    @Enumerated(STRING)
    @Column(name = "working_days")
    private WorkingDay workingDays;

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
