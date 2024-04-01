package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

@Entity
public class ImagemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idImagemProduto;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Imagem imagem;
}
