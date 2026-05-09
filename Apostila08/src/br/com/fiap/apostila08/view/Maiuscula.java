package br.com.fiap.apostila08.view;

import javax.swing.*;

public class Maiuscula {
    static void main(String[] args) {
        String palavra = JOptionPane.showInputDialog("Insira uma palavra abaixo:");
        System.out.println(palavra.toUpperCase());
    }
}
