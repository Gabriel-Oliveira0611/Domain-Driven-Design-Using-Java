package br.com.fiap.financeiro.model;

public class ContaCorrente {
    public Cliente cliente;
    public double saldo;

    public double depositar(double aumentarSaldo) {
        return saldo += aumentarSaldo;
    }

    public double retirar(double diminuirSaldo){
        return saldo -= diminuirSaldo;
    }

    public double retornarSaldo(){
        return saldo;
    }


}
