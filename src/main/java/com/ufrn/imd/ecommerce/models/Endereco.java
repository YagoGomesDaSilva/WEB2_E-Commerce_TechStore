package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String cidade;
    @Column(columnDefinition = "VARCHAR(100)")
    private String logradouro;
    @Column(columnDefinition = "VARCHAR(8)")
    private Integer numero;
    @Column(columnDefinition = "VARCHAR(50)")
    private String complemento;
    @Column(columnDefinition = "VARCHAR(50)")
    private String referencia;
    @Column(columnDefinition = "VARCHAR(50)")
    private String bairro;
    @Column(columnDefinition = "VARCHAR(8)")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioConcreto usuario;

    public Endereco() {

    }

    public Endereco(String cidade, String logradouro, Integer numero, String complemento, String referencia, String bairro, String cep, UsuarioConcreto usuario) {
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.referencia = referencia;
        this.bairro = bairro;
        this.cep = cep;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) && Objects.equals(cidade, endereco.cidade) && Objects.equals(logradouro, endereco.logradouro) && Objects.equals(numero, endereco.numero) && Objects.equals(complemento, endereco.complemento) && Objects.equals(referencia, endereco.referencia) && Objects.equals(bairro, endereco.bairro) && Objects.equals(cep, endereco.cep) && Objects.equals(usuario, endereco.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cidade, logradouro, numero, complemento, referencia, bairro, cep, usuario);
    }
}
