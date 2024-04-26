package br.com.fiap.tech.challenge.api.agendamento.consultas.service;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.DadosAtualizacaoPaciente;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.DadosCadastroPaciente;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.DadosDetalhamentoPaciente;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.DadosListagemPaciente;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Paciente;
import br.com.fiap.tech.challenge.api.agendamento.consultas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class PacienteService {

    private final int RESULTADOS_POR_PAGINA = 10;

    @Autowired
    private PacienteRepository repository;

    public ResponseEntity<DadosDetalhamentoPaciente> cadastrar(DadosCadastroPaciente dados, UriComponentsBuilder uriComponentsBuilder) {
        var paciente = new Paciente(dados);
        var uri = uriComponentsBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();
        this.repository.save(paciente);
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }

    public ResponseEntity<Page<DadosListagemPaciente>> listarTodos(Pageable paginacao) {
        var sortPorNome = Sort.by("nome").ascending();
        var paginacaoAtualizada = PageRequest.of(paginacao.getPageNumber(), this.RESULTADOS_POR_PAGINA, sortPorNome);
        var page = this.repository.findAll(paginacaoAtualizada).map(DadosListagemPaciente::new);
        return ResponseEntity.ok(page);
    }

    public ResponseEntity<DadosDetalhamentoPaciente> buscarPorId(Long id) {
        var paciente = this.repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    public ResponseEntity<DadosDetalhamentoPaciente> atualizarDados(DadosAtualizacaoPaciente dados) {
        var paciente = this.repository.getReferenceById(dados.id());
        paciente.atualizarDados(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    public ResponseEntity<Void> deletar(Long id) {
        this.repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
