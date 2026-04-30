package br.com.fiap.apostila08.view;

import javax.swing.*;

public class TesteString2 {
    public static void main(String[] args) {
        String email = JOptionPane.showInputDialog("Digite o email: ");
        //Validar se o email é válido


        if (email.indexOf("@") == -1 && email.lastIndexOf(".") == -1) {
            System.out.println("Email inválido");
        } else {
            System.out.println("Email válido");
        }
    }
}
