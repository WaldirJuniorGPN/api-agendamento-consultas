package br.com.fiap.tech.challenge.api.agendamento.consultas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Patient extends EntityModel {

    @Serial
    private static final long serialVersionUID = -376440141306122084L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
