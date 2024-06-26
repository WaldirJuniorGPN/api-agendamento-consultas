package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicalReportRequest {

    @NotBlank
    private String medicalReport;

}
