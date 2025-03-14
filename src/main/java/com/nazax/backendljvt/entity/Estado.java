package com.nazax.backendljvt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Nome da cidade é obrigatorio!")
    private String nome;
    private String sigla;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public Estado(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public Estado() {

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(id, estado.id) && Objects.equals(nome, estado.nome) && Objects.equals(sigla, estado.sigla) && Objects.equals(dataCriacao, estado.dataCriacao) && Objects.equals(dataAtualizacao, estado.dataAtualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sigla, dataCriacao, dataAtualizacao);
    }
}