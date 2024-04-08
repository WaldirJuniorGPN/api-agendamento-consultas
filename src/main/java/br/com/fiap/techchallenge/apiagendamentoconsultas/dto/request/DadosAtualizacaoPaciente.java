package br.com.fiap.techchallenge.apiagendamentoconsultas.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoPaciente(
        @NotNull(message = "O id do paciente precisa ser informado")
        Long id,
        String nome,
        @Email(message = "O email deve ser um endereço de email válido.")
        String email,
        @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}", message = "O telefone deve estar no formato (99) 99999-9999 ou (99) 9999-9999.")
        String telefone,
        @Pattern(regexp = "^\\d{11}$", message = "O CPF deve conter exatamente 11 dígitos numéricos.")
        String cpf,
        @Valid
        DadosAtualizacaoEndereco endereco
) {
}
