package com.nazax.backendljvt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoDTO {
    private Long id;

    private String nome;

    private String sigla;

    private Date dataCriacao;

    private Date dataAtualizacao;
}