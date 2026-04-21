import java.util.Scanner;

public class Atividade11 {
    static void main(String[] args) {
        // Criação da função leitor
        Scanner leitor = new Scanner(System.in);

        // Definição dos valores máximo e mínimo
        int valorMaximo = 5000;
        int valorMinimo = 1000;

        // Inserção do valor por parte do usuário
        System.out.println("Isnira abaixo o valor desejado:");
        int valorDesejado = leitor.nextInt();

        if (valorDesejado <= valorMaximo && valorDesejado >= valorMinimo) {
            System.out.println("O valor de R$" + valorDesejado + " está dentro do intervalo permitido para empréstimo.");
        } else {
            System.out.println("O valor de R$" + valorDesejado + " não está dentro do intervalo permitido para empréstimo.");
        }
    }
}
