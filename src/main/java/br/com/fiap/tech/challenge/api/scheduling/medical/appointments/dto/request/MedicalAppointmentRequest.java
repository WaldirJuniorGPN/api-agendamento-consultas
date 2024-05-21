package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MedicalAppointmentRequest {

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @NotNull
    private String startHour;

    @NotNull
    private Long doctorId;

    private Long patientId;
}
