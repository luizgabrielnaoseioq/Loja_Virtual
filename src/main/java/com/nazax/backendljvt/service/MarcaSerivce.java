package com.nazax.backendljvt.service;

import com.nazax.backendljvt.entity.Marca;
import com.nazax.backendljvt.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarcaSerivce {

    private final MarcaRepository marcaRepository;

    public List<Marca> buscarTodas() {
        return marcaRepository.findAll();
    }

    public Marca criarMarca(Marca marca) {
        marca.setDataCadastro(new Date());
        return marcaRepository.saveAndFlush(marca);
    }

    public Marca atualizarMarca(Marca marca) {
        marca.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(marca);
    }

    public void deletarMarca(Long id) {
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }
}