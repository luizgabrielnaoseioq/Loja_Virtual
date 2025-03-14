package com.nazax.backendljvt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo obrigatorio")
    private String descricaoCurta;

    @NotBlank(message = "Campo obrigatorio")
    private String descricaoDetalhada;

    @NotNull(message = "Valor não pode ser nulo!")
    private Double valorCusto;

    @NotNull(message = "Valor não pode ser nulo!")
    private Double valorVenda;

    private Date dataCriacao;

    private Date dataAtualizacao;
}