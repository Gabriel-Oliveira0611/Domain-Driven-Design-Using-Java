package br.com.fiap.apostila.view;

import javax.swing.*;
import java.util.Scanner;

public class if_else {
    public static void main(String[] args) {

        // Ler a média final do aluno
        Scanner leitor = new Scanner(System.in);
        System.out.println("Insira a primeira nota");
        double nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a primeira nota:"));
        System.out.println("Insira a segunda nota");
        double nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a segunda nota:"));
        System.out.println("Insira a terceira nota");
        double nota3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a terceira nota:"));

        double mediaNota = 0;
        // Informar se está aprovado, retido ou de exame
        if (nota1 < nota2 && nota1 < nota3) {
            mediaNota = (nota2 + nota3) / 2;
            System.out.println(mediaNota);
        } else if (nota2 < nota1 && nota2 < nota3) {
            mediaNota = (nota1 + nota3) / 2;
            System.out.println(mediaNota);
        } else {
            mediaNota = (nota1 + nota2) / 2;
            System.out.println(mediaNota);
        }

        if (mediaNota >= 6.0) {
            JOptionPane.showMessageDialog(null, "Você foi aprovado");
        } else if (mediaNota >= 4) {
            JOptionPane.showMessageDialog(null, "você está de exame");
        } else {
            JOptionPane.showMessageDialog(null, "Você foi reprovado");
        }


    }
}
