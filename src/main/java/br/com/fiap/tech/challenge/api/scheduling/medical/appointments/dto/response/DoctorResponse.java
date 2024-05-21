package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DoctorResponse {

    private Long id;
    private String crm;
    private String cpf;
    private UserResponse user;
    private AddressResponse address;
    private List<SpecialtyResponse> specialties;
    private List<MedicalInsuranceResponse> medicalInsurances;

}
