package br.com.fiap.techchallenge.apiagendamentoconsultas.model;

import br.com.fiap.techchallenge.apiagendamentoconsultas.dto.request.DadosAtualizacaoPaciente;
import br.com.fiap.techchallenge.apiagendamentoconsultas.dto.request.DadosCadastroPaciente;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pacientes")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Paciente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;

    public Paciente(DadosCadastroPaciente dados) {
        super.setNome(dados.nome());
        super.setEmail(dados.email());
        super.setTelefone(dados.telefone());
        super.setEndereco(new Endereco(dados.endereco()));
        this.cpf = dados.cpf();
    }

    public void atualizarDados(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null) {
            super.setNome(dados.nome());
        }
        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
        if (dados.email() != null) {
            super.setEmail(dados.email());
        }
        if (dados.telefone() != null) {
            super.setTelefone(dados.telefone());
        }
        super.getEndereco().atualizarDados(dados.endereco());
    }
}
