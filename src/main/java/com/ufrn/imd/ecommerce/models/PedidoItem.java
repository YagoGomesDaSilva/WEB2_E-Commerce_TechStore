package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Column
    private Long quantidade;

    public PedidoItem() {
    }

    public PedidoItem(Produto produto, Pedido pedido, Long quantidade) {
        this.produto = produto;
        this.pedido = pedido;
        this.quantidade = quantidade;
    }


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
