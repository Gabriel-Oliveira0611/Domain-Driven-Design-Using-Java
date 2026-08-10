package br.com.fiap.loja.model;

public class Produto {

    protected String nome;
    protected String descricao;
    protected double preco;

    // Construtores

    public Produto() {
    }

    public Produto(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    // Métodos

    public double calcularDesconto (int quantidade) {
        if (quantidade > 10) {
            return preco - preco * 0.05;
        } else if (quantidade > 50) {
            return preco - preco * 0.10;
        } else return 0;
    }

    public double calcularDesconto (String cupom) {
        if (cupom.equals("BEMVINDO")) {
            return preco - preco * 0.40;
        } else return 0;
    }

    public double calcularDesconto (float porcentagem) {
        return preco - preco * porcentagem/100;
    }

    // Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
