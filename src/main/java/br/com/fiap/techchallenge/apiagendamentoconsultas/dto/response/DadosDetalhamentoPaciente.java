package br.com.fiap.techchallenge.apiagendamentoconsultas.dto.response;

import br.com.fiap.techchallenge.apiagendamentoconsultas.model.Endereco;
import br.com.fiap.techchallenge.apiagendamentoconsultas.model.Paciente;

public record DadosDetalhamentoPaciente(Long id, String nome, String cpf, String telefone, String email, Endereco endereco) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getEmail(), paciente.getEndereco());
    }
}
