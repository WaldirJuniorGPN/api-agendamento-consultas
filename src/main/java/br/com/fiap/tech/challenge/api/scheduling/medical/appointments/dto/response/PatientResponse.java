package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PatientResponse {

    private Long id;

    private LocalDate birthDate;

    private UserResponse user;

    private AddressResponse address;

}
