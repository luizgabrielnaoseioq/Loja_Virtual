package com.nazax.backendljvt.controller;

import com.nazax.backendljvt.entity.Produto;
import com.nazax.backendljvt.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> buscarProdutos() {
        return produtoService.buscarProdutos();
    }

    @PostMapping("/")
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @PutMapping("/")
    public Produto atualizarProduto(@RequestBody Produto produto) {
        return produtoService.atualizarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletarProduto(@PathVariable("id") Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.ok().build();
    }

}
