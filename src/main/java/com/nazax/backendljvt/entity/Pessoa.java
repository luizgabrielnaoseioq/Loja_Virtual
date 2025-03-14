package com.nazax.backendljvt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatorio")
    private String nome;

    @NotBlank(message = "O CPF é obrigatorio")
    private String cpf;

    @NotBlank(message = "O  é obrigatorio")
    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank(message = "A senha é obrigatorio")
    private String senha;

    @NotBlank(message = "O endereço é obrigatorio")
    private String endereco;

    @NotBlank(message = "O CEP é obrigatorio")
    private String cep;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidade cidade;
}