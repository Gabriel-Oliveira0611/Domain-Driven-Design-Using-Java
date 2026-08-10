package br.com.fiap.loja.view;

import br.com.fiap.loja.model.Produto;
import br.com.fiap.loja.model.ProdutoDigital;
import br.com.fiap.loja.model.ProdutoFisico;

import javax.swing.*;

public class Terminal {
    public static void main(String[] args) {

        // Instanciar um produto físico
        Produto produto = new ProdutoFisico(
                "Celular",
                3800.00,
                "0000123456789",
                15,
                1
        );

        // Ler o desconto em porcentagem
        //double descontoEmPorcentagem = produto.calcularDesconto(Integer.parseInt(JOptionPane.showInputDialog("Bem-vindo à calculadora de desconto! " +
                //"\n O valor do produto é: R$" + produto.getPreco() +
                //"\n\n Insira o desconto em porcentagem abaixo: ")));

        // Exibir preço final com desconto por porcentagem
        //JOptionPane.showMessageDialog(null, "Segue abaixo as informações!\n" +
                //"\n -> Valor inicial: R$" + produto.getPreco() +
                //"\n -> Valor com desconto: R$" + descontoEmPorcentagem);

        // Ler desconto em R$
        //double descontoEmValor = produto.calcularDesconto(Float.parseFloat(JOptionPane.showInputDialog("Bem-vindo à calculadora de desconto!" +
                //"\n O valor do produto é: R$" + produto.getPreco() +
                //"\n\n Insira o desconto em R$ abaixo:")));

        // Exibir o preço final com desconto em R$
        //JOptionPane.showMessageDialog(null, "Segue abaixo as informações!\n" +
                //"\n -> Valor inicial: R$" + produto.getPreco() +
                //"\n -> Valor com desconto: R$" + descontoEmValor);

        // Ler cupom
        String cupom = JOptionPane.showInputDialog(null,
                "Bem-vindo à calculadora de desconto!" +
                        "\nO valor inicial do produto é de R$" + produto.getPreco() +
                        "\n\nInsira abaixo um cupom:");


        double descontoCupom = produto.calcularDesconto(cupom);

        // Exibição do valor final
        switch (cupom) {
            case "FIAP20":
                JOptionPane.showMessageDialog(null,
                        "Segue informações!" +
                                "\n\n-> Valor inicial: R$" + produto.getPreco() +
                                "\n -> Cupom utilizado: " + cupom +
                                "\n\n-> Valor com desconto de 20%: R$" + descontoCupom);
                break;

            case "FIAP30":
                JOptionPane.showMessageDialog(null,
                        "Segue informações!" +
                                "\n\n-> Valor inicial: R$" + produto.getPreco() +
                                "\n -> Cupom utilizado: " + cupom +
                                "\n\n-> Valor com desconto de 30%: R$" + descontoCupom);
                break;

            case "PF50":
                JOptionPane.showMessageDialog(null,
                        "Segue informações!" +
                                "\n\n-> Valor inicial: R$" + produto.getPreco() +
                                "\n -> Cupom utilizado: " + cupom +
                                "\n\n-> Valor com desconto de 50%: R$" + descontoCupom);
                break;

            default:
                JOptionPane.showMessageDialog(null,
                        "Sem desconto!");
        }

        System.out.println(produto);

        System.out.println(produto.calcularDesconto(cupom));

        if (produto instanceof ProdutoFisico)
            System.out.println("É um produto físico");
        else if (produto instanceof ProdutoDigital)
            System.out.println("É um produto digital");

    }
}
