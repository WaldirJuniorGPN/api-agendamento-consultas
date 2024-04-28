package br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response;

import br.com.fiap.tech.challenge.api.agendamento.consultas.model.EspecialidadeOld;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Medico;

public record DadosListagemMedico(Long id, String nome, String email, EspecialidadeOld especialidadeOld, String crm) {
    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getEspecialidadeOld(), medico.getCrm());
    }
}
