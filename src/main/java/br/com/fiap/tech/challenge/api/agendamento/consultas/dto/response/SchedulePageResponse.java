package br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SchedulePageResponse extends PageResponse {

    private List<ScheduleResponse> content;

}
