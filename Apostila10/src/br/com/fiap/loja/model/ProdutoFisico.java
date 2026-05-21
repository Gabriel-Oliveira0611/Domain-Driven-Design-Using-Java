package br.com.fiap.loja.model;

public class ProdutoFisico extends Produto {

    private float volume;
    private float peso;

    public ProdutoFisico(String nome, double preco, String codigoBarra, float volume, float peso) {
        super(nome, preco, codigoBarra);
        this.volume = volume;
        this.peso = peso;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
