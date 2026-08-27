package br.com.fiap.loja.view;

import br.com.fiap.loja.model.Eletronicos;
import br.com.fiap.loja.model.Livro;
import br.com.fiap.loja.model.Produto;

import javax.swing.*;

public class Terminal {

    static void main(String[] args) {
        // Criação dos objetos
        Livro livro = new Livro(
                "Cristianismo Puro e Simples",
                "Cristianismo Puro e Simples é um livro de C. S. Lewis, adaptado de uma série de conversas de rádio levadas ao ar pela BBC entre 1941 e 1944, quando Lewis estava em Oxford, durante a II Guerra Mundial. Considerado um clássico da apológética cristã, as transcrições foram originalmente publicadas como panfletos separados: Broadcast Talks (1942), Christian Behaviour (1943), and Beyond Personality (1944)[1]. Lewis havia sido convidado pelo reverendo James Welch, diretor de assuntos de religião da BBC, que havia lido The Problem of Pain, livro de C. S. Lewis de 1940.",
                30.00,
                "C.S. Lewis",
                "Thomas Nelson Brasil");

        Eletronicos eletronico = new Eletronicos(
                "Xioami redmi note 14s",
                "Celular da marca Xiaomi",
                1275.00,
                "256GB",
                "Xiaomi");


        int produtoEscolhido = Integer.parseInt(JOptionPane.showInputDialog("Seja bem-vindo à nossa loja!" +
                "\nQual produto você deseja comprar? Digite o numero da opção desejada" +
                "\nTemos as seguintes opções: " +
                "\n\n 1) -> Livro " + livro.getNome() +
                "\n 2) -> Celular " + eletronico.getNome()));

        int metodoDesconto = Integer.parseInt(JOptionPane.showInputDialog("Perfeitamente! Temos as seguintes opções de desconto." +
                "\nDigite abaixo o numero da opção escolhida:" +
                "\n\n1) Quantidade em estoque" +
                "\n2) Porcentagem" +
                "\n3) Cupom"));

        double valorDescontado = 0;

        switch (produtoEscolhido) {
            case 1:
                switch (metodoDesconto) {
                    case 1:
                        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Insira abaixo a quantidade de unidades em estoque:"));
                        valorDescontado = livro.calcularDesconto(quantidade);
                        livro.calcularDesconto(quantidade);
                        JOptionPane.showMessageDialog(null,
                                "Perfeitamente! Você escolheu comprar o livro " + livro.getNome() +
                                        "\n-> Descrição: " + livro.getDescricao() +
                                        "\n-> Autor: " + livro.getAutor() +
                                        "\n-> Editora: " + livro.getEditora() +
                                        "\n\nTemos " + quantidade + " unidades em estoque!" +
                                        "\n\n-> Valor Original: R$" + livro.getPreco() +
                                        "\n-> Valor com desconto: R$" + valorDescontado);
                        break;

                    case 2:
                        float porcentagem = Float.parseFloat(JOptionPane.showInputDialog("Insira o porcentagem de desconto: "));
                        valorDescontado = livro.calcularDesconto(porcentagem);
                        livro.calcularDesconto(porcentagem);
                        JOptionPane.showMessageDialog(null,
                                "Perfeitamente! Você escolheu comprar o livro " + livro.getNome() +
                                        "\n-> Descrição: " + livro.getDescricao() +
                                        "\n-> Autor: " + livro.getAutor() +
                                        "\n-> Editora: " + livro.getEditora() +
                                        "\nFoi escolhida uma porcentagem de desconto de " + porcentagem + "%" +
                                        "\n\n-> Valor original: R$" + livro.getPreco() +
                                        "\n-> Valor com desconto: R$" + valorDescontado);
                        break;

                    case 3:
                        String cupom = JOptionPane.showInputDialog("Insira abaixo o cupom:");
                        valorDescontado = livro.calcularDesconto(cupom);
                        JOptionPane.showMessageDialog(null,
                                "Perfeitamente! Você escolheu comprar o livro " + livro.getNome() +
                                        "\n-> Descrição: " + livro.getDescricao() +
                                        "\n-> Autor: " + livro.getAutor() +
                                        "\n-> Editora: " + livro.getEditora() +
                                        "\nFoi inserido o cupom " + cupom +
                                        "\n\n-> Valor original: R$" + livro.getPreco() +
                                        "\n-> Valor com desconto: R$" + valorDescontado);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null,
                                "Não foi aplicado desconto!");
                        break;
                }
                break;

            case 2:
                switch (metodoDesconto) {
                    case 1:
                        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Insira abaixo a quantidade de unidades em estoque:"));
                        valorDescontado = eletronico.calcularDesconto(quantidade);
                        eletronico.calcularDesconto(quantidade);
                        JOptionPane.showMessageDialog(null,
                                "Perfeitamente! Você escolheu comprar o celular " + eletronico.getNome() +
                                        "\n-> Descrição: " + eletronico.getDescricao() +
                                        "\n-> Capacidade de Armazenamento: " + eletronico.getCapacidadeArmazenamento() +
                                        "\n-> Fabricante: " + eletronico.getFabricante() +
                                        "\n Temos " + quantidade + " unidades em estoque!" +
                                        "\n\n-> Valor original: R$" + eletronico.getPreco() +
                                        "\n-> Valor com desconto: R$" + valorDescontado);
                        break;

                    case 2:
                        float porcentagem = Float.parseFloat(JOptionPane.showInputDialog("Insira o porcentagem de desconto: "));
                        valorDescontado = eletronico.calcularDesconto(porcentagem);
                        JOptionPane.showMessageDialog(null,
                                "Perfeitamente! Você escolheu comprar o celular " + eletronico.getNome() +
                                        "\n-> Descrição: " + eletronico.getDescricao() +
                                        "\n-> Capacidade de Armazenamento: " + eletronico.getCapacidadeArmazenamento() +
                                        "\n-> Fabricante: " + eletronico.getFabricante() +
                                        "\n Foi considerado um desconto de " + porcentagem + "%" +
                                        "\n\n-> Valor original: R$" + eletronico.getPreco() +
                                        "\n-> Valor com desconto: R$" + valorDescontado);
                        break;

                    case 3:
                        String cupom = JOptionPane.showInputDialog("Insira abaixo o cupom:");
                        valorDescontado = eletronico.calcularDesconto(cupom);
                        JOptionPane.showMessageDialog(null,
                                "Perfeitamente! Você escolheu comprar o celular " + eletronico.getNome() +
                                        "\n-> Descrição: " + eletronico.getDescricao() +
                                        "\n-> Capacidade de Armazenamento: " + eletronico.getCapacidadeArmazenamento() +
                                        "\n-> Fabricante: " + eletronico.getFabricante() +
                                        "\n Foi inserido o seguinte cupom: " + cupom +
                                        "\n\n-> Valor original: R$" + eletronico.getPreco() +
                                        "\n-> Valor com desconto: R$" + valorDescontado);
                        break;
                }
                break;


        }


    }
}
