package com.nazax.backendljvt.controller;

import com.nazax.backendljvt.entity.Cidade;
import com.nazax.backendljvt.service.CidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
@RequiredArgsConstructor
public class CidadeController {

    private final CidadeService cidadeService;

    @GetMapping("/")
    public List<Cidade> buscarCidades() {
        return cidadeService.buscarTodasAsCidades();
    }

    @PostMapping("/")
    public Cidade criarCidade(Cidade cidade) {
        return cidadeService.criarCidade(cidade);
    }

    public Cidade atualizarCidade(Cidade cidade) {
        return cidadeService.atualizarCidade(cidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCidade(@PathVariable("id") Long id) {
        cidadeService.removerCidade(id);
        return ResponseEntity.ok().build();
    }
}
