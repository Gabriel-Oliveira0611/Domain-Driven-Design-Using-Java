import java.util.Scanner;

public class Atividade13 {
    static void main(String[] args) {
        // Criação da função de leitor
        Scanner leitor = new Scanner(System.in);

        // Criação das variáveis
        int idadeMinima = 18;
        int idadeMaxima = 65;
        int pesoMinimo = 50;
        int idadeDoUsuario;
        int pesoDoUsuario;

        System.out.println("Insira abaixo a sua idade");
        idadeDoUsuario = leitor.nextInt();

        System.out.println("Insira o peso do usuario:");
        pesoDoUsuario = leitor.nextInt();

        if (idadeDoUsuario >= idadeMinima && idadeDoUsuario <= idadeMaxima && pesoDoUsuario >= pesoMinimo) {
            System.out.println("O usuário pode doar sangue");
        } else if (idadeDoUsuario >= idadeMinima && idadeDoUsuario <= idadeMaxima && pesoDoUsuario < pesoMinimo) {
            System.out.println("O doador não é compativel." +
                    "\nMotivo: " +
                    "\n -> O usuário tem " + pesoDoUsuario + "kg. O peso mínimo é de 50kg.");
        } else if (idadeDoUsuario < idadeMinima || idadeDoUsuario > idadeMaxima && pesoDoUsuario < pesoMinimo) {
            System.out.println("O doador não é compatível." +
                    "\nMotivo: " +
                    "\n -> O usuário tem " + idadeDoUsuario + " anos, sendo que o mesmo deve ter entre " + idadeMinima + " e " + idadeMaxima + " anos." +
                    "\n -> O usuário tem " + pesoDoUsuario + "kg. O peso mínimo é de 50kg.");
        } else {
            System.out.println("O doador não é compatível." +
                    "\nMotivo: " +
                    "\n -> O usuário tem " + idadeDoUsuario + " sendo que o mesmo deve ter entre " + idadeMinima + " e " + idadeMaxima + " anos.");
        }

    }
}
