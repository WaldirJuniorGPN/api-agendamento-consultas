package br.com.fiap.techchallenge.apiagendamentoconsultas.controller;

import br.com.fiap.techchallenge.apiagendamentoconsultas.dto.request.DadosAtualizacaoMedico;
import br.com.fiap.techchallenge.apiagendamentoconsultas.dto.request.DadosCadastroMedico;
import br.com.fiap.techchallenge.apiagendamentoconsultas.dto.response.DadosDetalhamentoMedico;
import br.com.fiap.techchallenge.apiagendamentoconsultas.dto.response.DadosListagemMedico;
import br.com.fiap.techchallenge.apiagendamentoconsultas.model.Medico;
import br.com.fiap.techchallenge.apiagendamentoconsultas.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.beans.Transient;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transient
    public ResponseEntity<DadosDetalhamentoMedico> cadastrar(@Valid @RequestBody DadosCadastroMedico dados, UriComponentsBuilder uriComponentsBuilder) {
        var medico = new Medico(dados);
        var uri = uriComponentsBuilder.path("/medico/{id}").buildAndExpand(medico.getId()).toUri();
        this.repository.save(medico);
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(Pageable paginacao) {
        var page = this.repository.findAll(paginacao).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoMedico> listarPorId(@PathVariable Long id) {
        var medico = this.repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @PutMapping
    @Transient
    public ResponseEntity<DadosDetalhamentoMedico> atualizar(@Valid @RequestBody DadosAtualizacaoMedico dados) {
        var medico = this.repository.getReferenceById(dados.id());
        medico.atualizarDados(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
