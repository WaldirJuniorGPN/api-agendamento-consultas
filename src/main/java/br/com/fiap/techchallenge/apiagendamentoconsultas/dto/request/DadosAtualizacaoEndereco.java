package br.com.fiap.techchallenge.apiagendamentoconsultas.dto.request;

import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoEndereco(
        String logradouro,

        Integer numero,

        String complemento,

        String bairro,

        @Pattern(regexp = "^[A-Za-z\\s']+$", message = "A cidade deve conter apenas letras, espaços e apóstrofos.")
        String cidade,

        @Pattern(regexp = "^[A-Za-z]{2}$", message = "A UF deve conter exatamente 2 letras.")
        String uf,

        @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "O CEP deve estar no formato 99999-999.")
        String cep
) {
}
