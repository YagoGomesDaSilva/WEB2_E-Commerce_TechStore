package com.ufrn.imd.ecommerce.controllers;

import com.ufrn.imd.ecommerce.models.Produto;
import com.ufrn.imd.ecommerce.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping(value = "/produto")
    public ResponseEntity<?> getProduto(@RequestParam(value = "idProduto") Long idProduto){
        try{
            Produto produto = produtoService.findProduto(idProduto);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/produtos")
    public ResponseEntity<?> getProdutos(){
        try {
            List<Produto> produtos = produtoService.findProdutos();
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/produto")
    public ResponseEntity<?> createProduto(@RequestBody Produto produto){
        try {
            produtoService.createProduto(produto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/produto")
    public ResponseEntity<?> updateProduto(@RequestBody Produto produto) {
        try {
            produtoService.updateProduto(produto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
