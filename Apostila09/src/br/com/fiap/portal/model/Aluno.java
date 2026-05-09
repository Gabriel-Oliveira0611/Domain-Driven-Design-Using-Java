package br.com.fiap.portal.model;

public class Aluno extends Pessoa {
    private int rmALuno;
    private String turmaAluno;

    public int getRmALuno() {
        return rmALuno;
    }

    public void setRmALuno(int rmALuno) {
        this.rmALuno = rmALuno;
    }

    public String getTurmaAluno() {
        return turmaAluno;
    }

    public void setTurmaAluno(String turmaAluno) {
        this.turmaAluno = turmaAluno;
    }
}
