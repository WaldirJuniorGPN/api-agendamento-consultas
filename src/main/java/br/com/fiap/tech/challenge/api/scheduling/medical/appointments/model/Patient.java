package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Patient extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -376440141306122084L;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Patient(Long id) {
        super.setId(id);
    }
}
