package br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MedicalInsurancePageResponse extends PageResponse{

    private List<MedicalInsuranceResponse> content;

}
