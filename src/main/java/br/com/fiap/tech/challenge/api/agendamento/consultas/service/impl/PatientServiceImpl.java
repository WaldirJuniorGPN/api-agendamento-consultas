package br.com.fiap.tech.challenge.api.agendamento.consultas.service.impl;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.PatientRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.PatientPageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.PatientResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.exception.ErrorCode;
import br.com.fiap.tech.challenge.api.agendamento.consultas.exception.SchedulingAppointmentsException;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Patient;
import br.com.fiap.tech.challenge.api.agendamento.consultas.repository.PatientRepository;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    private final ModelMapper mapper;

    public PatientServiceImpl(PatientRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(PatientRequest patientRequest) {
        var patient = mapper.map(patientRequest, Patient.class);

        repository.save(patient);
    }

    @Override
    public ResponseEntity<PatientPageResponse> listAll(int page, int size) {
        var pageable = PageRequest.of(page, size);
        var patients = repository.findAll(pageable);

        return ResponseEntity.ok(mapper.map(patients, PatientPageResponse.class));
    }

    @Override
    public ResponseEntity<PatientResponse> update(Long id, PatientRequest request) {
        var patient = repository.findById(id).orElseThrow(
                () -> new SchedulingAppointmentsException(ErrorCode.SPECIALTY_NOT_FOUND));
        mapper.map(request, patient);
        var patientResponse = mapper.map(repository.save(patient), PatientResponse.class);

        return ResponseEntity.ok(patientResponse);
    }

    @Override
    public void delete(Long id) {
        var patient = repository.findById(id).orElseThrow(
                () -> new SchedulingAppointmentsException(ErrorCode.PATIENT_NOT_FOUND)
        );

        repository.delete(patient);
    }

    @Override
    public ResponseEntity<PatientResponse> findById(Long id) {
        var patient = repository.findById(id).orElseThrow(
                () -> new SchedulingAppointmentsException(ErrorCode.PATIENT_NOT_FOUND)
        );
        var patientResponse = mapper.map(patient, PatientResponse.class);

        return ResponseEntity.ok(patientResponse);
    }
}
