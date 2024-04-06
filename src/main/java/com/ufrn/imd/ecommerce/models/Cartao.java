package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "VARCHAR(16)")
    private String numero;
    @Column(columnDefinition = "VARCHAR(40)")
    private String nomeTitular;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate dataVencimento;
    @Column(columnDefinition = "VARCHAR(4)")
    private String codigoSeguranca;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioConcreto usuario;

    public Cartao() {
    }

    public Cartao(String numero, String nomeTitular, LocalDate dataVencimento, String codigoSeguranca, UsuarioConcreto usuario) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.dataVencimento = dataVencimento;
        this.codigoSeguranca = codigoSeguranca;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public UsuarioConcreto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioConcreto usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartao cartao = (Cartao) o;
        return Objects.equals(id, cartao.id) && Objects.equals(numero, cartao.numero) && Objects.equals(nomeTitular, cartao.nomeTitular) && Objects.equals(dataVencimento, cartao.dataVencimento) && Objects.equals(codigoSeguranca, cartao.codigoSeguranca) && Objects.equals(usuario, cartao.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, nomeTitular, dataVencimento, codigoSeguranca, usuario);
    }
}
