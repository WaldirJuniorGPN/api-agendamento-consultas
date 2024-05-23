package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.request.MedicalInsuranceRequest;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.MedicalInsurancePageResponse;
import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.dto.response.MedicalInsuranceResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MedicalInsuranceService {

    void create(MedicalInsuranceRequest request);

    ResponseEntity<MedicalInsurancePageResponse> listAll(int page, int size);

    ResponseEntity<MedicalInsuranceResponse> update(Long id, MedicalInsuranceRequest request);

    ResponseEntity<MedicalInsuranceResponse> findById(Long id);

    void delete(Long id);

    List<MedicalInsuranceResponse> findByDoctorId(Long doctorId);
}
