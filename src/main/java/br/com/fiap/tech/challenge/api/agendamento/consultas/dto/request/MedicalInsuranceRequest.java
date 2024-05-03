package br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicalInsuranceRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String cnpj;

}
