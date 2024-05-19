package br.com.fiap.tech.challenge.api.agendamento.consultas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "medical_insurances")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MedicalInsurance extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -7997515509608591126L;

    private String name;

    private String cnpj;

    @ManyToMany(fetch = LAZY, mappedBy = "medicalInsurances")
    private List<Doctor> doctors;
}
