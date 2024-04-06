package br.com.fiap.techchallenge.apiagendamentoconsultas.dto.response;

import br.com.fiap.techchallenge.apiagendamentoconsultas.model.Especialidade;
import br.com.fiap.techchallenge.apiagendamentoconsultas.model.Medico;

public record DadosListagemMedico(Long id, String nome, String email, Especialidade especialidade, String crm) {
    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getEspecialidade(), medico.getCrm());
    }
}
