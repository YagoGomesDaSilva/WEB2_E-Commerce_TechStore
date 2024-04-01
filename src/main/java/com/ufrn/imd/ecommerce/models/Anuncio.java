package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

@Entity
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(columnDefinition = "VARCHAR(100)")
    private String tituloAnuncio;

    @Column(columnDefinition = "TEXT")
    private String descricaoAnuncio;

    @OneToOne
    private Produto produto;

    public String getTituloAnuncio() {
        return tituloAnuncio;
    }

    public void setTituloAnuncio(String tituloAnuncio) {
        this.tituloAnuncio = tituloAnuncio;
    }

    public String getDescricaoAnuncio() {
        return descricaoAnuncio;
    }

    public void setDescricaoAnuncio(String descricaoAnuncio) {
        this.descricaoAnuncio = descricaoAnuncio;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
