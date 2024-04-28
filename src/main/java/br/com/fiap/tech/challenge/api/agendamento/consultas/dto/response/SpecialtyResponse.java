package br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpecialtyResponse {

    private Long id;

    private String name;

    private String description;

}
