package br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@NoArgsConstructor
public class UserRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    private String phone;

    private String role;

}
