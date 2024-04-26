package br.com.fiap.tech.challenge.api.agendamento.consultas.controller;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.DadosAtualizacaoPaciente;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.PacienteService;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.DadosCadastroPaciente;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.DadosDetalhamentoPaciente;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.DadosListagemPaciente;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoPaciente> cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriComponentsBuilder) {
        return this.service.cadastrar(dados, uriComponentsBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(Pageable paginacao) {
        return this.service.listarTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoPaciente> buscarPorId(@PathVariable Long id) {
        return this.service.buscarPorId(id);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoPaciente> atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        return this.service.atualizarDados(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return this.service.deletar(id);
    }

}
