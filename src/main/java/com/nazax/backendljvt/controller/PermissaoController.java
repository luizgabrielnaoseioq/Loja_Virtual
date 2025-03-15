package com.nazax.backendljvt.controller;

import com.nazax.backendljvt.entity.Permissao;
import com.nazax.backendljvt.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissao")
@CrossOrigin
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/")
    public List<Permissao> buscarTodos(){
        return permissaoService.buscarTodos();
    }

    @PostMapping("/")
    public Permissao inserir(@RequestBody Permissao objeto){
        return permissaoService.inserir(objeto);
    }

    @PutMapping("/")
    public Permissao alterar(@RequestBody Permissao objeto){
        return permissaoService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        permissaoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}