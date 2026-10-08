package br.com.fiap.exercicioAPI.model;

public class Imovel {

    private int id;
    private String descricao;
    private double dimensao;
    private double valor;
    private TipoImovel tipoImovel;

    public Imovel(){}

    public Imovel(String descricao, double dimensao, double valor, TipoImovel tipoImovel) {
        this.descricao = descricao;
        this.dimensao = dimensao;
        this.valor = valor;
        this.tipoImovel = tipoImovel;
    }

    public Imovel(int id, String descricao, double dimensao, double valor, TipoImovel tipoImovel) {
        this.id = id;
        this.descricao = descricao;
        this.dimensao = dimensao;
        this.valor = valor;
        this.tipoImovel = tipoImovel;
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

    public TipoImovel getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(TipoImovel tipoImovel) {
        this.tipoImovel = tipoImovel;
    }
}
