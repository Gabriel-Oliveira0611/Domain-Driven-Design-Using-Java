import java.util.Scanner;

public class Atividade14 {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite abaixo sua idade:");
        int idade = input.nextInt();
        String mensagem;

        if (idade >= 18) {
            mensagem = "Você é maior de idade.";
        } else {
            mensagem = "Você é menor de idade.";
        }

        System.out.println(mensagem);
    }
}
