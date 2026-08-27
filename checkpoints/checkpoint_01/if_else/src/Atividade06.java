public class Atividade06 {
    static void main(String[] args) {
        double mediaFinal = 7;

        if (mediaFinal < 5.0) {
            System.out.println("O aluno está reprovado.");
        } else if (mediaFinal >= 5.0 && mediaFinal <= 6.9) {
            System.out.println("O aluno está de recuperação");
        } else {
            System.out.println("O aluno está aprovado.");
        }
    }
}
