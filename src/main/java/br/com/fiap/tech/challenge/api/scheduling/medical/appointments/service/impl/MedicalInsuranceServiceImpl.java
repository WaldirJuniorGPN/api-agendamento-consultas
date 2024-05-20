package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service.impl;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request.MedicalInsuranceRequest;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.MedicalInsurancePageResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.MedicalInsuranceResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.exception.ErrorCode;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.exception.SchedulingAppointmentsException;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model.MedicalInsurance;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.repository.MedicalInsuranceRepository;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service.MedicalInsuranceService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalInsuranceServiceImpl implements MedicalInsuranceService {

    private final MedicalInsuranceRepository repository;
    private final ModelMapper mapper;

    public MedicalInsuranceServiceImpl(MedicalInsuranceRepository medicalInsuranceRepository, ModelMapper mapper) {
        this.repository = medicalInsuranceRepository;
        this.mapper = mapper;
    }

    @Override
    public void create(MedicalInsuranceRequest request) {
        var medicalInsurance = mapper.map(request, MedicalInsurance.class);

        repository.save(medicalInsurance);
    }

    @Override
    public ResponseEntity<MedicalInsurancePageResponse> listAll(int page, int size) {
        var pageable = PageRequest.of(page, size);
        var medicalInsurances = repository.findAll(pageable);
        var medicalInsurancePageResponse = mapper.map(medicalInsurances, MedicalInsurancePageResponse.class);

        return ResponseEntity.ok(medicalInsurancePageResponse);
    }

    @Override
    public ResponseEntity<MedicalInsuranceResponse> update(Long id, MedicalInsuranceRequest request) {
        var medicalInsurance = repository.findById(id).orElseThrow(
                () -> new SchedulingAppointmentsException(ErrorCode.MEDICAL_INSURANCE_NOT_FOUND)
        );
        mapper.map(request, medicalInsurance);
        repository.save(medicalInsurance);
        var medicalInsuranceResponse = mapper.map(medicalInsurance, MedicalInsuranceResponse.class);

        return ResponseEntity.ok(medicalInsuranceResponse);
    }

    @Override
    public ResponseEntity<MedicalInsuranceResponse> findById(Long id) {
        var medicalInsurance = repository.findById(id).orElseThrow(
                () -> new SchedulingAppointmentsException(ErrorCode.MEDICAL_INSURANCE_NOT_FOUND)
        );
        var medicalInsuranceResponse = mapper.map(medicalInsurance, MedicalInsuranceResponse.class);

        return ResponseEntity.ok(medicalInsuranceResponse);
    }

    @Override
    public void delete(Long id) {
        var medicalInsurance = repository.findById(id).orElseThrow(
                () -> new SchedulingAppointmentsException(ErrorCode.MEDICAL_INSURANCE_NOT_FOUND)
        );

        repository.delete(medicalInsurance);
    }

    @Override
    public List<MedicalInsuranceResponse> findByDoctorId(Long doctorId) {

        return repository.findMedicalInsurancesByDoctors_id(doctorId)
            .orElseThrow(
                () -> new SchedulingAppointmentsException(ErrorCode.MEDICAL_INSURANCE_NOT_FOUND)
            )
            .stream().map(medicalInsurance ->
                mapper.map(medicalInsurance, MedicalInsuranceResponse.class)
            ).toList();
    }

}
