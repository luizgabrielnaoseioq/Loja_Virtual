package com.nazax.backendljvt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.lang.invoke.CallSite;
import java.util.Date;
import java.util.List;

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
    @JoinColumn(name = "idCidade")
    private Cidade cidade;

    @Setter(value = AccessLevel.NONE)
    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PermissaoPessoa> permissaoPessoa;

    public void setPermissaoPessoas(List<PermissaoPessoa> pp){
        for (PermissaoPessoa p : pp){
            p.setPessoa(this);
        }
        this.permissaoPessoa = pp;
    }
}