package br.com.fiap.veiculos.view;

import br.com.fiap.veiculos.model.Carro;
import br.com.fiap.veiculos.model.Cor;

import javax.swing.*;

public class TerminalCarro {
    static void main(String[] args) {
        // Inserção dos valores - Carro
        String modelo = JOptionPane.showInputDialog("insira o modelo:");
        int quantidadeLugares = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de lugares:"));
        int quantidadePortas = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de portas:"));
        int anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog("Insira a ano de fabricacao:"));
        double comprimento = Double.parseDouble(JOptionPane.showInputDialog("Insira o comprimento:"));
        String placa = JOptionPane.showInputDialog("Insira o placa:");

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

        Carro carro = new Carro(
                modelo,
                quantidadeLugares,
                quantidadePortas,
                anoFabricacao,
                comprimento,
                placa
        );

        // Exibição dos valores
        JOptionPane.showMessageDialog(null,
                "Segue abaixo os dados do carro:\n" +
                        "\n-> Modelo: " + carro.getModelo() +
                        "\n-> Quantidade de Lugares: " + carro.getQuantidadeLugares() +
                        "\n-> Quantidade de Portas: " + carro.getQuantidadePortas() +
                        "\n-> Ano de Fabricação: " + carro.getAnoFabricacao() +
                        "\n-> Comprimento: " + carro.getComprimento() +
                        "\n-> Placa: " + carro.getPlaca() +
                        "\n-> Cor: " + cor.getNome() +
                        "\n--> R: " + cor.getR() +
                        "\n--> G: " + cor.getG() +
                        "\n--> B: " + cor.getB());

    }
}