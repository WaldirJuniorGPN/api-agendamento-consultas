package br.com.fiap.techchallenge.apiagendamentoconsultas.dto.request;

import br.com.fiap.techchallenge.apiagendamentoconsultas.model.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(
        @NotBlank(message = "O nome não pode estar em branco.")
        String nome,

        @NotBlank(message = "O email não pode estar em branco.")
        @Email(message = "O email deve ser um endereço de email válido.")
        String email,

        @NotBlank(message = "O telefone não pode estar em branco.")
        @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}", message = "O telefone deve estar no formato (99) 99999-9999 ou (99) 9999-9999.")
        String telefone,

        @NotBlank(message = "O CRM não pode estar em branco.")
        @Pattern(regexp = "^[0-9]{2}[.][0-9]{3}[.][0-9]{2}$", message = "O CRM deve estar no formato 99.999.99.")
        String crm,

        @NotBlank(message = "A especialidade não pode estar em branco.")
        Especialidade especialidade,
        @Valid
        DadosEndereco endereco

) {
}
