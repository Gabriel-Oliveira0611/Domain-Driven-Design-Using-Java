package br.com.fiap.exercicio01.model;

public class Aluno {

    public String nome;
    public double checkpoint01;
    public double checkpoint02;
    public double challenge01;
    public double challenge02;
    public double globalSolution;

    public double mediaCheckpoints(){
        return (checkpoint01 + checkpoint02) / 2 * 0.2;
    }

    public double mediaChallenge(){
        return (challenge01 + challenge02) / 2 * 0.2;
    }

    public double mediaGlobalSolution(){
        return globalSolution * 0.6;
    }

    public double notaFinal(){
        return mediaCheckpoints() + mediaChallenge() + mediaGlobalSolution();
    }

}
