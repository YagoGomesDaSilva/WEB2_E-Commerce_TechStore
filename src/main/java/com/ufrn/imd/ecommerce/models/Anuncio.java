package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)")
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "anunciante_id")
    private Anunciante anunciante;

    @OneToOne(mappedBy = "anuncio")
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    private Produto produto;

    public Anuncio() {

    }

    public Anuncio(String titulo, String descricao, Anunciante anunciante, Produto produto) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.anunciante = anunciante;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Anunciante getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Anunciante anunciante) {
        this.anunciante = anunciante;
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
        Anuncio anuncio = (Anuncio) o;
        return Objects.equals(id, anuncio.id) && Objects.equals(titulo, anuncio.titulo) && Objects.equals(descricao, anuncio.descricao) && Objects.equals(anunciante, anuncio.anunciante) && Objects.equals(produto, anuncio.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, descricao, anunciante, produto);
    }
}
