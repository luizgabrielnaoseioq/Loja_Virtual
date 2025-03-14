package com.nazax.backendljvt.controller;

import com.nazax.backendljvt.entity.Marca;
import com.nazax.backendljvt.service.MarcaSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
@RequiredArgsConstructor
public class MarcaController {

    private final MarcaSerivce marcaSerivce;

    @GetMapping("/")
    public List<Marca> buscarTodasMarcas() {
        return marcaSerivce.buscarTodas();
    }

    @PostMapping("/")
    public Marca criarMarca(@RequestBody Marca marca) {
        return marcaSerivce.criarMarca(marca);
    }

    @PutMapping("/")
    public Marca atualizarMarca(@RequestBody Marca marca) {
        return marcaSerivce.atualizarMarca(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMarca(@PathVariable("id") Long id) {
        marcaSerivce.deletarMarca(id);
        return ResponseEntity.ok().build();
    }

}
