package br.com.fiap.tech.challenge.api.agendamento.consultas.controller;

import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.DadosAtualizacaoMedico;
import br.com.fiap.tech.challenge.api.agendamento.consultas.service.MedicoService;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.request.DadosCadastroMedico;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.DadosDetalhamentoMedico;
import br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response.DadosListagemMedico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoMedico> cadastrar(@Valid @RequestBody DadosCadastroMedico dados, UriComponentsBuilder uriComponentsBuilder) {
        return this.service.cadastrar(dados, uriComponentsBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(Pageable paginacao) {
        return this.service.listarTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoMedico> buscarPorId(@PathVariable Long id) {
        return this.service.buscarPorId(id);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoMedico> atualizar(@Valid @RequestBody DadosAtualizacaoMedico dados) {
        return this.service.atualizarDados(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return this.service.deletar(id);
    }
}
