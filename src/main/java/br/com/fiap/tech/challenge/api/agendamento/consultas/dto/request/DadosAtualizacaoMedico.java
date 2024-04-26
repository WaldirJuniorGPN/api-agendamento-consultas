package br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request;

import br.com.fiap.tech.challenge.api.agendamento.consultas.model.EspecialidadeOld;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoMedico(
        @NotNull(message = "É necessário informar o id do médico que deseja alterar")
        Long id,
        String nome,
        @Email(message = "O email deve ser um endereço de email válido.")
        String email,

        @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}", message = "O telefone deve estar no formato (99) 99999-9999 ou (99) 9999-9999.")
        String telefone,

        @Pattern(regexp = "^[0-9]{2}[.][0-9]{3}[.][0-9]{2}$", message = "O CRM deve estar no formato 99.999.99.")
        String crm,

        EspecialidadeOld especialidadeOld,

        @Valid
        DadosAtualizacaoEndereco endereco
) {
}
