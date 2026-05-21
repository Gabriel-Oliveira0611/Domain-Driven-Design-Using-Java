package br.com.fiap.loja.model;

public class Produto {

    private String nome;
    private double preco;
    private String codigoBarra;

    public Produto(String nome, double preco, String codigoBarra) {
        this.nome = nome;
        this.preco = preco;
        this.codigoBarra = codigoBarra;
    }

    public double calcularDesconto(int porcentagem) {
        return preco - preco * porcentagem / 100;
    }

    public double calcularDesconto(float valor) {
        return preco - valor;
    }

    public double calcularDesconto(String cupom) {
        switch (cupom){
            case "FIAP20":
                return preco - preco * 0.2;


            case "FIAP30":
                return preco - preco * 0.3;

            default:
                return 0;
        }
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

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
}
