package com.nazax.backendljvt.service;

import com.nazax.backendljvt.entity.Cidade;
import com.nazax.backendljvt.repository.CidadeRepository;
import com.nazax.backendljvt.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CidadeService {

    private final CidadeRepository cidadeRepository;
    private final EstadoRepository estadoRepository;

    public List<Cidade> buscarTodasAsCidades() {
        return cidadeRepository.findAll();
    }

    public Cidade criarCidade(Cidade cidade) {
        cidade.setDataCadastro(new Date());
        return cidadeRepository.saveAndFlush(cidade);
    }

    public Cidade atualizarCidade(Cidade cidade) {
        cidade.setDataAlteracao(new Date());
        return cidadeRepository.saveAndFlush(cidade);
    }

    public void removerCidade(Long id) {
        Cidade cidade = cidadeRepository.findById(id).get();
        cidadeRepository.delete(cidade);
    }
}
