package com.nazax.backendljvt.controller;

import com.nazax.backendljvt.entity.ProdutoImagens;
import com.nazax.backendljvt.service.ProdutoImagensService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/produtoImagens")
public class ProdutoImagensController {

    private final ProdutoImagensService service;

    @GetMapping("/")
    public List<ProdutoImagens> bucarTodas(){
        return service.buscarTodas();
    }

    @PostMapping("/")
    public ProdutoImagens salvar(@RequestParam("file") MultipartFile file,@RequestParam("idProduto") Long idProduto){
        return service.adicionarImagem(idProduto,file);
    }


}
