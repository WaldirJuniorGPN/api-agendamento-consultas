package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DoctorPageResponse extends PageResponse {

    private List<DoctorResponse> content;

}
