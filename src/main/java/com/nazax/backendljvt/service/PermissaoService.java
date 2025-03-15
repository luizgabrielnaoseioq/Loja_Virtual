package com.nazax.backendljvt.service;

import com.nazax.backendljvt.entity.Permissao;
import com.nazax.backendljvt.repository.PermissaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissaoService {


    private final PermissaoRepository permissaoRepository;

    public List<Permissao> buscarTudo() {
        return permissaoRepository.findAll();
    }

    public Permissao criarPermissao(Permissao permissao) {
        permissao.setDataCadastro(new Date());
        return permissaoRepository.saveAndFlush(permissao);
    }

    public Permissao atualizarPermissao(Permissao permissao) {
        permissao.setDataAtualizacao(new Date());
        return permissaoRepository.saveAndFlush(permissao);
    }

    public void excluirPermissao(Long id) {
        permissaoRepository.deleteById(id);
    }
}
