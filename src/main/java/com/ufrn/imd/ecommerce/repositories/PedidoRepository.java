package com.ufrn.imd.ecommerce.repositories;

import com.ufrn.imd.ecommerce.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query("SELECT DISTINCT p FROM Pedido p JOIN FETCH p.pedidoItems")
    List<Pedido> findAllPedidosWithPedidoItems();

    @Query("SELECT DISTINCT p FROM Pedido p JOIN FETCH p.usuario WHERE p.id = :pedidoId")
    Optional<Pedido> findPedidoByIdWithUsuario(@Param("pedidoId") Long pedidoId);

    @Query("SELECT DISTINCT p FROM Pedido p JOIN FETCH p.pedidoItems JOIN FETCH p.usuario WHERE p.id = :pedidoId")
    Optional<Pedido> findPedidoByIdWithPedidoItemsAndUsuario(@Param("pedidoId") Long pedidoId);

}
