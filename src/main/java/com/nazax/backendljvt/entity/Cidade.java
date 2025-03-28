package com.nazax.backendljvt.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    @ManyToOne
    @JoinColumn(name = "idEstado")
    private Estado estado;

    public Cidade() {}

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }
}
