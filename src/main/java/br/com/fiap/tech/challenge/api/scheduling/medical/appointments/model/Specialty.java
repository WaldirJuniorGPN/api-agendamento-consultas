package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "specialties")
@Data
@NoArgsConstructor
public class Specialty extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -4301688336333660988L;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "specialties")
    private List<Doctor> doctors;

}
