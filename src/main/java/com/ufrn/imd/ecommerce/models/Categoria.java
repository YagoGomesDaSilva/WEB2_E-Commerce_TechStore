package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_pai_id")
    private Categoria categoriaPai;

    @OneToMany(mappedBy = "categoriaPai", cascade = CascadeType.ALL)
    private List<Categoria> subcategorias;



    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Categoria() {
    }

    public Categoria(String nome, Categoria categoriaPai, List<Categoria> subcategorias, Produto produto) {
        this.nome = nome;
        this.categoriaPai = categoriaPai;
        this.subcategorias = subcategorias;
        this.produto = produto;
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

    public Categoria getCategoriaPai() {
        return categoriaPai;
    }

    public void setCategoriaPai(Categoria categoriaPai) {
        this.categoriaPai = categoriaPai;
    }

    public List<Categoria> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(List<Categoria> subcategorias) {
        this.subcategorias = subcategorias;
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
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id) && Objects.equals(nome, categoria.nome) && Objects.equals(categoriaPai, categoria.categoriaPai) && Objects.equals(subcategorias, categoria.subcategorias) && Objects.equals(produto, categoria.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, categoriaPai, subcategorias, produto);
    }
}