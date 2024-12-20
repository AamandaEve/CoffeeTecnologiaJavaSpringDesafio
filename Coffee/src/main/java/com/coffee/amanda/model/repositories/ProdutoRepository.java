package com.coffee.amanda.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.amanda.model.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
