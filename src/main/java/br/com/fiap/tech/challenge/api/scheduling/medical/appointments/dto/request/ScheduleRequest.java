package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.WorkingDay;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;

@Data
@NoArgsConstructor
public class ScheduleRequest {

    @NotNull
    @Enumerated(STRING)
    private WorkingDay workingDays;

    @NotBlank
    @Pattern(regexp = "(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]", message = "Formato inválido. Utilize o formato HH:mm")
    private String startWorkingHours;

    @NotBlank
    @Pattern(regexp = "(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]", message = "Formato inválido. Utilize o formato HH:mm")
    private String endWorkingHours;

    @NotBlank
    @Pattern(regexp = "(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]", message = "Formato inválido. Utilize o formato HH:mm")
    private String startLunchHours;

    @NotBlank
    @Pattern(regexp = "(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]", message = "Formato inválido. Utilize o formato HH:mm")
    private String endLunchHours;

    @NotNull
    private Long doctorId;

}
