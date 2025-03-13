package com.nazax.backendljvt.controller;

import com.nazax.backendljvt.entity.Cidade;
import com.nazax.backendljvt.repository.CidadeRepository;
import com.nazax.backendljvt.service.CidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
@RequiredArgsConstructor
public class CidadeController {

    private final CidadeService cidadeService;

    public List<Cidade> buscarCidades() {
        return cidadeService.buscarTodasAsCidades();
    }

    public ResponseEntity<Void> removerCidade(@PathVariable Long id) {
        cidadeService.removerCidade(id);
        return ResponseEntity.ok().build();
    }
}
