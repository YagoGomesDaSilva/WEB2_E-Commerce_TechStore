package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

@Entity
public class SubCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSubCategoria;

    @Column(columnDefinition = "VARCHAR(50)")
    private String nomeSubCategoria;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Categoria categoria;
}
