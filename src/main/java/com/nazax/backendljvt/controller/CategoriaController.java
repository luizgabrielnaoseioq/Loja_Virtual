package com.nazax.backendljvt.controller;

import com.nazax.backendljvt.entity.Categoria;
import com.nazax.backendljvt.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping("/")
    public List<Categoria> buscarTodasCategorias() {
        return categoriaService.buscarCategorias();
    }

    @PostMapping("/")
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.criarCategoria(categoria);
    }

    @PutMapping("/")
    public Categoria atualizarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.atualizarCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCategoria(@PathVariable("id") Long id) {
        categoriaService.excluirCategoria(id);
        return ResponseEntity.ok().build();
    }
}
