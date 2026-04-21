import java.util.Scanner;

public class Atividade10 {
    static void main(String[] args) {
        // Criação da função de leitor
        Scanner leitor = new Scanner(System.in);

        // Inserção de dados pelo usuário
        System.out.println("Insira abaixo o dia da semana:");
        String data = leitor.next() + leitor.nextLine();

        if (data.equalsIgnoreCase("segunda") || data.equalsIgnoreCase("terça") || data.equalsIgnoreCase("quarta") || data.equalsIgnoreCase("quinta") || data.equalsIgnoreCase("sexta")) {
            System.out.println(data + " é dia útil");
        } else if (data.equalsIgnoreCase("sábado") || data.equalsIgnoreCase("domingo")) {
            System.out.println(data + " não é dia útil");
        } else {
            System.out.println("Data inválida.");
        }
    }
}
