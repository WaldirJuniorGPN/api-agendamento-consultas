package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScheduleResponse {

    private Long id;

    private String workingDays;

    private String startWorkingHours;

    private String endWorkingHours;

    private String startLunchHours;

    private String endLunchHours;

    private DoctorResponse doctor;

}
