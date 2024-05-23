package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@NoArgsConstructor
public class AssistantRequest {

    @CPF
    @NotBlank
    private String cpf;

    @Valid
    private UserRequest user;

    @Valid
    private AddressRequest address;

}
