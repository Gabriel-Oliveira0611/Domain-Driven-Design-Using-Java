package br.com.fiap.loja.model;

public class ProdutoDigital extends Produto{

    private float tamanho;

    public ProdutoDigital(String nome, double preco, String codigoBarra, float tamanho) {
        super(nome, preco, codigoBarra);
        this.tamanho = tamanho;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }
}
