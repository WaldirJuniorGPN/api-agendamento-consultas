package br.com.fiap.tech.challenge.api.agendamento.consultas.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Entity
@Table(name = "assistants")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Assistant extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -8181170115669325138L;

    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

}
