package br.com.fiap.apostila08.view;

import javax.swing.*;

public class Vogal {
    static void main(String[] args) {
        String palavra = JOptionPane.showInputDialog("Insira uma palavra:");

        String vogais = "aeiouAEIOU";

        for (int i = 0; i < vogais.length(); i++) {
            palavra = palavra.replace(vogais.charAt(i), '*');
        }

        System.out.println(palavra);
    }
}
