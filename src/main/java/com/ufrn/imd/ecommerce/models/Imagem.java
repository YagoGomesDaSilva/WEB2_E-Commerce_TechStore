package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idImagem;

    @Column(columnDefinition = "VARCHAR(100)")
    private String caminhoImagem;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Imagem() {
    }

    public Imagem(String caminhoImagem, Produto produto) {
        this.caminhoImagem = caminhoImagem;
        this.produto = produto;
    }

    public Long getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(Long idImagem) {
        this.idImagem = idImagem;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imagem imagem = (Imagem) o;
        return Objects.equals(idImagem, imagem.idImagem) && Objects.equals(caminhoImagem, imagem.caminhoImagem) && Objects.equals(produto, imagem.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idImagem, caminhoImagem, produto);
    }
}
