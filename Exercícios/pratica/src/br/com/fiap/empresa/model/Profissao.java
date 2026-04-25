package br.com.fiap.empresa.model;

public class Profissao {
    private String nomeProfissao;

    // Construtores

    public Profissao() {}

    public Profissao(String nomeProfissao) {
        this.nomeProfissao = nomeProfissao;
    }

    // Getters and Setters

    public String getNome() {
        return nomeProfissao;
    }

    public void setNome(String nome) {
        this.nomeProfissao = nomeProfissao;
    }
}
