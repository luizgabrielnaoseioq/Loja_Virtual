package com.nazax.backendljvt.controller;

import com.nazax.backendljvt.entity.Estado;
import com.nazax.backendljvt.service.EstadoService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
@RequiredArgsConstructor
public class EstadoController {

    private final EstadoService estadoService;

    @GetMapping("/")
    public List<Estado> buscarEstados() {
        return estadoService.buscarTodos();
    }

    @PostMapping("/")
    public Estado inserirEstado(@RequestBody Estado estado) {
        return estadoService.inserir(estado);
    }

    @PutMapping("/")
    public Estado atualizarEstado(@RequestBody Estado estado) {
        return estadoService.atualizar(estado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEstado(@PathVariable("id") Long id) {
        estadoService.deletear(id);
        return ResponseEntity.ok().build();
    }
}
