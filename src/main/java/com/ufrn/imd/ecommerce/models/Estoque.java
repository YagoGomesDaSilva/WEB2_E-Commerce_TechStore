package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "VARCHAR(14)")
    private String numDocumento;
    @Column
    private Integer quantidade;
    @Column(columnDefinition = "VARCHAR(20)")
    private String localEstoque;

    @OneToMany(mappedBy = "estoque", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MovimentacaoEstoque> movimentacoesEstoque;
    @ManyToOne
    @JoinColumn(name = "anunciante_id")
    private Anunciante anunciante;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Estoque() {

    }

    public Estoque(String numDocumento, Integer quantidade, String localEstoque, List<MovimentacaoEstoque> movimentacoesEstoque, Anunciante anunciante, Produto produto) {
        this.numDocumento = numDocumento;
        this.quantidade = quantidade;
        this.localEstoque = localEstoque;
        this.movimentacoesEstoque = movimentacoesEstoque;
        this.anunciante = anunciante;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getLocalEstoque() {
        return localEstoque;
    }

    public void setLocalEstoque(String localEstoque) {
        this.localEstoque = localEstoque;
    }

    public List<MovimentacaoEstoque> getMovimentacoesEstoque() {
        return movimentacoesEstoque;
    }

    public void setMovimentacoesEstoque(List<MovimentacaoEstoque> movimentacoesEstoque) {
        this.movimentacoesEstoque = movimentacoesEstoque;
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
        Estoque estoque = (Estoque) o;
        return Objects.equals(id, estoque.id) && Objects.equals(numDocumento, estoque.numDocumento) && Objects.equals(quantidade, estoque.quantidade) && Objects.equals(localEstoque, estoque.localEstoque) && Objects.equals(movimentacoesEstoque, estoque.movimentacoesEstoque) && Objects.equals(anunciante, estoque.anunciante) && Objects.equals(produto, estoque.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numDocumento, quantidade, localEstoque, movimentacoesEstoque, anunciante, produto);
    }
}
