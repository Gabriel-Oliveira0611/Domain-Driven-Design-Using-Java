package br.com.fiap.apostila12.model;

public class Produto {

    private String nome;
    private double preco;

    public Produto() {}

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public double darDesconto(double desconto) {
//        Validar se o desconto é maior que o preco
        if (desconto > preco) {
            throw new RuntimeException("O desconto é maior que o preço.");
        }

//        Validar se o desconto é positivo
        if (desconto < 0) {
            throw new RuntimeException("O desconto é negativo.");
        }

        return preco - desconto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
