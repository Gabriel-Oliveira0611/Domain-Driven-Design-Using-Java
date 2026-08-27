package br.com.fiap.transportadora.view;

import br.com.fiap.transportadora.model.Produto;

public class Terminal {

    public static void main(String[] args) {

        // Criação do produto
        Produto produto = new Produto(
                60,
                "Celular",
                50.64,
                true,
                02f
        );

        Produto xiaomi = new Produto(
                61,
                "Xiaomi",
                50.6
        );

    }
}
