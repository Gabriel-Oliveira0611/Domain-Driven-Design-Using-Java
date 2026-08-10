package br.com.fiap.loja.model;

public class ProdutoFisico extends Produto {

    protected float volume;
    protected float peso;

    public ProdutoFisico(String nome, double preco, String codigoBarra, float volume, float peso) {
        super(nome, preco, codigoBarra);
        this.volume = volume;
        this.peso = peso;
    }

    @Override
    public double calcularDesconto(int porcentagem) {
        return preco - preco * (porcentagem+5)/100; //Adiciona 5% de desconto a mais
    }

    @Override
    public double calcularDesconto(String cupom) {
        switch (cupom) {
            case "PF50":
                return preco - preco * 0.5;
        }
        return super.calcularDesconto(cupom);
    }

    @Override
    public String toString() {
        return super.toString() + "\n-> Volume: " + volume +
                "\n-> Peso: " + peso;
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
