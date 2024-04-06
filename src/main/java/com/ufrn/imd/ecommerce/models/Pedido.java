package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(scale = 2)
    private BigDecimal valorTotal;
    @Column(scale = 2)
    private BigDecimal valorFrete;
    @Column(scale = 2)
    private BigDecimal valorTotalItens;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate data;
    @Column(columnDefinition = "VARCHAR(20)")
    private String situacao;
    @Column
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioConcreto usuario;

    @OneToMany(mappedBy = "pedido")
    private Set<PedidoItem> pedidoItems;


    public Pedido() {
    }


    public Pedido(BigDecimal valorTotal, BigDecimal valorFrete, BigDecimal valorTotalItens, LocalDate data, String situacao, TipoPagamento tipoPagamento, UsuarioConcreto usuario, Set<PedidoItem> pedidoItems) {
        this.valorTotal = valorTotal;
        this.valorFrete = valorFrete;
        this.valorTotalItens = valorTotalItens;
        this.data = data;
        this.situacao = situacao;
        this.tipoPagamento = tipoPagamento;
        this.usuario = usuario;
        this.pedidoItems = pedidoItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public BigDecimal getValorTotalItens() {
        return valorTotalItens;
    }

    public void setValorTotalItens(BigDecimal valorTotalItens) {
        this.valorTotalItens = valorTotalItens;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public UsuarioConcreto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioConcreto usuario) {
        this.usuario = usuario;
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
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) && Objects.equals(valorTotal, pedido.valorTotal) && Objects.equals(valorFrete, pedido.valorFrete) && Objects.equals(valorTotalItens, pedido.valorTotalItens) && Objects.equals(data, pedido.data) && Objects.equals(situacao, pedido.situacao) && tipoPagamento == pedido.tipoPagamento && Objects.equals(usuario, pedido.usuario) && Objects.equals(pedidoItems, pedido.pedidoItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valorTotal, valorFrete, valorTotalItens, data, situacao, tipoPagamento, usuario, pedidoItems);
    }
}
