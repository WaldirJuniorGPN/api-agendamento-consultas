package br.com.fiap.techchallenge.apiagendamentoconsultas.controller;

import br.com.fiap.techchallenge.apiagendamentoconsultas.dto.request.DadosAtualizacaoPaciente;
import br.com.fiap.techchallenge.apiagendamentoconsultas.dto.request.DadosCadastroPaciente;
import br.com.fiap.techchallenge.apiagendamentoconsultas.dto.response.DadosDetalhamentoPaciente;
import br.com.fiap.techchallenge.apiagendamentoconsultas.dto.response.DadosListagemPaciente;
import br.com.fiap.techchallenge.apiagendamentoconsultas.model.Paciente;
import br.com.fiap.techchallenge.apiagendamentoconsultas.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.beans.Transient;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final int DEZ_RESULTADOS_POR_PAGINA = 10;

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transient
    public ResponseEntity<DadosDetalhamentoPaciente> cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriComponentsBuilder) {
        var paciente = new Paciente(dados);
        var uri = uriComponentsBuilder.path("paciente/{id}").buildAndExpand(paciente.getId()).toUri();
        this.repository.save(paciente);
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(Pageable paginacao) {
        var sortPorNome = Sort.by("nome").ascending();
        var paginacaoAtualizada = PageRequest.of(paginacao.getPageNumber(), this.DEZ_RESULTADOS_POR_PAGINA, sortPorNome);
        var page = this.repository.findAll(paginacaoAtualizada).map(DadosListagemPaciente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoPaciente> buscarPorId(@PathVariable Long id) {
        var paciente = this.repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @PutMapping
    @Transient
    public ResponseEntity<DadosDetalhamentoPaciente> atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = this.repository.getReferenceById(dados.id());
        paciente.atualizarDados(dados);
        this.repository.save(paciente);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
