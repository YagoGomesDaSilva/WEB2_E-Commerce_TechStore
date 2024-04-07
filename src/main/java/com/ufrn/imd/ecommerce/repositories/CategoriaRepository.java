package com.ufrn.imd.ecommerce.repositories;

import com.ufrn.imd.ecommerce.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Consulta para buscar todas as categorias com os relacionamentos carregados de forma ansiosa
    @Query("SELECT DISTINCT c FROM Categoria c LEFT JOIN FETCH c.categoriaPai LEFT JOIN FETCH c.subcategorias LEFT JOIN FETCH c.produto")
    List<Categoria> findAllCategoriasWithDetails();

    // Consulta para buscar uma categoria pelo ID com os relacionamentos carregados de forma ansiosa
    @Query("SELECT DISTINCT c FROM Categoria c LEFT JOIN FETCH c.categoriaPai LEFT JOIN FETCH c.subcategorias LEFT JOIN FETCH c.produto WHERE c.id = :categoriaId")
    Optional<Categoria> findCategoriaByIdWithDetails(@Param("categoriaId") Long categoriaId);

}
