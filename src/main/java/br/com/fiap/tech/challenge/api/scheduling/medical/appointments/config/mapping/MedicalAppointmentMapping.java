package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.config.mapping;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.config.TypeMapConfiguration;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request.MedicalAppointmentRequest;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.Doctor;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.MedicalAppointment;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.Patient;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.stereotype.Component;

@Component
public class MedicalAppointmentMapping implements TypeMapConfiguration {

    @Override
    public void configure(ModelMapper modelMapper) {
        modelMapper.typeMap(MedicalAppointmentRequest.class, MedicalAppointment.class)
            .setProvider(medicalAppointmentProvider());
    }

    private Provider<MedicalAppointment> medicalAppointmentProvider() {
        return provision -> {
            var request = (MedicalAppointmentRequest) provision.getSource();
            var medicalAppointment = new MedicalAppointment();
            medicalAppointment.setDoctor(new Doctor(request.getDoctorId()));
            medicalAppointment.setPatient(new Patient(request.getPatientId()));
            medicalAppointment.setDate(request.getDate());
            medicalAppointment.setStartHour(request.getStartHour());

            return medicalAppointment;
        };
    }
}
