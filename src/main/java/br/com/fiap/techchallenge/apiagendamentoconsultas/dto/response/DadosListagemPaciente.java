package br.com.fiap.techchallenge.apiagendamentoconsultas.dto.response;

import br.com.fiap.techchallenge.apiagendamentoconsultas.model.Paciente;

public record DadosListagemPaciente(Long id, String nome, String cpf, String email) {
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail());
    }
}
