package model;

public class Aluno {

    private int id;
    private String rm;
    private String nome;
    private boolean ativo;
    private double nota1;
    private double nota2;

    public Aluno() {}

    public Aluno(int id, String rm, String nome, boolean ativo, double nota1, double nota2) {
        this.id = id;
        this.rm = rm;
        this.nome = nome;
        this.ativo = ativo;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }
}
