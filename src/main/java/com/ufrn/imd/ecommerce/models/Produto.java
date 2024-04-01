package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

@Entity
//@Table(name = "Produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduto;

    @Column(columnDefinition = "VARCHAR(50)")
    private String nomeProduto;

    @Column(columnDefinition = "TEXT")
    private String descricaoProduto;

    @Column(columnDefinition = "DOUBLE")
    private double valorProduto;

    @Column(columnDefinition = "VARCHAR(50)")
    private String marcaProduto;

    @Column(columnDefinition = "TEXT")
    private String observacaoProduto;

    public long getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public String getObservacaoProduto() {
        return observacaoProduto;
    }

    public void setObservacaoProduto(String observacaoProduto) {
        this.observacaoProduto = observacaoProduto;
    }
}
