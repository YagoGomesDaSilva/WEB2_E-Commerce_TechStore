package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(scale = 2)
    private BigDecimal valorTotal;

    @Column(columnDefinition = "VARCHAR(50)")
    private String marca;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "anunciante_id")
    private Anunciante anunciante;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "anuncio_id", referencedColumnName = "id")
    private Anuncio anuncio;


    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Imagem> imagems;
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Categoria> categorias;
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private  List<Estoque> estoques;

    @OneToMany(mappedBy = "produto")
    private Set<PedidoItem> pedidoItems;

    public Produto() {
    }


    public Produto(String nome, String descricao, BigDecimal valorTotal, String marca, String observacao, Anunciante anunciante, Anuncio anuncio, List<Imagem> imagems, List<Categoria> categorias, List<Estoque> estoques, Set<PedidoItem> pedidoItems) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.marca = marca;
        this.observacao = observacao;
        this.anunciante = anunciante;
        this.anuncio = anuncio;
        this.imagems = imagems;
        this.categorias = categorias;
        this.estoques = estoques;
        this.pedidoItems = pedidoItems;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Anunciante getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Anunciante anunciante) {
        this.anunciante = anunciante;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public List<Imagem> getImagems() {
        return imagems;
    }

    public void setImagems(List<Imagem> imagems) {
        this.imagems = imagems;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Estoque> getEstoques() {
        return estoques;
    }

    public void setEstoques(List<Estoque> estoques) {
        this.estoques = estoques;
    }

    public Set<PedidoItem> getPedidoItems() {
        return pedidoItems;
    }

    public void setPedidoItems(Set<PedidoItem> pedidoItems) {
        this.pedidoItems = pedidoItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(nome, produto.nome) && Objects.equals(descricao, produto.descricao) && Objects.equals(valorTotal, produto.valorTotal) && Objects.equals(marca, produto.marca) && Objects.equals(observacao, produto.observacao) && Objects.equals(anunciante, produto.anunciante) && Objects.equals(anuncio, produto.anuncio) && Objects.equals(imagems, produto.imagems) && Objects.equals(categorias, produto.categorias) && Objects.equals(estoques, produto.estoques) && Objects.equals(pedidoItems, produto.pedidoItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, valorTotal, marca, observacao, anunciante, anuncio, imagems, categorias, estoques, pedidoItems);
    }
}
