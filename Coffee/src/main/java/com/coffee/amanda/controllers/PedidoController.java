package com.coffee.amanda.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.amanda.model.entities.Pedido;
import com.coffee.amanda.model.entities.Produto;
import com.coffee.amanda.model.repositories.PedidoRepository;
import com.coffee.amanda.model.repositories.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/cadastrar")
    public Produto criarPedido(@Valid Pedido pedido, int produtoId) {
        Optional<Produto> produtoOptional = produtoRepository.findById(produtoId);
        if (produtoOptional.isEmpty()) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        Produto produto = produtoOptional.get();
        if (pedido.getQuantidadeDeProdutos() > produto.getQuantidadeEmEstoque()) {
            throw new IllegalArgumentException("Quantidade de produtos excede o estoque. Quantidade em estoque: "
                    + produto.getQuantidadeEmEstoque());
        } else {
            int estoque = produto.getQuantidadeEmEstoque() - pedido.getQuantidadeDeProdutos();
            produto.setQuantidadeEmEstoque(estoque);
        }

        pedido.adicionarProduto(produto);
        pedidoRepository.save(pedido);
        ;

        return produto;
    }

    @GetMapping(path = "/detalhes/{id}")
    public Optional<Pedido> obterPedidoPorId(@PathVariable int id) {
        return pedidoRepository.findById(id);
    }

    @PutMapping("/atualizar")
    public void alterarStatus(@Valid Pedido pedido){
        pedidoRepository.save(pedido);
    }

}
