package br.com.fiap.loja.model;

public class Livro extends Produto {

    protected String autor;
    protected String editora;

    // Construtores

    public Livro(String nome, String descricao, double preco, String autor, String editora) {
        super(nome, descricao, preco);
        this.autor = autor;
        this.editora = editora;
    }

    // Getters and seters

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}
