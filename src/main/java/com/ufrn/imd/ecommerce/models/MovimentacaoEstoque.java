package com.ufrn.imd.ecommerce.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class MovimentacaoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate dataEmissao;
    @Column(columnDefinition = "VARCHAR(14)")
    private String numDocumento;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate dataEntrada;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate dataSaida;
    @Column(columnDefinition = "VARCHAR(7)")
    private String tipoMovimentacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioConcreto usuario;

    @ManyToOne
    @JoinColumn(name = "estoque_id")
    private Estoque estoque;

    public MovimentacaoEstoque() {
    }

    public MovimentacaoEstoque(LocalDate dataEmissao, String numDocumento, LocalDate dataEntrada, LocalDate dataSaida, String tipoMovimentacao, UsuarioConcreto usuario, Estoque estoque) {
        this.dataEmissao = dataEmissao;
        this.numDocumento = numDocumento;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.tipoMovimentacao = tipoMovimentacao;
        this.usuario = usuario;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public UsuarioConcreto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioConcreto usuario) {
        this.usuario = usuario;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovimentacaoEstoque that = (MovimentacaoEstoque) o;
        return Objects.equals(id, that.id) && Objects.equals(dataEmissao, that.dataEmissao) && Objects.equals(numDocumento, that.numDocumento) && Objects.equals(dataEntrada, that.dataEntrada) && Objects.equals(dataSaida, that.dataSaida) && Objects.equals(tipoMovimentacao, that.tipoMovimentacao) && Objects.equals(usuario, that.usuario) && Objects.equals(estoque, that.estoque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataEmissao, numDocumento, dataEntrada, dataSaida, tipoMovimentacao, usuario, estoque);
    }
}
