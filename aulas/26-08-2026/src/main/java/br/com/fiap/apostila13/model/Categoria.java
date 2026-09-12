package br.com.fiap.apostila13.model;

public class Categoria {
    private int codigo;
    private String nome;

    public Categoria() {}

    public Categoria(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Código: " + getCodigo() + " -> Nome da categoria: " + getNome();
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
}
