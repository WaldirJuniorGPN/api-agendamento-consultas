package br.com.fiap.tech.challenge.api.agendamento.consultas.service;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.DadosAtualizacaoMedico;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.DadosCadastroMedico;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.DadosDetalhamentoMedico;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.DadosListagemMedico;
import br.com.fiap.tech.challenge.api.agendamento.consultas.model.Medico;
import br.com.fiap.tech.challenge.api.agendamento.consultas.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MedicoService {

    private final int RESULTADOS_POR_PAGINA = 10;

    @Autowired
    private MedicoRepository repository;

    public ResponseEntity<DadosDetalhamentoMedico> cadastrar(DadosCadastroMedico dados, UriComponentsBuilder uriComponentsBuilder) {
        var medico = new Medico(dados);
        var uri = uriComponentsBuilder.path("/medico/{id}").buildAndExpand(medico.getId()).toUri();
        this.repository.save(medico);
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    public ResponseEntity<Page<DadosListagemMedico>> listarTodos(Pageable paginacao) {
        var pageAtualizada = PageRequest.of(paginacao.getPageNumber(), this.RESULTADOS_POR_PAGINA, paginacao.getSort());
        var page = this.repository.findAll(pageAtualizada).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    public ResponseEntity<DadosDetalhamentoMedico> buscarPorId(Long id) {
        var medico = this.repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    public ResponseEntity<DadosDetalhamentoMedico> atualizarDados(DadosAtualizacaoMedico dados) {
        var medico = this.repository.getReferenceById(dados.id());
        medico.atualizarDados(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    public ResponseEntity<Void> deletar(Long id) {
        this.repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
