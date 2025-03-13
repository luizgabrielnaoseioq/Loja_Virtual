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
    public ResponseEntity<Estado> buscarEstados() {
        List<Estado> estados = estadoService.findAll();
        return ResponseEntity.ok().body(estados.get(0));
    }

    @PostMapping("/")
    public Estado inserirEstado(@RequestBody Estado estado) {
        return estadoService.inserir(estado);
    }

    @PutMapping("/{id}")
    public Estado atualizarEstado(@PathParam("id") Estado estado) {
        return estadoService.atualizar(estado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEstado(@PathParam("id") Long id) {
        estadoService.deletear(id);
        return ResponseEntity.ok().build();
    }
}
