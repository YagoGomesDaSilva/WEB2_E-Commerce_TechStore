package com.ufrn.imd.ecommerce.repositories;

import com.ufrn.imd.ecommerce.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
