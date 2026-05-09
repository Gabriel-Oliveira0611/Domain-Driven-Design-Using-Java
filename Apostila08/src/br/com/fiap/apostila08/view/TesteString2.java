package br.com.fiap.apostila08.view;

import javax.swing.*;

public class TesteString2 {
    static void main(String[] args) {
        String email = JOptionPane.showInputDialog("Digite seu e-mail");

        //Validar email
        if (email.contains("@") || email.contains(".")) {
            System.out.println("Não é um email válido");
        } else {
            System.out.println("É um e-mail válido.");
        }
    }
}
