package br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpecialtyRequest {

    @NotBlank
    private String name;

    private String description;

}
