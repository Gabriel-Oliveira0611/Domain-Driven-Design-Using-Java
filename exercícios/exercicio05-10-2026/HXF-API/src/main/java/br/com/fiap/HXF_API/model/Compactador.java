package br.com.fiap.HXF_API.model;

public class Compactador {

    private int id;
    private String nome;
    private double peso;
    private double valor;
    private int base;

    public Compactador() {
    }

    public Compactador(String nome, double peso, double valor, int base) {
        this.nome = nome;
        this.peso = peso;
        this.valor = valor;
        this.base = base;
    }

    public Compactador(int id, String nome, double peso, double valor, int base) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.valor = valor;
        this.base = base;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + " - Peso: " + getPeso() + "kg - Valor: R$" + getValor();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }
}
