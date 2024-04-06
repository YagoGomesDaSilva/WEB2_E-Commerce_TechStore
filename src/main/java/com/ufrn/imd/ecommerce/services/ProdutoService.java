package com.ufrn.imd.ecommerce.services;

import com.ufrn.imd.ecommerce.models.Produto;
import com.ufrn.imd.ecommerce.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto findProduto(Long idProduto) throws Exception {
        Produto produto = produtoRepository.findById(idProduto).isPresent() ? produtoRepository.findById(idProduto).get() : null;

        if(produto == null){
            throw new Exception("Produto não encontrado");
        }
        return produto;
    }

    public void createProduto(Produto produto) {
        //to-do validações para criação do produto
        produtoRepository.save(produto);
    }

    public List<Produto> findProdutos() throws Exception {
        List<Produto> produtos = produtoRepository.findAll();
        if(produtos.isEmpty()){
            throw new Exception();
        }
        return  produtos;
    }

    public void updateProduto(Produto produto) throws Exception {
        if(produtoRepository.findById(produto.getId()).isPresent()){
            //to-do implementar update em produto
        } else {
            throw new Exception("Produto não encontrado");
        }
    }
}
