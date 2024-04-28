package br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssistantRequest {

    @NotBlank
    private String name;

    @Valid
    private UserRequest user;

    @Valid
    private AddressRequest address;

}
