package br.com.fiap.tech.challenge.api.agendamento.consultas.config.mapping;

import br.com.fiap.tech.challenge.api.agendamento.consultas.config.TypeMapConfiguration;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.ScheduleResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Schedule;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.stereotype.Component;

@Component
public class ScheduleResponseMapping implements TypeMapConfiguration {

    @Override
    public void configure(ModelMapper modelMapper) {
        modelMapper.typeMap(Schedule.class, ScheduleResponse.class)
            .setProvider(scheduleResponseProvider());
    }

    private Provider<ScheduleResponse> scheduleResponseProvider() {

       return provision -> {
            var source = (Schedule) provision.getSource();
            var scheduleResponse = new ScheduleResponse();

            scheduleResponse.setId(source.getId());
            scheduleResponse.setWorkingDays(source.getWorkingDays());
            scheduleResponse.setStartWorkingHours(source.getStartWorkingHours().toString());
            scheduleResponse.setEndWorkingHours(source.getEndWorkingHours().toString());
            scheduleResponse.setStartLunchHours(source.getStartLunchHours().toString());
            scheduleResponse.setEndLunchHours(source.getEndLunchHours().toString());

            return scheduleResponse;
        };

    }
}
