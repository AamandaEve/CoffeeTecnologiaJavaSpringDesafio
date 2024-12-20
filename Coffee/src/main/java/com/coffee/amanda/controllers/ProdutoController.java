package com.coffee.amanda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.amanda.model.entities.Produto;
import com.coffee.amanda.model.repositories.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping("/cadastrar")
    public Produto cadastrarProduto(@Valid Produto produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("/atualizar")
    public Produto atualizarProduto(@Valid Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping("/todos")
    public Iterable<Produto> obterProdutos() { // obter produtos
        return produtoRepository.findAll();
        // List<Produto> produtos =
    }

    @DeleteMapping(path = "/deletar/{id}")
    public void deletarProdutoPorId(@PathVariable int id) { // deletar produto por id
        produtoRepository.deleteById(id);
    }

}
