package br.com.fiap.loja.model;

public class Produto {

    // Declaração das variáveis
    public String nome;
    public int quantidade;
    public double precoUnitario;

    // Criação do método
    public double calcularPrecoTotal() {
        return quantidade * precoUnitario;
    }

}
