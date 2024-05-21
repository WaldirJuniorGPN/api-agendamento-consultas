package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PatientRequest {

    @NotNull
    private LocalDate birthDate;

    @Valid
    private UserRequest user;

    @Valid
    private AddressRequest address;

}
