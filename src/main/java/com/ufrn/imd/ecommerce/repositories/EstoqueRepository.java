package com.ufrn.imd.ecommerce.repositories;

import com.ufrn.imd.ecommerce.models.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    // Consulta para buscar todos os registros de Estoque com os relacionamentos carregados de forma ansiosa
    @Query("SELECT DISTINCT e FROM Estoque e LEFT JOIN FETCH e.movimentacoesEstoque LEFT JOIN FETCH e.anunciante LEFT JOIN FETCH e.produto")
    List<Estoque> findAllEstoquesWithDetails();

    // Consulta para buscar um registro de Estoque pelo ID com os relacionamentos carregados de forma ansiosa
    @Query("SELECT DISTINCT e FROM Estoque e LEFT JOIN FETCH e.movimentacoesEstoque LEFT JOIN FETCH e.anunciante LEFT JOIN FETCH e.produto WHERE e.id = :estoqueId")
    Optional<Estoque> findEstoqueByIdWithDetails(@Param("estoqueId") Long estoqueId);


}
