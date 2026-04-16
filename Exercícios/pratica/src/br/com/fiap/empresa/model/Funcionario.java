package br.com.fiap.empresa.model;

public class Funcionario {
    private String nome;
    private long matricula;
    private Profissao profissao;
    private double salario;

    public Funcionario() {}

    public Funcionario(long matricula) {
        this.matricula = matricula
    }

    public Funcionario(
            long matricula,
            String nome
    ) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public Funcionario(
            long matricula,
            String nome,
            Profissao profissao
    ) {

    }

    public String exibirDados() {
        return
    }
}
