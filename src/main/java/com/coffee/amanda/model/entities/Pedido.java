package com.coffee.amanda.model.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Min(1)
    private int quantidadeDeProdutos;

    @ManyToMany
    @JoinTable(name = "pedido_produto", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "pedido_id"), // Chave estrangeira para Pedido
            inverseJoinColumns = @JoinColumn(name = "produto_id") // Chave estrangeira para Produto
    )
    private Set<Produto> produtos = new HashSet<>();

    private LocalDate dataDoPedido;

    private StatusPedido statusPedido;

    public Pedido(int quantidadeDeProdutos, Set<Produto> produtos, LocalDate dataDoPedido, StatusPedido statusPedido) {
        this.quantidadeDeProdutos = quantidadeDeProdutos;
        this.produtos = produtos;
        this.dataDoPedido = dataDoPedido;
        this.statusPedido = statusPedido;
    }

    public Pedido(StatusPedido statusPedido){
        this.statusPedido = statusPedido;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidadeDeProdutos() {
        return quantidadeDeProdutos;
    }

    public void setQuantidadeDeProdutos(int quantidadeDeProdutos) {
        this.quantidadeDeProdutos = quantidadeDeProdutos;
    }

    public LocalDate getDataDoPedido() {
        return dataDoPedido;
    }

    public void setDataDoPedido(LocalDate dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

}