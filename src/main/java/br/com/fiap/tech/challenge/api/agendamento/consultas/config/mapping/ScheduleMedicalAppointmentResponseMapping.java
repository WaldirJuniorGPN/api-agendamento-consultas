package br.com.fiap.tech.challenge.api.agendamento.consultas.config.mapping;

import br.com.fiap.tech.challenge.api.agendamento.consultas.config.TypeMapConfiguration;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.MedicalAppointmentResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.MedicalAppointment;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMedicalAppointmentResponseMapping implements TypeMapConfiguration {

    @Override
    public void configure(ModelMapper modelMapper) {
        modelMapper.typeMap(MedicalAppointment.class, MedicalAppointmentResponse.class)
            .setProvider(scheduleMedicalAppointmentResponseProvider());
    }

    private Provider<MedicalAppointmentResponse> scheduleMedicalAppointmentResponseProvider() {
        return provision -> {
            var source = (MedicalAppointment) provision.getSource();
            var scheduleMedicalAppointmentResponse = new MedicalAppointmentResponse();

            scheduleMedicalAppointmentResponse.setDate(source.getDate().toString());
            scheduleMedicalAppointmentResponse.setDoctorName(source.getDoctor().getUser().getName());
            scheduleMedicalAppointmentResponse.setDoctorCrm(source.getDoctor().getCrm());
            scheduleMedicalAppointmentResponse.setHour(source.getStartHour());

            return scheduleMedicalAppointmentResponse;
        };
    }

}
