package model;

public class Conta {
    private int id;
    private String numeroConta;
    private String nomeTitular;
    private String cpf;
    private boolean ativo;
    private double saldo;

    public Conta() {}

    public Conta(int id, String numeroConta, String nomeTitular, String cpf, boolean ativo, double saldo) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.cpf = cpf;
        this.ativo = ativo;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
