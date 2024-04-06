package com.ufrn.imd.ecommerce.repositories;

import com.ufrn.imd.ecommerce.models.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
}
