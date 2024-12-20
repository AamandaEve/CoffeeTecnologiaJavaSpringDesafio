package com.coffee.amanda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // /home
    public String home() {
        return "home";
    }

    @GetMapping("/produtos/cadastrar")
    public String produtos() {
        return "cadastrarProduto";
    }

    @GetMapping("/produtos/atualizar")
    public String atualizar() {
        return "atualizarProduto";
    }

    @GetMapping("/pedidos/cadastrar")
    public String pedidos() {
        return "realizarPedido";
    }

}
