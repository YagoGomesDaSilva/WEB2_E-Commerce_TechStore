package com.ufrn.imd.ecommerce.repositories;

import com.ufrn.imd.ecommerce.models.Anunciante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncianteRepository extends JpaRepository<Anunciante, Long> {
}
