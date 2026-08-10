package br.com.fiap.veiculos.model;

public class Veiculo {
    private String modelo;
    private int quantidadeLugares;
    private int quantidadePortas;
    private int anoFabricacao;
    private double comprimento;

    public Veiculo() {
    }

    public Veiculo(
            String modelo,
            int quantidadeLugares,
            int quantidadePortas,
            int anoFabricacao,
            double comprimento
    ) {
        this.modelo = modelo;
        this.quantidadeLugares = quantidadeLugares;
        this.quantidadePortas = quantidadePortas;
        this.anoFabricacao = anoFabricacao;
        this.comprimento = comprimento;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getQuantidadeLugares() {
        return quantidadeLugares;
    }

    public void setQuantidadeLugares(int quantidadeLugares) {
        this.quantidadeLugares = quantidadeLugares;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }
}
