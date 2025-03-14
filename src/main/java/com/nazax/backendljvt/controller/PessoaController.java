package com.nazax.backendljvt.controller;

import com.nazax.backendljvt.entity.Pessoa;
import com.nazax.backendljvt.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping("/")
    public List<Pessoa> buscarPessoas() {
        return pessoaService.buscarTodasPessoas();
    }

    @PostMapping("/")
    public Pessoa criarPessoa(@Valid @RequestBody Pessoa pessoa) {
        return pessoaService.criarPessoa(pessoa);
    }

    @PutMapping("/")
    public Pessoa atualizarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.atualizarPessoa(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable("id") Long id) {
        pessoaService.deletarPessoa(id);
        return ResponseEntity.ok().build();
    }
}
