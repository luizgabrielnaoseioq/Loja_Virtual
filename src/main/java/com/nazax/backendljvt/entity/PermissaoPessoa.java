package com.nazax.backendljvt.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "permissao_pessoa")
public class PermissaoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "idPermissao")
    private Permissao permissao;

    @ManyToOne
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;
}
