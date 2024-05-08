package br.com.fiap.tech.challenge.api.agendamento.consultas.service;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.MedicalInsuranceRequest;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.MedicalInsurancePageResponse;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.MedicalInsuranceResponse;
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
