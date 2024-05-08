package br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DoctorRequest {

    @NotBlank
    private String crm;

    @NotBlank
    private String cpf;

    private List<Long> specialties;

    private List<Long> medicalInsurances;

    private UserRequest user;

    private AddressRequest address;

}
