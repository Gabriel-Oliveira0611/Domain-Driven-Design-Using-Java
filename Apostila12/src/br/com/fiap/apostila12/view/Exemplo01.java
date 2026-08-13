package br.com.fiap.apostila12.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exemplo01 {
    static void main(String[] args) {
//        Ler uma idade com Scanner
        Scanner leitor = new Scanner(System.in);

        try {
            System.out.println("Insira abaixo a idade:");
            int idade = leitor.nextInt();
            System.out.println("Idade: " + idade);
        } catch (InputMismatchException e) {
            System.out.println("Número inválido.");
        } catch (ArithmeticException e) {
            System.out.println("Operação inválida");
        } finally {
            System.out.println("Sempre roda, finaliza o recurso.");
            leitor.close();
        }
    }
}
