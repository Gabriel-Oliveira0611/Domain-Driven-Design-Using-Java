package br.com.fiap.loja.model;

public class Eletronicos extends Produto {

    private String capacidadeArmazenamento;
    private String fabricante;

    // Construtor

    public Eletronicos(String nome, String descricao, double preco, String capacidadeArmazenamento, String fabricante) {
        super(nome, descricao, preco);
        this.capacidadeArmazenamento = capacidadeArmazenamento;
        this.fabricante = fabricante;
    }

    // Métodos

    @Override
    public double calcularDesconto(String cupom) {
        if (cupom.equals("NERD")) {
            return preco - preco * 0.20;
        } else return super.calcularDesconto(cupom);
    }

    // Getters and Setters

    public String getCapacidadeArmazenamento() {
        return capacidadeArmazenamento;
    }

    public void setCapacidadeArmazenamento(String capacidadeArmazenamento) {
        this.capacidadeArmazenamento = capacidadeArmazenamento;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}
