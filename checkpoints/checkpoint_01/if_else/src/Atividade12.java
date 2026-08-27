import java.util.Scanner;

public class Atividade12 {
    static void main(String[] args) {
        // Criação da função de leitor
        Scanner leitor = new Scanner(System.in);

        // Inserção de dados por parte do usuário
        System.out.println("Insira abaixo a medida do primeiro lado:");
        int lado1 = leitor.nextInt();

        System.out.println("Insira abaixo a medida do segundo lado:");
        int lado2 = leitor.nextInt();

        System.out.println("Insira abaixo a medida do terceiro lado:");
        int lado3 = leitor.nextInt();

        // Cálculo
        if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1) {
            System.out.println("Os lados podem formar um triângulo.");
        } else {
            System.out.println("Os lados não podem formar um triângulo.");
        }
    }
}
