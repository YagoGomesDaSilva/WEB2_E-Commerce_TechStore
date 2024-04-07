package com.ufrn.imd.ecommerce.repositories;

import com.ufrn.imd.ecommerce.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT DISTINCT p FROM Produto p JOIN FETCH p.imagems")
    List<Produto> findAllProdutosWithImagems();

    @Query("SELECT DISTINCT p FROM Produto p JOIN FETCH p.categorias")
    List<Produto> findAllProdutosWithCategorias();

    @Query("SELECT DISTINCT p FROM Produto p JOIN FETCH p.estoques")
    List<Produto> findAllProdutosWithEstoques();

    @Query("SELECT DISTINCT p FROM Produto p JOIN FETCH p.pedidoItems")
    List<Produto> findAllProdutosWithPedidoItems();

    @Query("SELECT DISTINCT p FROM Produto p JOIN FETCH p.imagems JOIN FETCH p.categorias JOIN FETCH p.estoques JOIN FETCH p.pedidoItems")
    List<Produto> findAllProdutosWithAllAssociations();

    @Query("SELECT DISTINCT p FROM Produto p JOIN FETCH p.imagems WHERE p.id = :produtoId")
    Optional<Produto> findProdutoByIdWithImagems(@Param("produtoId") Long produtoId);

    @Query("SELECT DISTINCT p FROM Produto p JOIN FETCH p.categorias WHERE p.id = :produtoId")
    Optional<Produto> findProdutoByIdWithCategorias(@Param("produtoId") Long produtoId);

    @Query("SELECT DISTINCT p FROM Produto p JOIN FETCH p.estoques WHERE p.id = :produtoId")
    Optional<Produto> findProdutoByIdWithEstoques(@Param("produtoId") Long produtoId);

    @Query("SELECT DISTINCT p FROM Produto p JOIN FETCH p.pedidoItems WHERE p.id = :produtoId")
    Optional<Produto> findProdutoByIdWithPedidoItems(@Param("produtoId") Long produtoId);

    @Query("SELECT DISTINCT p FROM Produto p JOIN FETCH p.imagems JOIN FETCH p.categorias JOIN FETCH p.estoques JOIN FETCH p.pedidoItems WHERE p.id = :produtoId")
    Optional<Produto> findProdutoByIdWithAllAssociations(@Param("produtoId") Long produtoId);


}
