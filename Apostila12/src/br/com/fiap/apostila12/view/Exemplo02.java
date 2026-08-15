package br.com.fiap.apostila12.view;

import br.com.fiap.apostila12.exception.CupomInvalidoException;
import br.com.fiap.apostila12.exception.PorcentagemNegativaException;
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

//        Desconto com cupom
        System.out.println("Insira o cupom:");
        String cupom = leitor.nextLine();
        try {
            double precoComDesconto = produto01.darDesconto(cupom);
            System.out.println(precoComDesconto);
        } catch (CupomInvalidoException e) {
            System.err.println(e.getMessage());
        }

//        Aumentar preço
        System.out.println("Insira abaixo a porcentagem:");
        double porcentagem = leitor.nextDouble();

        try {
            double precoMaior = produto01.aumentarImposto(porcentagem);
            System.out.println(precoMaior);
            System.out.println("faz o L");
        } catch (PorcentagemNegativaException e) {
            System.out.println(e.getMessage());
        }

//        Desconto com preço
        System.out.println("Quanto é o desconto?");
        double desconto = leitor.nextDouble();

        try {
            double precoComDesconto = produto01.darDesconto(desconto);
            System.out.println("O produto " + produto01.getNome() + " Custava R$" + produto01.getPreco());
            System.out.println("Agora, com desconto, custa R$" + precoComDesconto);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            System.out.println("O desconto deve ser menor do que R$" + produto01.getPreco());
        }
    }
}
