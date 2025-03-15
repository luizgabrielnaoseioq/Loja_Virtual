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

    private String descricaoCurta;

    private String descricaoDetalhada;

    private Double valorCusto;

    private Double valorVenda;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "idMarca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
}