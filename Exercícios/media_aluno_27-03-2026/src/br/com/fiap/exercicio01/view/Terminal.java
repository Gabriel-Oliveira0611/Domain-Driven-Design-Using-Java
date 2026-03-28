package br.com.fiap.exercicio01.view;

import java.util.Scanner;
import br.com.fiap.exercicio01.model.Aluno;

public class Terminal {

    static void main() {

        // Criação da função leitor
        Scanner leitor = new Scanner(System.in);

        // Instanciar o objeto
        Aluno aluno = new Aluno();

        // Inserção dos dados pelo usuário
        System.out.println("Qual é o seu nome? ");
        aluno.nome = leitor.next() + leitor.nextLine();

        System.out.println("Qual foi a nota do primeiro checkpoint?");
        aluno.checkpoint01 = leitor.nextDouble();

        System.out.println("Qual foi a nota do segundo checkpoint?");
        aluno.checkpoint02 = leitor.nextDouble();

        System.out.println("Qual foi a nota do primeiro challenge?");
        aluno.challenge01 = leitor.nextDouble();

        System.out.println("Qual foi a nota do segundo challenge?");
        aluno.challenge02 = leitor.nextDouble();

        System.out.println("Qual foi a nota do Global Solution?");
        aluno.globalSolution = leitor.nextDouble();

        // Criação da variavel que contém o método
        double calculoMediaCheckpoints = aluno.mediaCheckpoints();
        double calculoMediaChallenges = aluno.mediaChallenge();
        double calculoMediaGlobalSolution = aluno.mediaGlobalSolution();
        double calculoNotaFinal = aluno.notaFinal();

        // Exibição dos dados
        System.out.println("Pois bem, " + aluno.nome + " segue resumo abaixo:" );
        System.out.println("Nota Checkpoint 01: " + aluno.checkpoint01);

        System.out.println("Nota checkpoint 02: " + aluno.checkpoint02);

        System.out.println("Nota do primeiro challenge: " + aluno.challenge01);

        System.out.println("Nota do segundo challenge: " + aluno.challenge02);

        System.out.println("Nota do global solution: " + aluno.globalSolution);

        System.out.println("Médias:");
        System.out.println("Média checkpoints: " + aluno.mediaCheckpoints());
        System.out.println("Média challenge: " + aluno.mediaChallenge());
        System.out.println("Média global solution: " + aluno.mediaGlobalSolution());

        System.out.println("Nota final:");
        System.out.println(aluno.notaFinal());

    }

}
