package br.com.fiap.apostila08.view;

import javax.swing.*;

public class Alteracao {
    static void main(String[] args) {
        String nome = "Gabriel Pereira";
        String sobrenome = nome.substring(8,15);
        System.out.println(sobrenome);

        String email = JOptionPane.showInputDialog("Digite seu email");

        //Exibir o email sem domínio (gabriel@fiap.com.br)
        int arroba = email.indexOf("@");
        int finalEmail = email.length();

        String emailSemDominio = email.substring(0,arroba);
        System.out.println(emailSemDominio);


       //Exibir o domínio
        String dominio = email.substring(arroba+1,finalEmail);
        System.out.println(dominio);
    }
}
