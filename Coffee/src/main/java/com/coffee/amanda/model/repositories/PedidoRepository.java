package com.coffee.amanda.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.amanda.model.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
