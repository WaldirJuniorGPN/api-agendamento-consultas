package br.com.fiap.techchallenge.apiagendamentoconsultas.model;

import br.com.fiap.techchallenge.apiagendamentoconsultas.dto.request.DadosAtualizacaoMedico;
import br.com.fiap.techchallenge.apiagendamentoconsultas.dto.request.DadosCadastroMedico;
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
    private Especialidade especialidade;

    public Medico(DadosCadastroMedico dados) {
        super.setNome(dados.nome());
        super.setEmail(dados.email());
        super.setTelefone(dados.telefone());
        super.setEndereco(new Endereco(dados.endereco()));
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
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
        if (dados.especialidade() != null) {
            this.especialidade = dados.especialidade();
        }

        super.getEndereco().atualizarDados(dados.endereco());
    }
}
