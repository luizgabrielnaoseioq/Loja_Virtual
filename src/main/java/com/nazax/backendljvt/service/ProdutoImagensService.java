package com.nazax.backendljvt.service;

import com.nazax.backendljvt.entity.Produto;
import com.nazax.backendljvt.entity.ProdutoImagens;
import com.nazax.backendljvt.repository.ProdutoImagensRepository;
import com.nazax.backendljvt.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoImagensService {

    private final ProdutoImagensRepository produtoImagensRepository;

    private final ProdutoRepository produtoRepository;

    public List<ProdutoImagens> buscarTodas() {
        return produtoImagensRepository.findAll();
    }

    public ProdutoImagens adicionarImagem(Long idProduto, MultipartFile file){
        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagens objeto = new ProdutoImagens();
        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths
                        .get("c:/imagens/" + nomeImagem);
                Files.write(caminho, bytes);
                objeto.setNome(nomeImagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        objeto.setProduto(produto);
        objeto.setDataCadastro(new Date());
        objeto = produtoImagensRepository.saveAndFlush(objeto);
        return objeto;
    }

    public ProdutoImagens atualizarImagem(ProdutoImagens produtoImagens){
        produtoImagens.setDataAtualizacao(new Date());
        return produtoImagensRepository.saveAndFlush(produtoImagens);
    }

    public void removerImagem(Long id){
        produtoImagensRepository.deleteById(id);
    }
}
