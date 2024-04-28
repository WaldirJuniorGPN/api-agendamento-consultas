package br.com.fiap.tech.challenge.api.agendamento.consultas.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public abstract class Pessoa {

    private String nome;
    private String email;
    private String telefone;
    @Embedded
    private Endereco endereco;
}
