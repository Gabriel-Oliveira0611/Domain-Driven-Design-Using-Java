package br.com.fiap.apostila.view;

import javax.swing.*;

public class TesteTamanho {
    public static void main(String[] args) {

        // Criação das variáveis - Primeira pessoa
        String nomePrimeiraPessoa = JOptionPane.showInputDialog("Digite seu nome:");
        double alturaPrimeiraPessoa = Double.parseDouble(JOptionPane.showInputDialog("Digite seu altura:"));
        double pesoPrimeiraPessoa = Double.parseDouble(JOptionPane.showInputDialog("Digite seu peso:"));

        // Criação das variáveis - Segunda pessoa
        String nomeSegundaPessoa = JOptionPane.showInputDialog("Digite seu nome:");
        double alturaSegundaPessoa = Double.parseDouble(JOptionPane.showInputDialog("Digite seu altura:"));
        double pesoSegundaPessoa = Double.parseDouble(JOptionPane.showInputDialog("Digite seu peso:"));

        // If - Else
        if (alturaPrimeiraPessoa > alturaSegundaPessoa) {
            JOptionPane.showMessageDialog(null,
                    "-> Primeiro paiente: " + nomePrimeiraPessoa + "\n" +
                            "-> Altura: " + alturaPrimeiraPessoa + "\n\n" +
                            "-> Segundo paciente: " + nomeSegundaPessoa + "\n" +
                            "-> Altura: " + alturaSegundaPessoa + "\n\n" +
                            "-> Resultado: O primeiro paciente é mais alto que o segundo.");
        } else if (alturaPrimeiraPessoa < alturaSegundaPessoa) {
            JOptionPane.showMessageDialog(null,
                    "-> Primeiro paiente: " + nomePrimeiraPessoa + "\n" +
                            "-> Altura: " + alturaPrimeiraPessoa + "\n\n" +
                            "-> Segundo paciente: " + nomeSegundaPessoa + "\n" +
                            "Altura: " + alturaSegundaPessoa + "\n\n" +
                            "-> Resultado: O segundo paciente é mais alto que o segundo.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "-> Primeiro paiente: " + nomePrimeiraPessoa + "\n" +
                            "-> Altura: " + alturaPrimeiraPessoa + "\n\n" +
                            "-> Segundo paciente: " + nomeSegundaPessoa + "\n" +
                            "Altura: " + alturaSegundaPessoa + "\n\n" +
                            "-> Resultado: Ambos têm a mesma altura.");
        }

        if (pesoPrimeiraPessoa > pesoSegundaPessoa) {
            JOptionPane.showMessageDialog(null,
                    "-> Primeiro paiente: " + nomePrimeiraPessoa + "\n" +
                            "-> Peso: " + pesoPrimeiraPessoa + "\n\n" +
                            "-> Segundo paciente: " + nomeSegundaPessoa + "\n" +
                            "-> Peso: " + pesoSegundaPessoa + "\n\n" +
                            "-> Resultado: O primeiro paciente é mais pesado que o segundo.");
        } else if (pesoPrimeiraPessoa < pesoSegundaPessoa) {
            JOptionPane.showMessageDialog(null,
                    "-> Primeiro paiente: " + nomePrimeiraPessoa + "\n" +
                            "-> Peso: " + pesoPrimeiraPessoa + "\n\n" +
                            "-> Segundo paciente: " + nomeSegundaPessoa + "\n" +
                            "-> Peso: " + pesoSegundaPessoa + "\n\n" +
                            "-> Resultado: O segundo paciente é mais pesado que o segundo.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "-> Primeiro paiente: " + nomePrimeiraPessoa + "\n" +
                            "-> Peso: " + pesoPrimeiraPessoa + "\n\n" +
                            "-> Segundo paciente: " + nomeSegundaPessoa + "\n" +
                            "-> Peso: " + pesoSegundaPessoa + "\n\n" +
                            "-> Resultado: Ambos têm o mesmo peso.");
        }
    }
}
