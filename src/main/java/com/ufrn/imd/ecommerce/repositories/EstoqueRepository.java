package com.ufrn.imd.ecommerce.repositories;

import com.ufrn.imd.ecommerce.models.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
