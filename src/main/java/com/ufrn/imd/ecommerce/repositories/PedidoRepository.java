package com.ufrn.imd.ecommerce.repositories;

import com.ufrn.imd.ecommerce.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
