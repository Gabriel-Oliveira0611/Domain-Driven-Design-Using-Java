package br.com.fiap.model;

public class Pokemon {
    private String tipo;
    private String nome;
    private int nivel;

    public Pokemon(){}

    public Pokemon(
            String tipo,
            String nome,
            int nivel
    ) {
        this.tipo = tipo;
        this.nome = nome;
        this.nivel = nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
