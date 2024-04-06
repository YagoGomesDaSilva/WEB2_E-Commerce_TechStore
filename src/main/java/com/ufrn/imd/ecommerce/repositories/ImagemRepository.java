package com.ufrn.imd.ecommerce.repositories;

import com.ufrn.imd.ecommerce.models.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {
}
