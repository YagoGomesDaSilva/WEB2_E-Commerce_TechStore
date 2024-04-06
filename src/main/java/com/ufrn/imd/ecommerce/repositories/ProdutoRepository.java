package com.ufrn.imd.ecommerce.repositories;

import com.ufrn.imd.ecommerce.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
