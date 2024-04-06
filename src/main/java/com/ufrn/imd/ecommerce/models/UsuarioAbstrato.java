package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@MappedSuperclass
public abstract class UsuarioAbstrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "VARCHAR(50)")
    private String nome;
    @Column(columnDefinition = "VARCHAR(50)")
    private String email;
    @Column(columnDefinition = "VARCHAR(50)")
    private String senha;
    @Column(columnDefinition = "VARCHAR(15)")
    private String numeroTelefone;
    @Column
    private boolean tipo;
    @Column(columnDefinition = "VARCHAR(100)")
    private String token;
    @Column(scale = 2)
    private BigDecimal credito;

    public UsuarioAbstrato() {
    }

    public UsuarioAbstrato(String nome, String email, String senha, String numeroTelefone, boolean tipo, String token, BigDecimal credito) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.numeroTelefone = numeroTelefone;
        this.tipo = tipo;
        this.token = token;
        this.credito = credito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioAbstrato that = (UsuarioAbstrato) o;
        return tipo == that.tipo && Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(email, that.email) && Objects.equals(senha, that.senha) && Objects.equals(numeroTelefone, that.numeroTelefone) && Objects.equals(token, that.token) && Objects.equals(credito, that.credito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, senha, numeroTelefone, tipo, token, credito);
    }
}
