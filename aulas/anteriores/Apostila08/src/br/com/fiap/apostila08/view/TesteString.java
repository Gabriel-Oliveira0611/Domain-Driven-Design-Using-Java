package br.com.fiap.apostila08.view;

import javax.swing.*;

public class TesteString {
    public static void main(String[] args) {

//        String nome = JOptionPane.showInputDialog("Digite seu nome: ");
//        System.out.println(nome + " é aluno da \"FIAP\"." +
//                "\nVamos no evento!");

        //if (nome.equalsIgnoreCase("Jose")) {
           // System.out.println("O nome é " + nome);
        //} else {
           // System.out.println("O nome não é José.");
        //}

        // Exibir quantidade
        String segundoNome = "Gabriel Pereira";
//        System.out.println("O nome é: " + segundoNome.length());
        //int contador = 0;
       //while (contador < segundoNome.length()) {
//            System.out.println(segundoNome.charAt(contador));
//            contador++;
//        }

        for (int i = 0; i < segundoNome.length(); i++) {
            System.out.println(segundoNome.charAt(i));
        }
    }
}