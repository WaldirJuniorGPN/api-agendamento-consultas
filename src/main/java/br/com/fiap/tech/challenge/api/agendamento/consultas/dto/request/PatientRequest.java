package br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientRequest {

    @Valid
    private UserRequest user;

    @Valid
    private AddressRequest address;

}
