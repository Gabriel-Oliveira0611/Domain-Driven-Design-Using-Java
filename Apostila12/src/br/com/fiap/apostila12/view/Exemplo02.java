package br.com.fiap.apostila12.view;

import br.com.fiap.apostila12.model.Produto;

import java.util.Scanner;

public class Exemplo02 {
    static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

//       Instanciar um produto com nome e preço.

        Produto produto01 = new Produto(
                "Xiaomi remdi note 14",
                1800
        );

        Produto produto02 = new Produto(
                "Samsung a70",
                3500
        );

        Produto produto03 = new Produto(
                "Smartwatch QCY",
                250
        );

        System.out.println("Quanto é o desconto?");
        double desconto = leitor.nextDouble();

        try {
            double precoComDesconto = produto01.darDesconto(desconto);
            System.out.println(precoComDesconto);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
