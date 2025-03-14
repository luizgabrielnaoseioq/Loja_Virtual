package com.nazax.backendljvt.service;

import com.nazax.backendljvt.entity.Categoria;
import com.nazax.backendljvt.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> buscarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria criarCategoria(Categoria categoria) {
        categoria.setDataCriacao(new Date());
        return categoriaRepository.saveAndFlush(categoria);
    }

    public Categoria atualizarCategoria(Categoria categoria) {
        categoria.setDataAtualizacao(new Date());
        return categoriaRepository.saveAndFlush(categoria);
    }

    public void excluirCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
