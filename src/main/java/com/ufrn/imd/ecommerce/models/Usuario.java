package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @Column(columnDefinition = "VARCHAR(50)")
    private String nomeUsuario;

    @Column(columnDefinition = "VARCHAR(50)")
    private String emailUsuario;

    @Column(columnDefinition = "VARCHAR(50)")
    private String senha;

    @Column(columnDefinition = "VARCHAR(11)")
    private String cpf;

    @Column(columnDefinition = "VARCHAR(15)")
    private String numeroTelefone;

    @Column(columnDefinition = "VARCHAR(20)")
    private String tipoUsuario;

    @Column(columnDefinition = "VARCHAR(20)")
    private String situacaoUsuario;

    public long getIdUsuario() {
        return idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getSituacaoUsuario() {
        return situacaoUsuario;
    }

    public void setSituacaoUsuario(String situacaoUsuario) {
        this.situacaoUsuario = situacaoUsuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(columnDefinition = "VARCHAR(100)")
    private String token;
}
