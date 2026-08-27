package br.com.fiap.apostila.view;

import javax.swing.*;

public class ExemploConversao {

    public static void main(String[] args) {
        // Calcular a area do retangulo

        String baseString = JOptionPane.showInputDialog("Digite a medida da base");
        double baseDouble = Double.parseDouble(baseString);

        String alturaString = JOptionPane.showInputDialog("Digite a altura");
        double alturaDouble = Double.parseDouble(alturaString);

        double area = alturaDouble * baseDouble;

        System.out.println(
                "\nEis abaixo o calculo da área:" +
                        "\n -> Base: " + baseDouble +
                        "\n -> Altura: " + alturaDouble +
                        "\n -> " + baseDouble + " x " + alturaDouble +
                        "\n -> Resultado: " + area
        );

        JOptionPane.showMessageDialog(null, "A área é a seguinte: " +
                "\n teste" +
                "\n -> área: " + area);
    }

}
