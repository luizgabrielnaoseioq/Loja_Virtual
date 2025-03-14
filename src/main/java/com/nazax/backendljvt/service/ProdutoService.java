package com.nazax.backendljvt.service;

import com.nazax.backendljvt.entity.Produto;
import com.nazax.backendljvt.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<Produto> buscarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto criarProduto(Produto produto) {
        produto.setDataCriacao(new Date());
        return produtoRepository.saveAndFlush(produto);
    }

    public Produto atualizarProduto(Produto produto) {
        produto.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(produto);
    }

    public void deletarProduto(Long id) {
        Produto produto = produtoRepository.findById(id).get();
        produtoRepository.delete(produto);
    }
}
