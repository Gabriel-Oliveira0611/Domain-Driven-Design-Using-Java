package br.com.fiap.api27092026.model;

public class Produto {

    private int codigo;
    private String nome;
    private int quantidade;
    private double valor;
    private String fornecedor;

    public Produto() {}

    public Produto(String nome, int quantidade, double valor, String fornecedor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.fornecedor = fornecedor;
    }

    public Produto(int codigo, String nome, int quantidade, double valor, String fornecedor) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.fornecedor = fornecedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
}
