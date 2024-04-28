package br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssistantResponse {

    private Long id;

    private String name;

    private UserResponse user;

    private AddressResponse address;

}
