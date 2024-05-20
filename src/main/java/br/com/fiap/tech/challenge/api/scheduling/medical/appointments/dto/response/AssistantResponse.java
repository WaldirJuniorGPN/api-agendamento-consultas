package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssistantResponse {

    private Long id;

    private String cpf;

    private UserResponse user;

    private AddressResponse address;

}
