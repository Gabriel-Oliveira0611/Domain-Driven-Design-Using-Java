package br.com.fiap.building.model;

public class Elevador {
    private int andarAtual;
    private int totalAndares;
    private int capacidadePessoas;
    private int quantidadeAtualPessoas;

    //Aula inicial
    public void inicializa (int capacidadePessoas, int totalAndares) {
        this.capacidadePessoas = capacidadePessoas;
        this.totalAndares = totalAndares;
    }

    // Métodos
    public int entra() {
        if (getCapacidadePessoas() < capacidadePessoas) {
            int maisPessoas = quantidadeAtualPessoas++;
        } else {
            System.out.println("A capacidade máxima não pode ser excedida.");
        }
        return quantidadeAtualPessoas;
    }

    public int sai() {
        if (getCapacidadePessoas() > 0) {
            int menosPessoas = quantidadeAtualPessoas--;
        } else {
            System.out.println("Não existem pessoas no elevador.");
        }
        return quantidadeAtualPessoas;
    }

    public boolean sobe() {
        if ((andarAtual + 1) <  totalAndares) {
            int subirAndar = andarAtual++;
            return true;
        } else {
            return false;
        }
    }

    public boolean desce() {
        if (andarAtual > 0) {
            int descerAndar = andarAtual--;
            return true;
        } else {
            return false;
        }
    }

    // Prática Apostila07
    public void construtor(int capacidadePessoas, int totalAndares) {
        this.capacidadePessoas = capacidadePessoas;
        this.totalAndares = totalAndares;
    }

    //Getters and Setters
    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public int getTotalAndares() {
        return totalAndares;
    }

    public void setTotalAndares(int totalAndares) {
        this.totalAndares = totalAndares;
    }

    public int getCapacidadePessoas() {
        return capacidadePessoas;
    }

    public void setCapacidadePessoas(int capacidadePessoas) {
        this.capacidadePessoas = capacidadePessoas;
    }

    public int getQuantidadeAtualPessoas() {
        return quantidadeAtualPessoas;
    }

    public void setQuantidadeAtualPessoas(int quantidadeAtualPessoas) {
        this.quantidadeAtualPessoas = quantidadeAtualPessoas;
    }
}
