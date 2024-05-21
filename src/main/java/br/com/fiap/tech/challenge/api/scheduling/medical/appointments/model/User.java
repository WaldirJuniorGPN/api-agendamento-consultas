package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -1161377881466392329L;

    private String name;

    private String email;

    private String password;

    private String phone;

    private String role;

}
