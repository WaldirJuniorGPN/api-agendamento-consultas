package br.com.fiap.techchallenge.apiagendamentoconsultas.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPaciente(
        @NotBlank(message = "O nome não pode estar em branco.")
        String nome,
        @NotBlank(message = "O email não pode estar em branco.")
        @Email(message = "O email deve ser um endereço de email válido.")
        String email,
        @NotBlank(message = "O telefone não pode estar em branco.")
        @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}", message = "O telefone deve estar no formato (99) 99999-9999 ou (99) 9999-9999.")
        String telefone,
        @NotBlank(message = "O CPF não pode estar em branco.")
        @Pattern(regexp = "^\\d{11}$", message = "O CPF deve conter exatamente 11 dígitos numéricos.")
        String cpf,
        @Valid
        DadosEndereco endereco
) {
}
