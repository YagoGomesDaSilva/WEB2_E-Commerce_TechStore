package com.ufrn.imd.ecommerce.repositories;

import com.ufrn.imd.ecommerce.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
