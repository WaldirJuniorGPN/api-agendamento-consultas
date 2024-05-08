package br.com.fiap.tech.challenge.api.agendamento.consultas.service.impl;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.DoctorRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.DoctorPageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.DoctorResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.exception.SchedulingAppointmentsException;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Doctor;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.MedicalInsurance;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Specialty;
import br.com.fiap.tech.challenge.api.agendamento.consultas.repository.DoctorRepository;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.DoctorService;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.MedicalInsuranceService;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.SpecialtyService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static br.com.fiap.tech.challenge.api.agendamento.consultas.exception.ErrorCode.DOCTOR_NOT_FOUND;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final MedicalInsuranceService medicalInsuranceService;
    private final SpecialtyService specialtyService;
    private final ModelMapper mapper;

    public DoctorServiceImpl(DoctorRepository doctorRepository,
                             MedicalInsuranceService medicalInsuranceService,
                             SpecialtyService specialtyService,
                             ModelMapper mapper) {

        this.doctorRepository = doctorRepository;
        this.medicalInsuranceService = medicalInsuranceService;
        this.specialtyService = specialtyService;
        this.mapper = mapper;
    }

    @Override
    public void create(DoctorRequest doctorRequest) {
        List<MedicalInsurance> medicalInsurances = new ArrayList<>();
        List<Specialty> specialties = new ArrayList<>();

        doctorRequest.getMedicalInsurances().forEach(medicalInsuranceId -> {
            var medicalInsuranceResponse = medicalInsuranceService.findById(medicalInsuranceId).getBody();
            var medicalInsurance = mapper.map(medicalInsuranceResponse, MedicalInsurance.class);

            medicalInsurances.add(medicalInsurance);
        });

        doctorRequest.getSpecialties().forEach(specialtyId -> {
            var specialtyResponse = specialtyService.findById(specialtyId).getBody();
            var specialty = mapper.map(specialtyResponse, Specialty.class);

            specialties.add(specialty);
        });
        var doctor = mapper.map(doctorRequest, Doctor.class);
        doctor.setMedicalInsurances(medicalInsurances);
        doctor.setSpecialties(specialties);

        doctorRepository.save(doctor);
    }

    @Override
    public ResponseEntity<DoctorPageResponse> listAll(int page, int size) {
        var pageRequest = PageRequest.of(page, size);
        var doctors = doctorRepository.findAll(pageRequest);

        return ResponseEntity.ok(mapper.map(doctors, DoctorPageResponse.class));
    }

    @Override
    public ResponseEntity<DoctorResponse> findById(Long id) {
        var doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new SchedulingAppointmentsException(DOCTOR_NOT_FOUND));

        return ResponseEntity.ok(mapper.map(doctor, DoctorResponse.class));
    }

    @Override
    public ResponseEntity<DoctorResponse> update(Long id, DoctorRequest request) {
        var doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new SchedulingAppointmentsException(DOCTOR_NOT_FOUND));
        String password = doctor.getUser().getPassword();
        mapper.map(request, doctor);
        doctor.getUser().setPassword(password);
        doctorRepository.save(doctor);

        return ResponseEntity.ok(mapper.map(doctor, DoctorResponse.class));
    }

    @Override
    public void delete(Long id) {
        var doctor = doctorRepository.findById(id).orElseThrow(
                () -> new SchedulingAppointmentsException(DOCTOR_NOT_FOUND));

        doctorRepository.delete(doctor);
    }
}
