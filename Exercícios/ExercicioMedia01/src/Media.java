import java.util.Scanner;

public class Media {

    static void main() {
        // Criação da entrad de dados
        Scanner leitor = new Scanner(System.in);

        // Declaração de Variáveis
        double notaCheckpoint01;
        double notaCheckpoint02;
        double notaChallenge01;
        double notaChallenge02;
        double notaGlobalSolution;
        double mediaCheckpoints;
        double mediaChallenges;
        double percentualCheckpoints = 0.2;
        double percentualChallenges = 0.2;
        double percentualGlobalSolution = 0.6;
        double notaFinalCheckpoints;
        double notaFinalChallenge;
        double notaFinalGlobalSolution;
        double notaFinal;
        String nome;

        // Inserção de dados sobre o usuário
        System.out.println(
                "Seja bem-vindo! Qual é o seu nome?"
        );
        nome = leitor.next();

        // Inserção de notas dos Checkpoints
        System.out.println(
                "Qual foi a nota do seu primeiro checkpoint?"
        );
        notaCheckpoint01 = leitor.nextDouble();

        System.out.println(
                "Qual foi a nota do seu segundo checkpoint?"
        );
        notaCheckpoint02 = leitor.nextDouble();

        // Inserção de notas dos challenges
        System.out.println(
                "Qual foi a nota do primeiro challenge?"
        );
        notaChallenge01 = leitor.nextDouble();

        System.out.println(
                "Qual foi a nota do segundo challenge?"
        );
        notaChallenge02 = leitor.nextDouble();

        // Inserção da nota do Global Solution

        System.out.println(
                "Qual foi a nota do global solution?"
        );
        notaGlobalSolution = leitor.nextDouble();

        // Cálculo da média do checkpoint

        mediaCheckpoints = (notaCheckpoint01 + notaCheckpoint02) / 2;

        // Cálculo da média do challenge

        mediaChallenges  = (notaChallenge01 + notaChallenge02) / 2;

        // Cálculo de percentuais

        notaFinalCheckpoints = mediaCheckpoints * percentualCheckpoints;

        notaFinalChallenge = mediaChallenges * percentualChallenges;

        notaFinalGlobalSolution = notaGlobalSolution * percentualGlobalSolution;

        // Cálculo da nota final

        notaFinal = notaFinalCheckpoints + notaFinalChallenge + notaFinalGlobalSolution;

        // Exibição do resultado para o usuário

        System.out.println(
                "Pois bem, " + nome + ", Eis seu resultado:"
        );
        System.out.println(
                "Nota do primweiro checkpoint: " + notaCheckpoint01
        );
        System.out.println(
                "Nota do segundo checkpoint: " + notaCheckpoint02
        );
        System.out.println(
                "Nota do primeiro challenge: " + notaChallenge01
        );
        System.out.println(
                "Nota do segundo challenge: " + notaChallenge02
        );
        System.out.println(
                "Nota do Global Solution: " + notaGlobalSolution
        );
        System.out.println(
                "Portanto, sua nota final é de: " + notaFinal
        );


    }

}