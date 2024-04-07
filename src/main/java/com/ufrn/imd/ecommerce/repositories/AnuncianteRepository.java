package com.ufrn.imd.ecommerce.repositories;

import com.ufrn.imd.ecommerce.models.Anunciante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnuncianteRepository extends JpaRepository<Anunciante, Long> {


    // Consulta para buscar todos os anunciantes com os relacionamentos carregados de forma ansiosa
    @Query("SELECT DISTINCT a FROM Anunciante a LEFT JOIN FETCH a.anuncios LEFT JOIN FETCH a.produtos LEFT JOIN FETCH a.estoques")
    List<Anunciante> findAllAnunciantesWithDetails();

    // Consulta para buscar um anunciante pelo ID com os relacionamentos carregados de forma ansiosa
    @Query("SELECT DISTINCT a FROM Anunciante a LEFT JOIN FETCH a.anuncios LEFT JOIN FETCH a.produtos LEFT JOIN FETCH a.estoques WHERE a.id = :anuncianteId")
    Optional<Anunciante> findAnuncianteByIdWithDetails(@Param("anuncianteId") Long anuncianteId);




}
