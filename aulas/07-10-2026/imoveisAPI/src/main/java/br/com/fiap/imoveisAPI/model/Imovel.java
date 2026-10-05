package br.com.fiap.imoveisAPI.model;

public class Imovel {

    private int id;
    private String descricao;
    private double dimensao;
    private double valor;
    private TipoImovel tipo;

    @Override
    public String toString() {
        return "-> Imóvel: " + getDescricao() + " - Dimensão: " + getDimensao() + " - Valor: " + getValor() + " - Tipo: " + getTipo();
    }

    public Imovel(String descricao, double dimensao, double valor, TipoImovel tipo) {
        this.descricao = descricao;
        this.dimensao = dimensao;
        this.valor = valor;
        this.tipo = tipo;
    }

    public Imovel(int id, String descricao, double dimensao, double valor, TipoImovel tipo) {
        this.id = id;
        this.descricao = descricao;
        this.dimensao = dimensao;
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoImovel getTipo() {
        return tipo;
    }

    public void setTipo(TipoImovel tipo) {
        this.tipo = tipo;
    }
}
