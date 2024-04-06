package com.ufrn.imd.ecommerce.repositories;

import com.ufrn.imd.ecommerce.models.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
}
