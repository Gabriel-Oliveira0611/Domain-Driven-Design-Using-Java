package br.com.fiap.churros.controller;

import br.com.fiap.churros.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

    @GetMapping
    public String get() {

        Produto produto = new Produto(1, "Celular xiaomi", "xiaomi redmi note 14s", 2800, true);

        return produto.toString();
    }
}
