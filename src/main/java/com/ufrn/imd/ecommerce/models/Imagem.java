package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

@Entity
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idImagem;

    @Column(columnDefinition = "VARCHAR(50)")
    private String caminhoImagem;

    public long getIdImagem() {
        return idImagem;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
}
