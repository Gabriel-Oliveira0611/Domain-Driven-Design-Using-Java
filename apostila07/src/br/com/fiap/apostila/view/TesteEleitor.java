package br.com.fiap.apostila.view;

import javax.swing.*;

public class TesteEleitor {
    public static void main(String[] args) {
        // Criação das variáveis
        int total = 0;

        for (int contagem = 0 ; contagem < 3 ; contagem++) {
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade:"));

            if (idade < 16) {
                JOptionPane.showMessageDialog(null, "Não eleitor.");
            } else if (idade >= 18 && idade <= 65) {

                JOptionPane.showMessageDialog(null, "Eleitor obrigatório!");
                total++;
            } else {
                JOptionPane.showMessageDialog(null, "Eleitor facultativo");
            }
        }
        JOptionPane.showMessageDialog(null, "Total de eleitores obrigatórios: " + total);
    }
}
