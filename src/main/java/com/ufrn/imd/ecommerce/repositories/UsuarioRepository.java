package com.ufrn.imd.ecommerce.repositories;

import com.ufrn.imd.ecommerce.models.UsuarioConcreto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioConcreto, Long> {


    @Query("SELECT u FROM UsuarioConcreto u JOIN FETCH u.enderecos WHERE u.id = :usuarioId")
    UsuarioConcreto findUsuarioConcretoByIdWithEnderecos(@Param("usuarioId") Long usuarioId);

    @Query("SELECT u FROM UsuarioConcreto u JOIN FETCH u.cartoes WHERE u.id = :usuarioId")
    UsuarioConcreto findUsuarioConcretoByIdWithCartoes(@Param("usuarioId") Long usuarioId);

    @Query("SELECT u FROM UsuarioConcreto u JOIN FETCH u.pedidos WHERE u.id = :usuarioId")
    UsuarioConcreto findUsuarioConcretoByIdWithPedidos(@Param("usuarioId") Long usuarioId);

    @Query("SELECT u FROM UsuarioConcreto u JOIN FETCH u.movimentacoesEstoque WHERE u.id = :usuarioId")
    UsuarioConcreto findUsuarioConcretoByIdWithMovimentacoesEstoque(@Param("usuarioId") Long usuarioId);

    @Query("SELECT DISTINCT u FROM UsuarioConcreto u JOIN FETCH u.enderecos JOIN FETCH u.cartoes JOIN FETCH u.pedidos JOIN FETCH u.movimentacoesEstoque WHERE u.id = :usuarioId")
    UsuarioConcreto findUsuarioConcretoByIdWithAllAssociations(@Param("usuarioId") Long usuarioId);

    @Query("SELECT DISTINCT u FROM UsuarioConcreto u JOIN FETCH u.enderecos")
    List<UsuarioConcreto> findAllUsuarioConcretoWithEnderecos();

    @Query("SELECT DISTINCT u FROM UsuarioConcreto u JOIN FETCH u.cartoes")
    List<UsuarioConcreto> findAllUsuarioConcretoWithCartoes();

    @Query("SELECT DISTINCT u FROM UsuarioConcreto u JOIN FETCH u.pedidos")
    List<UsuarioConcreto> findAllUsuarioConcretoWithPedidos();

    @Query("SELECT DISTINCT u FROM UsuarioConcreto u JOIN FETCH u.movimentacoesEstoque")
    List<UsuarioConcreto> findAllUsuarioConcretoWithMovimentacoesEstoque();

    @Query("SELECT DISTINCT u FROM UsuarioConcreto u JOIN FETCH u.enderecos JOIN FETCH u.cartoes JOIN FETCH u.pedidos JOIN FETCH u.movimentacoesEstoque")
    List<UsuarioConcreto> findAllUsuarioConcretoWithAllAssociations();




}
