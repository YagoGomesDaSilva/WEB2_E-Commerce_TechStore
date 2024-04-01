package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
public class EntradaEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEntradaEstoque;

    @Column(columnDefinition = "DATE")
    private LocalDate dataEntrada;

    @Column(columnDefinition = "DATE")
    private LocalDate dataEmissao;

    @Column(columnDefinition = "VARCHAR(15)")
    private String numDocumento;

    @Column(columnDefinition = "INTEGER")
    private int quantidade;

    @OneToOne
    private Usuario usuario;

    @ManyToOne //como é manyToOne aqui deveria ser uma lista de produtos?
    private Produto produto;

    public long getIdEntradaEstoque() {
        return idEntradaEstoque;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
