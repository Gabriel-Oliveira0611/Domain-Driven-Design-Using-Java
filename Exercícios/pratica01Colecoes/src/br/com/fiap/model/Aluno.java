package br.com.fiap.model;

public class Aluno {
    private String name;
    private int age;
    private int rm;
    private double nota1;
    private double nota2;

    public Aluno () {}

    public Aluno(String name, int age, int rm, double nota1, double nota2) {
        this.name = name;
        this.age = age;
        this.rm = rm;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRm() {
        return rm;
    }

    public void setRm(int rm) {
        this.rm = rm;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }
}
