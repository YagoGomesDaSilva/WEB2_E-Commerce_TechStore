package com.ufrn.imd.ecommerce.models;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue("usuario")
public  class UsuarioConcreto extends UsuarioAbstrato{

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> enderecos;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cartao> cartoes;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pedido> pedidos;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MovimentacaoEstoque> movimentacoesEstoque;


    public UsuarioConcreto() {
        super();
    }

    public UsuarioConcreto(String nome, String email, String senha, String numeroTelefone, boolean tipo, String token, BigDecimal credito, List<Endereco> enderecos, List<Cartao> cartoes, List<Pedido> pedidos, List<MovimentacaoEstoque> movimentacoesEstoque) {
        super(nome, email, senha, numeroTelefone, tipo, token, credito);
        this.enderecos = enderecos;
        this.cartoes = cartoes;
        this.pedidos = pedidos;
        this.movimentacoesEstoque = movimentacoesEstoque;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<MovimentacaoEstoque> getMovimentacoesEstoque() {
        return movimentacoesEstoque;
    }

    public void setMovimentacoesEstoque(List<MovimentacaoEstoque> movimentacoesEstoque) {
        this.movimentacoesEstoque = movimentacoesEstoque;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UsuarioConcreto that = (UsuarioConcreto) o;
        return Objects.equals(enderecos, that.enderecos) && Objects.equals(cartoes, that.cartoes) && Objects.equals(pedidos, that.pedidos) && Objects.equals(movimentacoesEstoque, that.movimentacoesEstoque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), enderecos, cartoes, pedidos, movimentacoesEstoque);
    }
}
