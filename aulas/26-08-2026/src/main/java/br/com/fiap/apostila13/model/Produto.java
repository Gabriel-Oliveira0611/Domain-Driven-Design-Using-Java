package br.com.fiap.apostila13.model;

public class Produto {

    private int codigo;
    private String nome;
    private String descricao;
    private double valor;
    private boolean temEstoque;

    public Produto() {
    }

    public Produto(
            int codigo,
            String nome,
            String descricao,
            double valor,
            boolean temEstoque
    ) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.temEstoque = temEstoque;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isTemEstoque() {
        return temEstoque;
    }

    public void setTemEstoque(boolean temEstoque) {
        this.temEstoque = temEstoque;
    }
}
