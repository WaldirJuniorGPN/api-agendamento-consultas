package br.com.fiap.techchallenge.apiagendamentoconsultas.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank(message = "O logradouro não pode estar em branco.")
        String logradouro,

        Integer numero,

        String complemento,

        @NotBlank(message = "O bairro não pode estar em branco.")
        String bairro,

        @NotNull
        @Pattern(regexp = "^[A-Za-z\\s']+$", message = "A cidade deve conter apenas letras, espaços e apóstrofos.")
        String cidade,

        @NotBlank(message = "A UF não pode estar em branco.")
        @Pattern(regexp = "^[A-Za-z]{2}$", message = "A UF deve conter exatamente 2 letras.")
        String uf,

        @NotBlank(message = "O CEP não pode estar em branco.")
        @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "O CEP deve estar no formato 99999-999.")
        String cep
) {

}
