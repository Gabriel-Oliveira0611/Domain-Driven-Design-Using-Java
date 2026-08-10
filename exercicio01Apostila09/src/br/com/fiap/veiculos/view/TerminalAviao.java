package br.com.fiap.veiculos.view;

import br.com.fiap.veiculos.model.Aviao;
import br.com.fiap.veiculos.model.Cor;

import javax.swing.*;

public class TerminalAviao {
    static void main(String[] args) {
        // Inserção dos valores - Aviao
        String modelo = JOptionPane.showInputDialog("insira o modelo:");
        int quantidadeLugares = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de lugares:"));
        int quantidadePortas = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de portas:"));
        int anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog("Insira a ano de fabricacao:"));
        double comprimento = Double.parseDouble(JOptionPane.showInputDialog("Insira o comprimento:"));
        int quantidadeTurbinas = Integer.parseInt(JOptionPane.showInputDialog("insira a quantidade de Turbinas:"));

        // Inserção dos valores - Cor
        String nome = JOptionPane.showInputDialog("Insira o nome da cor:");
        int r = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor em vermelho:"));
        int g = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor em verde:"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor em azul:"));

        // Criação dos objetos
        Cor cor = new Cor(
                nome,
                r,
                g,
                b
        );

        Aviao aviao = new Aviao(
                modelo,
                quantidadeLugares,
                quantidadePortas,
                anoFabricacao,
                comprimento,
                quantidadeTurbinas
        );

        // Exibição dos valores
        JOptionPane.showMessageDialog(null,
                "Segue abaixo os dados do avião:\n" +
                        "\n-> Modelo: " + aviao.getModelo() +
                        "\n-> Quantidade de Lugares: " + aviao.getQuantidadeLugares() +
                        "\n-> Quantidade de Portas: " + aviao.getQuantidadePortas() +
                        "\n-> Ano de Fabricação: " + aviao.getAnoFabricacao() +
                        "\n-> Comprimento: " + aviao.getComprimento() +
                        "\n-> Quantidade de Turbinas: " + aviao.getQuantidadeTurbinas() +
                        "\n-> Cor: " + cor.getNome() +
                        "\n--> R: " + cor.getR() +
                        "\n--> G: " + cor.getG() +
                        "\n--> B: " + cor.getB());

    }
}
