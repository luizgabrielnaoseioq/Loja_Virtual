package com.nazax.backendljvt.service;

import com.nazax.backendljvt.entity.Pessoa;
import com.nazax.backendljvt.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public List<Pessoa> buscarTodasPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa criarPessoa(Pessoa pessoa) {
        pessoa.setDataCadastro(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public Pessoa atualizarPessoa(Pessoa pessoa) {
        pessoa.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public void deletarPessoa(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }
}
