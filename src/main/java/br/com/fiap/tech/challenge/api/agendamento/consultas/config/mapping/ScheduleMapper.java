package br.com.fiap.tech.challenge.api.agendamento.consultas.config.mapping;

import br.com.fiap.tech.challenge.api.agendamento.consultas.config.TypeMapConfiguration;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.ScheduleRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Schedule;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class ScheduleMapper implements TypeMapConfiguration {

    @Override
    public void configure(ModelMapper modelMapper) {
        modelMapper.typeMap(ScheduleRequest.class, Schedule.class).setProvider(scheduleProvider());
    }

    private Provider<Schedule> scheduleProvider() {
        return provision -> {
            var request = (ScheduleRequest) provision.getSource();
            var schedule = new Schedule();
            schedule.setStartWorkingHours(LocalTime.parse(request.getStartWorkingHours()));
            schedule.setEndWorkingHours(LocalTime.parse(request.getEndWorkingHours()));
            schedule.setStartLunchHours(LocalTime.parse(request.getStartLunchHours()));
            schedule.setEndLunchHours(LocalTime.parse(request.getEndLunchHours()));
            schedule.setWorkingDays(request.getWorkingDays().getDescription());

            return schedule;
        };
    }
}
