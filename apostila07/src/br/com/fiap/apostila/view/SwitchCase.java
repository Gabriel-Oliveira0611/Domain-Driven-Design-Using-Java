package br.com.fiap.apostila.view;

import javax.swing.*;

public class SwitchCase {
    public static void main(String[] args) {
        // Calculadora (soma, subtração, multiplicação e divisão)
        // ler dois numeros

        double primeiroNumero = Double.parseDouble(JOptionPane.showInputDialog("Insira o primeiro numero"));
        double segundoNumero = Double.parseDouble(JOptionPane.showInputDialog("Insira o segundo numero"));
        double resultado = 0;
        String operacao = JOptionPane.showInputDialog("Insira a operação (+,-,*,/)");

        switch (operacao) {
            case "+":
                resultado = primeiroNumero + segundoNumero;
                JOptionPane.showMessageDialog(
                        null,
                        "resultado: "
                                + resultado);
                break;

            case "-":
                resultado = primeiroNumero - segundoNumero;
                JOptionPane.showMessageDialog(
                        null,
                        "resultado: " +
                                resultado);
                break;

            case "*":
                resultado = primeiroNumero * segundoNumero;
                JOptionPane.showMessageDialog(
                        null,
                        "resultado: " +
                                resultado);
                break;

            case "/":
                if (primeiroNumero == 0 || segundoNumero == 0 ) {
                    JOptionPane.showMessageDialog(null, "Divisão por 0 não é permitida!");
                }
                else {
                resultado = primeiroNumero / segundoNumero;
                JOptionPane.showMessageDialog(
                        null,
                        "resultado: " +
                                resultado);
                break; }

            default:
                JOptionPane.showMessageDialog(null, "Operação inválida!");
                break;

        }

    }
}
