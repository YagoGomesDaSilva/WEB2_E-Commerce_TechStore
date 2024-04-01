package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategoria;

    @Column(columnDefinition = "VARCHAR(50)")
    private String nomeCategoria;

    public long getIdCategoria() {
        return idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
