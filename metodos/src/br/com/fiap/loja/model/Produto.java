package br.com.fiap.loja.model;

public class Produto {

    //Criação dos atributos da classe
    public String nomeProduto;
    public int quantidadeProduto;
    public double precoProduto;

    //Criação do método
    public double calcularPrecoTotalProduto(){
        return precoProduto * quantidadeProduto;
    }
}
