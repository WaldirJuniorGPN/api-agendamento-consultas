package br.com.fiap.tech.challenge.api.agendamento.consultas.model;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.DadosAtualizacaoMedico;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.DadosCadastroMedico;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String crm;
    @Enumerated(EnumType.STRING)
    private EspecialidadeOld especialidadeOld;

    public Medico(DadosCadastroMedico dados) {
        super.setNome(dados.nome());
        super.setEmail(dados.email());
        super.setTelefone(dados.telefone());
        super.setEndereco(new Endereco(dados.endereco()));
        this.crm = dados.crm();
        this.especialidadeOld = dados.especialidadeOld();
    }

    public void atualizarDados(DadosAtualizacaoMedico dados) {
        if (dados.nome() != null) {
            super.setNome(dados.nome());
        }
        if (dados.telefone() != null) {
            super.setTelefone(dados.telefone());
        }
        if (dados.email() != null) {
            super.setEmail(dados.email());
        }
        if (dados.crm() != null) {
            this.crm = dados.crm();
        }
        if (dados.especialidadeOld() != null) {
            this.especialidadeOld = dados.especialidadeOld();
        }

        super.getEndereco().atualizarDados(dados.endereco());
    }
}
