package br.com.fiap.tech.challenge.api.agendamento.consultas.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "doctors")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Doctor extends BaseEntity{

    @Serial
    private static final long serialVersionUID = 7780336203987417568L;

    private String crm;

    private String cpf;

    @ManyToMany(fetch = EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "doctors_specialties",
            joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id", referencedColumnName = "id"))
    private List<Specialty> specialties;

    @OneToMany(mappedBy = "doctor", fetch = LAZY)
    @Transient
    private List<Schedule> schedules;

    @ManyToMany(fetch = EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "doctors_medical_insurances",
            joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medical_insurance_id", referencedColumnName = "id"))
    private List<MedicalInsurance> medicalInsurances;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Doctor(Long id) {
        super.setId(id);
    }
}
