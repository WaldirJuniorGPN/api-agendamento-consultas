package br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientRequest {

    private UserRequest user;

    private AddressRequest address;

}
