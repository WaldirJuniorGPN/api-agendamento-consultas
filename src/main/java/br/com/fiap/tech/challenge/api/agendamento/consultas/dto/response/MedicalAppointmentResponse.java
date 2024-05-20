package br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicalAppointmentResponse {

    private Long id;

    private String date;

    private String doctorName;

    private String doctorCrm;

    private String hour;

    private String status;

    private String medicalReport;

}
