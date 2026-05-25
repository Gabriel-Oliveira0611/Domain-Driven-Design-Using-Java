package br.com.fiap.veiculos.view;

import br.com.fiap.veiculos.model.Cor;
import br.com.fiap.veiculos.model.Lancha;

import javax.swing.*;

public class TerminalLancha {
    static void main(String[] args) {
        // Inserção dos valores - Lancha
        String modelo = JOptionPane.showInputDialog("insira o modelo:");
        int quantidadeLugares = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de lugares:"));
        int quantidadePortas = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de portas:"));
        int anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog("Insira a ano de fabricacao:"));
        double comprimento = Double.parseDouble(JOptionPane.showInputDialog("Insira o comprimento:"));
        int quantidadeMotores = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de Motores:"));

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

        Lancha lancha = new Lancha(
                modelo,
                quantidadeLugares,
                quantidadePortas,
                anoFabricacao,
                comprimento,
                quantidadeMotores
        );

        // Exibição dos valores
        JOptionPane.showMessageDialog(null,
                "Segue abaixo os dados da lancha:\n" +
                        "\n-> Modelo: " + lancha.getModelo() +
                        "\n-> Quantidade de Lugares: " + lancha.getQuantidadeLugares() +
                        "\n-> Quantidade de Portas: " + lancha.getQuantidadePortas() +
                        "\n-> Ano de Fabricação: " + lancha.getAnoFabricacao() +
                        "\n-> Comprimento: " + lancha.getComprimento() +
                        "\n-> Quantidade de Turbinas: " + lancha.getQuantidadeMotores() +
                        "\n-> Cor: " + cor.getNome() +
                        "\n--> R: " + cor.getR() +
                        "\n--> G: " + cor.getG() +
                        "\n--> B: " + cor.getB());

    }
}
