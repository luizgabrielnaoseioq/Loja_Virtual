package com.nazax.backendljvt.controller;

import com.nazax.backendljvt.entity.Permissao;
import com.nazax.backendljvt.service.PermissaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissao")
@RequiredArgsConstructor
public class PermissaoController {

    private final PermissaoService permissaoService;

    @GetMapping("/")
    public List<Permissao> listarPermissoes(){
        return permissaoService.buscarTudo();
    }

    @PostMapping("/")
    public Permissao criarPermissao(@RequestBody Permissao permissao){
        return permissaoService.criarPermissao(permissao);
    }

    @PutMapping("/")
    public Permissao atualizarPermissao(@RequestBody Permissao permissao){
        return permissaoService.atualizarPermissao(permissao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPermissao(@PathVariable("id") Long id){
        permissaoService.excluirPermissao(id);
        return ResponseEntity.ok().build();
    }
}
