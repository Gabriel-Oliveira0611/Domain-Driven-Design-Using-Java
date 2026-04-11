package br.com.restaurante.model;

public class Funcionario {

    private String nome;
    private int id;
    private boolean ativo;
    private double salario;
    private char sexo;


    public String retornarSalario() {
        return formatarReal(salario);
    }

    public String retornarPlr() {
        double plr = calcularPlr();
        return formatarReal(plr);
    }

    private String formatarReal(double valor) {
        return "R$" + valor;
    }

    public double calcularPlr() {
        return salario * 10;
    }

    public void colocarEmFerias() {

    }

    //getters e Setters - Nome
    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //getters e Setters - id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //getters e Setters - ativo
    public boolean getAtivo() {
        return ativo;
    }

    public void setBoolean(boolean ativo) {
        this.ativo = ativo;
    }

    //getters e Setters - sexo
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    //getters e Setters - salario
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
