package br.com.fiap.apostila12.model;

import br.com.fiap.apostila12.exception.CupomInvalidoException;
import br.com.fiap.apostila12.exception.DescontoAcimaDoPrecoException;
import br.com.fiap.apostila12.exception.PorcentagemNegativaException;

public class Produto {

    private String nome;
    private double preco;

    public Produto() {}

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public double darDesconto(String cupom) throws CupomInvalidoException {
//        O cupom não pode ser vazio
//        E tem que conter mais de 5 caracteres
//        Lançar CupomInvalidoException
//        Validar se o cupom FIAP20 -> 20% de desconto
        if (cupom.equals("")) {
            throw new CupomInvalidoException("O texto do cupom não pode ser vazio.");
        } else if (cupom.length() < 5) {
            throw new CupomInvalidoException("O cupom deve conter mais que 5 caracteres.");
        } else if (cupom.equals("FIAP20")) {
            return preco * 0.8;
        }

        return preco;
    }

    public double aumentarImposto(double porcentagem) throws PorcentagemNegativaException {
//Não pode ser negativa a porcentagem
//        Se for negativo, lança a exception PorcentagemNegativaException
        if (porcentagem < 0) {
            throw new PorcentagemNegativaException("A porcentagem não pode ser menor que 0");
        } else {
            return preco + (preco * (porcentagem / 100));
        }
    }

    public double darDesconto(double desconto) {
//        Validar se o desconto é maior que o preco
        if (desconto > preco) {
            throw new DescontoAcimaDoPrecoException("O desconto é maior que o preço.");
        }

//        Validar se o desconto é positivo
        if (desconto < 0) {
            throw new RuntimeException("O desconto é negativo.");
        }

        return preco - desconto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
